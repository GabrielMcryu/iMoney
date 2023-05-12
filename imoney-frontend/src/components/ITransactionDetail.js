import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

import { getITransactionById } from '../services/ITransactionService';

function ITransactionDetail() {
    const { id } = useParams();
    const navigate = useNavigate();

    const [iTransaction, setITransaction] = useState({
        transactionId: id,
        senderName: "",
        accountNumber: 0,
        amount: 0,
        merchant: "",
        createdAt: ""
    })

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getITransactionById(iTransaction.transactionId);
                setITransaction(response.data);
            } catch(error) {
                console.log(error);
            }
        };
        fetchData();
    }, []);

  return (
    <div className='container'>
        <h1>IMoney Transaction Detail</h1>
        <div className='back-btn-section'>
            <button className='submit-btn' onClick={() => navigate("/imoneyTransactions")}>Back</button>
        </div>
        <div className='details-section'>
            <div className='details'>
                <p>Sender Name:</p>
                <p>{iTransaction.senderName}</p>
            </div>
            <div className='details'>
                <p>Account Number:</p>
                <p>{iTransaction.accountNumber}</p>
            </div>
            <div className='details'>
                <p>Amount:</p>
                <p>{iTransaction.amount}</p>
            </div>
            <div className='details'>
                <p>Merchant:</p>
                <p>{iTransaction.merchant}</p>
            </div>
            <div className='details'>
                <p>Transaction Date:</p>
                <p>{new Date(iTransaction.createdAt).toLocaleDateString()}</p>
            </div>
        </div>
    </div>
  )
}

export default ITransactionDetail