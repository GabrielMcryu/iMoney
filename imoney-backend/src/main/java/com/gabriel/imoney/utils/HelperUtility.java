package com.gabriel.imoney.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperUtility {

	private static final Logger log = LoggerFactory.getLogger(HelperUtility.class);
	
	public static String toBase64String(String value) {
		byte[] data = value.getBytes(StandardCharsets.ISO_8859_1);
		return Base64.getEncoder().encodeToString(data);
	}
}
