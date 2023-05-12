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
        <div className='container bt-spacing'>
            <h1>Imoney Transactions</h1>
            <div className='back-btn-section'>
                <button className='submit-btn' onClick={() => navigate("/imoneyTransactions")}>Back</button>
            </div>
            <table className='tb-style'>
                <thead>
                    <tr>
                        <th>Sender Account</th>
                        <th>Receiver Account</th>
                        <th>Amount</th>
                        <th>Action</th>
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
        </div>
    </>
  )
}

export default ITransactionsList