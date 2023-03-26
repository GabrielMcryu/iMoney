import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

import { getTransactionByAccountNumber } from '../services/TransactionService';

import './GetTransactionsByAccountNumberStyles.css';
import Transaction from './Transaction';

const GetTransactionsByAccountNumber = () => {

  const { merchant } = useParams();
  const { accountNumber } = useParams();
  const navigate = useNavigate();

  const [loading, setLoading] = useState(true);
  const [transactions, setTransactions] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await getTransactionByAccountNumber(merchant, accountNumber);
        setTransactions(response.data);
      } catch (error) {
        console.log(error)
      }
      setLoading(false)
    };
    fetchData();
  }, []);

  return (
    <>
      <h1>Transactions</h1>
      <div className='form-div'>
        <button onClick={() => navigate("/")}>Back</button>
        <br /><br />
      </div>
        <table>
          <thead>
            <tr>
              <th>Sender Name</th>
              <th>Account Number</th>
              <th>Amount</th>
              <th>Merchant</th>
            </tr>
          </thead>
          {!loading && (
            <tbody>
              {transactions.map((transaction) => (
                <Transaction
                  transaction={transaction} 
                  key={transaction.transactionId} />
              ))}
            </tbody>
          )}
        </table>
      
    </>
  )
}

export default GetTransactionsByAccountNumber