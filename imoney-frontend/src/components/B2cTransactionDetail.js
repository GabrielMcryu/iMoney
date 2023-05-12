import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

import { getB2cById } from '../services/B2CTransactionService';

function B2cTransactionDetail() {
    const { id } = useParams();
    const navigate = useNavigate();

    const [b2cTransaction, setB2cTransaction] = useState({
        b2cId: id,
        senderAccount: 0,
        merchant: "",
        commandID: "",
        amount: "",
        partyB: "",
        remarks: "",
        occassion: "",
        conversationID: "",
        originatorConversationID: "",
        responseCode: "",
        responseDescription: ""
    })

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getB2cById(b2cTransaction.b2cId);
                setB2cTransaction(response.data);
            } catch(error) {
                console.log(error);
            }
        };
        fetchData();
    }, [])

  return (
    <div className='container'>
        <h1>B2C Transaction Detail</h1>
        <div className='back-btn-section'>
            <button className='submit-btn' onClick={() => navigate("/b2cTransactions")}>Back</button>
        </div>
        <div className='details-section'>
            <div className='details'>
                <p>Sender Account:</p>
                <p>{b2cTransaction.senderAccount}</p>
            </div>
            <div className='details'>
                <p>Merchant:</p>
                <p>{b2cTransaction.merchant}</p>
            </div>
            <div className='details'>
                <p>CommandID:</p>
                <p>{b2cTransaction.commandID}</p>
            </div>
            <div className='details'>
                <p>Amount:</p>
                <p>{b2cTransaction.amount}</p>
            </div>
            <div className='details'>
                <p>Party B:</p>
                <p>{b2cTransaction.partyB}</p>
            </div>
            <div className='details'>
                <p>Remarks:</p>
                <p>{b2cTransaction.remarks}</p>
            </div>
            <div className='details'>
                <p>Occassion:</p>
                <p>{b2cTransaction.occassion}</p>
            </div>
            <div className='details'>
                <p>ConversationID:</p>
                <p>{b2cTransaction.conversationID}</p>
            </div>
            <div className='details'>
                <p>Originator ConversationID:</p>
                <p>{b2cTransaction.originatorConversationID}</p>
            </div>
            <div className='details'>
                <p>Response Code:</p>
                <p>{b2cTransaction.responseCode}</p>
            </div>
            <div className='details'>
                <p>Response Description:</p>
                <p>{b2cTransaction.responseDescription}</p>
            </div>
        </div>
    </div>
  )
}

export default B2cTransactionDetail