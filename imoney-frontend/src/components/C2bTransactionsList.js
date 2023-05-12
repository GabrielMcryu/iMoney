import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

import { getC2BTransactionByAccountNumber } from '../services/C2BTransactionService';
import C2bTransaction from './C2bTransaction';

const C2bTransactionsList = () => {
    const { accountNumber } = useParams();
    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [c2bTransactions, setc2bTransactions] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await getC2BTransactionByAccountNumber(accountNumber);
                setc2bTransactions(response.data);
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
            <h1>C2B Transactions</h1>
            <div className='back-btn-section'>
                <button className='submit-btn' onClick={() => navigate("/c2bTransactions")}>Back</button>
            </div>
            <table className='tb-style'>
                <thead>
                    <tr>
                        <th>Sender Name</th>
                        <th>Mercant</th>
                        <th>Receiver Account</th>
                        <th>Amount</th>
                        <th>Action</th>
                    </tr>
                </thead>
                {!loading && (
                    <tbody>
                        {c2bTransactions.map((c2bTransaction) => (
                            <C2bTransaction 
                                c2bTransaction={c2bTransaction}
                                key={c2bTransaction.c2bId}
                            />
                        ))}
                    </tbody>
                )}
            </table>
        </div>
    </>
  )
}

export default C2bTransactionsList