import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { saveTransaction } from '../services/TransactionService'

import './CreateTransactionStyles.css'

const CreateTransaction = () => {

    const [transaction, setTransaction] = useState({
        senderName: "",
        accountNumber: "",
        amount: 0,
        merchant: ""
    })

    const navigate = useNavigate();

    const handleChange = (e) => {
        const value = e.target.value;
        
        setTransaction({...transaction, [e.target.name]: value});
    }

    const saveATransaction = (e) => {
        e.preventDefault();
        saveTransaction(transaction)
            .then((response) => {
                navigate("/");
            })
            .catch((error) => {
                console.log(error);
            })
    }

    const reset = (e) => {
        e.preventDefault();
        setTransaction({
            senderName: "",
            accountNumber: "",
            amount: 0,
            merchant: ""
        });
    }

  return (
    <>
        <h1>CreateTransaction</h1>
        <div className='form-div'>
            <div>
                <label>
                    Sender Name:
                </label>
                <input
                    type="text"
                    name="senderName"
                    value={transaction.senderName}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
                <label>
                    Account Number:
                </label>
                <input
                    type="text"
                    name="accountNumber"
                    value={transaction.accountNumber}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
                <label>
                    Amount:
                </label>
                <input
                    type="number"
                    name="amount"
                    value={transaction.amount}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
                <label>
                    Merchant:
                </label>
                <select className="select-field" onChange={(e) => handleChange(e)} name="merchant" id="search-choice" value={transaction.merchant}>
                    <option value="">Select Merchant</option>
                    <option value="Paypal">Paypal</option>
                    <option value="NCBA">NCBA</option>
                </select>
            </div>
            <div>
                <button onClick={saveATransaction}>Save</button>
                <button onClick={reset}>Clear</button>
            </div>
        </div>
    </>
  )
}

export default CreateTransaction