import axios from "axios";

const TRANSACTION_API_BASE_URL = "http://localhost:8080/api/v1/transactions";

class TransactionService {
    saveTransaction(transaction) {
        return axios.post(TRANSACTION_API_BASE_URL, transaction);
    }
}

export default new TransactionService();