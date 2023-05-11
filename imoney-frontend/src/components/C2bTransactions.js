import React, { useState } from 'react'

import { saveC2BTransaction } from '../services/C2BTransactionService';
import { useNavigate } from 'react-router-dom';

const C2bTransactions = () => {
    const navigate = useNavigate();

    const [searchc2bTransactions, setSearchc2bTransactions] = useState({
        accountNumber: 0
    });

    const handleSearchChange = (e) => {
        const value = e.target.value;

        setSearchc2bTransactions({...searchc2bTransactions, [e.target.name]: value})
    }

    const [c2bTransaction, setC2bTransaction] = useState({
        SenderName: "",
        Merchant: "Mpesa",
        ReceiverAccountNumber: 0,
        ShortCode: 600991,
        CommandID: "CustomerPayBillOnline",
        Msisdn: 0,
        Amount: "",
        BillRefNumber: "3234"
    });

    const handleChange = (e) => {
        const value = e.target.value;

        setC2bTransaction({...c2bTransaction, [e.target.name]: value});
    }

    const saveAC2BTransaction = (e) => {
        e.preventDefault();
        saveC2BTransaction(c2bTransaction)
            .then((response) => {
                console.log(response);
            })
            .catch((error) => {
                console.log(error);
            })
    }

    const goToViewc2bTransactions = (e) => {
        e.preventDefault();
        navigate(`/getc2bTransactions/${searchc2bTransactions.accountNumber}`)
    }

    const resetSearch = (e) => {
        e.preventDefault();
        setSearchc2bTransactions({
          accountNumber: 0
        });
    }

    const reset = (e) => {
        e.preventDefault();
        setC2bTransaction({
            SenderName: "",
            Merchant: "Mpesa",
            ReceiverAccountNumber: 0,
            ShortCode: 600991,
            CommandID: "CustomerPayBillOnline",
            Msisdn: 0,
            Amount: "",
            BillRefNumber: "3234"
        });
    }

  return (
    <>
        <div className='container'>
            <h1>C2B Transactions</h1>
            <div className="search-option">
                <input
                type="text"
                name="accountNumber"
                placeholder='Enter Account Number'
                value={searchc2bTransactions.accountNumber}
                onChange={(e) => handleSearchChange(e)}
                className="search-field"
                />
                <button className='submit-btn' id="search-btn" onClick={goToViewc2bTransactions}>Search</button>
                <button className='submit-btn' onClick={resetSearch}>Clear</button>
            </div>

            <div className='form-div'>
                <h2 className='form-header'>Create C2B Transaction</h2>
                <div>
                    <label className='form-label'>
                        Your Name:
                    </label>
                    <input
                        type="text"
                        name="SenderName"
                        value={c2bTransaction.SenderName}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Your Phone Number:
                    </label>
                    <input
                        type="number"
                        name="Msisdn"
                        value={c2bTransaction.Msisdn}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Receiver Account Number:
                    </label>
                    <input
                        type="number"
                        name="ReceiverAccountNumber"
                        value={c2bTransaction.ReceiverAccountNumber}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Amount:
                    </label>
                    <input
                        type="number"
                        name="Amount"
                        value={c2bTransaction.Amount}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <button className='submit-btn' onClick={saveAC2BTransaction}>Save</button>
                    <button className='submit-btn' onClick={reset}>Clear</button>
                </div>
            </div>
        </div>
    </>
  )
}

export default C2bTransactions