import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom'

import { getAccountById } from '../services/AccountService';

function Account() {

  const { id } = useParams();
  const navigate = useNavigate();
  const [account, setAccount] = useState({
    accountId: id,
    firstName: "",
    lastName: "",
    balance: 0,
    phoneNumber: "",
    birthDate: ""

  })

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await getAccountById(account.accountId);
        setAccount(response.data);
        console.log(response.data);
      } catch(error) {
        console.log(error);
      }
    };
    fetchData();
  }, []);

  return (
    <div className='container'>
      <h1>Account Details</h1>
      <div className='back-btn-section'>
          <button className='submit-btn' onClick={() => navigate("/accounts")}>Back</button>
      </div>
      <div className='details-section'>
        <div className='details'>
          <p>First Name:</p>
          <p>{account.firstName}</p>
        </div>
        <div className='details'>
          <p>Last Name:</p>
          <p>{account.lastName}</p>
        </div>
        <div className='details'>
          <p>Balance:</p>
          <p>{account.balance}</p>
        </div>
        <div className='details'>
          <p>Phone Number:</p>
          <p>{account.phoneNumber}</p>
        </div>
        <div className='details'>
          <p>Date of Birth:</p>
          <p>{new Date(account.birthDate).toLocaleDateString()}</p>
        </div>
      </div>
    </div>
  )
}

export default Account