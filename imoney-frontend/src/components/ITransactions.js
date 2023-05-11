import React, { useState } from 'react'

import { saveITransaction } from '../services/ITransactionService';

import './ITransactionsStyles.css';
import { useNavigate } from 'react-router-dom';

const ITransactions = () => {
  const navigate = useNavigate();

  const [searchITransactions, setSearchITransaction] = useState({
    accountNumber: 0
  });

  const handleSearchChange = (e) => {
    const value = e.target.value;

    setSearchITransaction({...searchITransactions, [e.target.name]: value});
  }

  const [itransaction, setItransaction] = useState({
    senderAccount: 0,
    receiverAccount: 0,
    amount: 0
  });

  const handleChange = (e) => {
    const value = e.target.value;
    
    setItransaction({...itransaction, [e.target.name]: value});
  }

  const saveAnITransaction = (e) => {
    e.preventDefault();
    saveITransaction(itransaction)
        .then((response) => {
          console.log(response);
          // reset();
        })
        .catch((error) => {
            console.log(error);
        })
  }

  const goToViewITransactions = (e) => {
    e.preventDefault();
    navigate(`/getImoneyTransactions/${searchITransactions.accountNumber}`)
  }

  const resetSearch = (e) => {
    e.preventDefault();
    setSearchITransaction({
      accountNumber: 0
    });
  }

  const reset = (e) => {
    e.preventDefault();
    setItransaction({
      senderAccount: 0,
      receiverAccount: 0,
      amount: 0
    });
  }

  return (
    <>
      <h1>ITransactions</h1>
      <div className="search-option">
        <input
          type="text"
          name="accountNumber"
          placeholder='Enter Account Number'
          value={searchITransactions.accountNumber}
          onChange={(e) => handleSearchChange(e)}
          className=""
        />
        <button className="btn-search" id="search-btn" onClick={goToViewITransactions}>Search</button>
        <button onClick={resetSearch}>Clear</button>
      </div>

      <h2>Create Imoney Transaction</h2>
      <div className='form-div'>
            <div>
                <label>
                    Sender Account Number:
                </label>
                <input
                    type="number"
                    name="senderAccount"
                    value={itransaction.senderAccount}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
                <label>
                    Receiver Account Number:
                </label>
                <input
                    type="number"
                    name="receiverAccount"
                    value={itransaction.receiverAccount}
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
                    value={itransaction.amount}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
              <button onClick={saveAnITransaction}>Save</button>
              <button onClick={reset}>Clear</button>
            </div>
        </div>
    </>
  )
}

export default ITransactions