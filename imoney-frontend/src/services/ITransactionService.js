import axios from "axios";

const I_TRANSACTION_API_BASE_URL = "http://localhost:8080/api/v1/itransaction";

export const saveITransaction = (itransaction) => {
    return axios.post(I_TRANSACTION_API_BASE_URL + "s", itransaction);
}

export const getITransactionByAccountNumber = (accountNumber) => {
    return axios.get(I_TRANSACTION_API_BASE_URL + "/" + accountNumber);
}

export const getITransactionById = (id) => {
    return axios.get(I_TRANSACTION_API_BASE_URL + "/" + "details" + "/" + id);
}