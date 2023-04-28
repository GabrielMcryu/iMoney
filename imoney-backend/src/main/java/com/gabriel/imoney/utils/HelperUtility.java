package com.gabriel.imoney.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HelperUtility {

	private static final Logger log = LoggerFactory.getLogger(HelperUtility.class);
	
	public static String toBase64String(String value) {
		byte[] data = value.getBytes(StandardCharsets.ISO_8859_1);
		return Base64.getEncoder().encodeToString(data);
	}
	
	public static String toJson(Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch(JsonProcessingException exception) {
			return null;
		}
	}
	
	public static String getSecurityCredentials(String initiatorPassword) throws Exception {
		String encryptedPassword;
		
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			byte[] input = initiatorPassword.getBytes();
			
			Resource resource = new ClassPathResource("cert.cer");
			InputStream inputStream = resource.getInputStream();
			
			FileInputStream fin = new FileInputStream(resource.getFile());
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate certificate = (X509Certificate) cf.generateCertificate(fin);
			PublicKey pk = certificate.getPublicKey();
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			
			byte[] cipherText = cipher.doFinal(input);
			
			encryptedPassword = Base64.getEncoder().encodeToString(cipherText).trim();
			return encryptedPassword;
		} catch (NoSuchAlgorithmException | CertificateException | InvalidKeyException | NoSuchPaddingException |
                IllegalBlockSizeException | BadPaddingException | NoSuchProviderException | FileNotFoundException e) {
            log.error(String.format("Error generating security credentials ->%s", e.getLocalizedMessage()));
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
	}
}
