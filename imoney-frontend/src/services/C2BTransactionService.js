import axios from "axios";

const C2B_TRANSACTION_API_BASE_URL = "http://localhost:8080/api/v1/";

export const saveC2BTransaction = (c2bTransaction) => {
    return axios.post(C2B_TRANSACTION_API_BASE_URL + "create-c2b-transaction", c2bTransaction);
}

export const getC2BTransactionByAccountNumber = (accountNumber) => {
    return axios.get(C2B_TRANSACTION_API_BASE_URL + "c2b-transaction" + "/" + accountNumber);
}

export const getC2bById = (id) => {
    return axios.get(C2B_TRANSACTION_API_BASE_URL + "c2b-transaction" + "/" + "details" + "/" + id);
}