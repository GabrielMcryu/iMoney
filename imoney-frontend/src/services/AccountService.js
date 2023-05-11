import axios from "axios";

const ACCOUNT_API_BASE_URL = "http://localhost:8080/api/v1/accounts";

export const saveAccount = (account) => {
    return axios.post(ACCOUNT_API_BASE_URL, account);
}

export const getAccountById = (id) => {
    return axios.get(ACCOUNT_API_BASE_URL + "/" + id);
}
