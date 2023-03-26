import axios from "axios";

const TRANSACTION_API_BASE_URL = "http://localhost:8080/api/v1/transactions";

export const saveTransaction = (transaction) => {
    return axios.post(TRANSACTION_API_BASE_URL, transaction);
}

export const getTransactionByAccountNumber = (merchant, accountNumber) => {
    return axios.get(TRANSACTION_API_BASE_URL + "/" + merchant + "/" + accountNumber);
}

