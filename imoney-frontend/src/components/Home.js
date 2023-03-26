import React from 'react'
import { useNavigate } from 'react-router-dom';

import './HomeStyles.css';

const Home = () => {
  const navigate = useNavigate();

  return (
    <>
      <h1>Home</h1>
      <div className="search-option">
        <input type="text" name="search" placeholder="Enter account number" id="search-input"></input>
        <select className="select-field" name="choices" id="search-choice">
          <option value="Paypal">Paypal</option>
          <option value="NCBA">NCBA</option>
        </select>
        <button className="btn-search" id="search-btn">Search</button>
      </div>
      <div className="search-option">
        <button className="btn-search" id="search-btn" onClick={() => navigate("/createTransaction")}>Make a Transaction</button>
      </div>
    </>
  )
}

export default Home