import React, { useState } from 'react'

import { saveB2CTransaction } from '../services/B2CTransactionService'
import { useNavigate } from 'react-router-dom';

const B2cTransactions = () => {
    const navigate = useNavigate();

    const [searchb2cTransactions, setSearchb2cTransactions] = useState({
        accountNumber: 0
    })

    const handleSearchChange = (e) => {
        const value = e.target.value;

        setSearchb2cTransactions({...searchb2cTransactions, [e.target.name]: value})
    }

    const [b2cTransaction, setB2cTransaction] = useState({
        SenderAccount: 0,
        Merchant: "Mpesa",
        CommandID: "BusinessPayment",
        Amount: "",
        PartyB: "",
        Remarks: "",
        Occassion: ""
    });

    const handleChange = (e) => {
        const value = e.target.value;

        setB2cTransaction({...b2cTransaction, [e.target.name]: value});
    }

    const saveAB2CTransaction = (e) => {
        e.preventDefault();
        saveB2CTransaction(b2cTransaction)
            .then((response) => {
                console.log(response);
            })
            .catch((error) => {
                console.log(error);
            })
    }

    const goToViewb2cTransactions = (e) => {
        e.preventDefault();
        navigate(`/getb2cTransactions/${searchb2cTransactions.accountNumber}`)
    }

    const resetSearch = (e) => {
        e.preventDefault();
        setSearchb2cTransactions({
            accountNumber: 0
        })
    }

    const reset = (e) => {
        e.preventDefault();
        setB2cTransaction({
            SenderAccount: 0,
            Merchant: "Mpesa",
            CommandID: "BusinessPayment",
            Amount: "",
            PartyB: "",
            Remarks: "",
            Occassion: ""
        });
    }

  return (
    <>
        <div className='container'>
            <h1>B2C Transactions</h1>
            <div className="search-option">
            <input
                type="text"
                name="accountNumber"
                placeholder='Enter Account Number'
                value={searchb2cTransactions.accountNumber}
                onChange={(e) => handleSearchChange(e)}
                className="search-field"
            />
            <button className='submit-btn' id="search-btn" onClick={goToViewb2cTransactions}>Search</button>
            <button className='submit-btn' onClick={resetSearch}>Clear</button>
            </div>

            <div className='form-div'>
                <h2 className='form-header'>Create B2C Transaction</h2>
                <div>
                    <label className='form-label'>
                        Sender Account Number:
                    </label>
                    <input
                        type="number"
                        name="SenderAccount"
                        value={b2cTransaction.SenderAccount}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Receiver Phone Number:
                    </label>
                    <input
                        type="text"
                        name="PartyB"
                        value={b2cTransaction.PartyB}
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
                        value={b2cTransaction.Amount}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Remarks:
                    </label>
                    <input
                        type="text"
                        name="Remarks"
                        value={b2cTransaction.Remarks}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Occassion:
                    </label>
                    <input
                        type="text"
                        name="Occassion"
                        value={b2cTransaction.Occassion}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                <div>
                    <button className='submit-btn' onClick={saveAB2CTransaction}>Save</button>
                    <button className='submit-btn' onClick={reset}>Clear</button>
                </div>
                </div>
            </div>
        </div>
    </>
  )
}

export default B2cTransactions