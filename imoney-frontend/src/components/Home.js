import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

import './HomeStyles.css';

const Home = () => {
  const [transaction, setTransaction] = useState({
    accountNumber: "",
    merchant: ""
  });

  const handleChange = (e) => {
    const value = e.target.value;
    
    setTransaction({...transaction, [e.target.name]: value});
  }

  const navigate = useNavigate();

  const goToViewTransactions = (e) => {
    e.preventDefault();
    navigate(`/getTransactionsByAcountNumber/${transaction.merchant}/${transaction.accountNumber}`);
  }

  const reset = (e) => {
    e.preventDefault();
    setTransaction({
      accountNumber: "",
      merchant: ""
    });
}

  return (
    <>
      <h1>Home</h1>
      <div className="search-option">
        <input
          type="text"
          name="accountNumber"
          value={transaction.accountNumber}
          onChange={(e) => handleChange(e)}
          className=""
        />
        <select className="select-field" onChange={(e) => handleChange(e)} name="merchant" id="search-choice" value={transaction.merchant}>
          <option value="">Select Merchant</option>
          <option value="Paypal">Paypal</option>
          <option value="NCBA">NCBA</option>
        </select>
        <button className="btn-search" id="search-btn" onClick={goToViewTransactions}>Search</button>
        <button onClick={reset}>Clear</button>
      </div>
      <div className="search-option">
        <button className="btn-search" id="search-btn" onClick={() => navigate("/createTransaction")}>Make a Transaction</button>
      </div>
      <div className="search-option">
        <ul>
          <li><a href="#">Search Account</a></li>
          <li><a href="/imoneyTransactions">iMoney Transactions</a></li>
          <li><a href="/c2bTransactions">C2B Transactions</a></li>
          <li><a href="/b2cTransactions">B2C Transactions</a></li>
        </ul>
      </div>
    </>
  )
}

export default Home