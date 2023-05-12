import React, { useEffect, useState } from 'react'

import { getb2cTransactionByAccountNumber } from '../services/B2CTransactionService'
import B2cTransaction from './B2cTransaction'
import { useNavigate, useParams } from 'react-router-dom'

function B2cTransactionsList() {
    const { accountNumber } = useParams();
    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [b2cTransactions, setb2cTransactions] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await getb2cTransactionByAccountNumber(accountNumber);
                setb2cTransactions(response.data);
            } catch (error) {
                console.log(error);
            }
            setLoading(false);
        };
        fetchData();
    }, []);

  return (
    <>
        <div className='container'>
            <h1>B2C Transactions</h1>
            <div className='back-btn-section'>
                <button className='submit-btn' onClick={() => navigate("/b2cTransactions")}>Back</button>
            </div>
            <table className='tb-style'>
                <thead>
                    <tr>
                        <th>Sender Account</th>
                        <th>Merchant</th>
                        <th>Amount</th>
                        <th>Receiver Phone Number</th>
                        <th>Occassion</th>
                        <th>Action</th>
                    </tr>
                </thead>
                {!loading && (
                    <tbody>
                        {b2cTransactions.map((b2cTransaction) => (
                            <B2cTransaction 
                                b2cTransaction={b2cTransaction}
                                key={b2cTransaction.b2cId}
                            />
                        ))}
                    </tbody>
                )}
            </table>
        </div>
    </>
  )
}

export default B2cTransactionsList