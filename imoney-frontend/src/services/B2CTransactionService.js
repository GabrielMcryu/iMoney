import axios from "axios";

const B2C_TRANSACTION_API_BASE_URL = "http://localhost:8080/api/v1/";

export const saveB2CTransaction = (b2cTransaction) => {
    return axios.post(B2C_TRANSACTION_API_BASE_URL + "create-b2c-transaction", b2cTransaction);
}

export const getb2cTransactionByAccountNumber = (accountNumber) => {
    return axios.get(B2C_TRANSACTION_API_BASE_URL + "b2c-transaction" + "/" + accountNumber);
}