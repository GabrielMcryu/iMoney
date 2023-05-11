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
      <div className="container grid-links">
        <div className="dash-links"><a className="dash-link" href="/accounts">Search Account</a></div>
        <div className="dash-links"><a className="dash-link" href="/imoneyTransactions">iMoney Transactions</a></div>
        <div className="dash-links"><a className="dash-link" href="/c2bTransactions">C2B Transactions</a></div>
        <div className="dash-links"><a className="dash-link" href="/b2cTransactions">B2C Transactions</a></div>
      </div>
    </>
  )
}

export default Home