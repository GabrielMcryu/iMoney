import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

import { getITransactionByAccountNumber } from '../services/ITransactionService';
import ITransaction from './ITransaction';

const ITransactionsList = () => {
    const { accountNumber } = useParams();
    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [iTransactions, setITransactions] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await getITransactionByAccountNumber(accountNumber);
                setITransactions(response.data);
            } catch (error) {
                console.log(error)
            }
            setLoading(false)
        };
        fetchData();
    }, []);

  return (
    <>
        <h1>Imoney Transactions</h1>
        <div className='form-div'>
            <button onClick={() => navigate("/imoneyTransactions")}>Back</button>
            <br /><br />
        </div>
        <table>
            <thead>
                <tr>
                    <th>Sender Account</th>
                    <th>Receiver Account</th>
                    <th>Amount</th>
                </tr>
            </thead>
            {!loading && (
                <tbody>
                    {iTransactions.map((iTransaction) => (
                        <ITransaction
                            iTransaction={iTransaction}
                            key={iTransaction.iTransation}
                        />
                    ))}
                </tbody>
            )}
        </table>
    </>
  )
}

export default ITransactionsList