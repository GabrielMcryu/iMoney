import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

import { getC2bById } from '../services/C2BTransactionService';

function C2bTransactionDetail() {
    const { id } = useParams();
    const navigate = useNavigate();

    const [c2bTransaction, setC2bTransaction] = useState({
        c2bId: id,
        senderName: "",
        merchant: "",
        receiverAccountNumber: 0,
        shortCode: "",
        msisdn: "254708374149",
        billRefNumber: "",
        amount: "",
        commandID: "",
        responseDescription: "",
        responseCode: "",
        originatorCoversationID: ""
    })

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getC2bById(c2bTransaction.c2bId);
                setC2bTransaction(response.data);
            } catch(error) {
                console.log(error);
            }
        };
        fetchData();
    }, [])

  return (
    <div className='container'>
        <h1>C2B Transaction Detail</h1>
        <div className='back-btn-section'>
            <button className='submit-btn' onClick={() => navigate("/c2bTransactions")}>Back</button>
        </div>
        <div className='details-section'>
            <div className='details'>
                <p>Sender Name:</p>
                <p>{c2bTransaction.senderName}</p>
            </div>
            <div className='details'>
                <p>Merchant:</p>
                <p>{c2bTransaction.merchant}</p>
            </div>
            <div className='details'>
                <p>Receiver Account Number:</p>
                <p>{c2bTransaction.receiverAccountNumber}</p>
            </div>
            <div className='details'>
                <p>Short Code:</p>
                <p>{c2bTransaction.shortCode}</p>
            </div>
            <div className='details'>
                <p>Msisdn:</p>
                <p>{c2bTransaction.msisdn}</p>
            </div>
            <div className='details'>
                <p>Bill Ref Number:</p>
                <p>{c2bTransaction.billRefNumber}</p>
            </div>
            <div className='details'>
                <p>Amount:</p>
                <p>{c2bTransaction.amount}</p>
            </div>
            <div className='details'>
                <p>CommandID:</p>
                <p>{c2bTransaction.commandID}</p>
            </div>
            <div className='details'>
                <p>Response Description:</p>
                <p>{c2bTransaction.responseDescription}</p>
            </div>
            <div className='details'>
                <p>Response Code:</p>
                <p>{c2bTransaction.responseCode}</p>
            </div>
            <div className='details'>
                <p>Originator CoversationID:</p>
                <p>{c2bTransaction.originatorCoversationID}</p>
            </div>
        </div>
    </div>
  )
}

export default C2bTransactionDetail