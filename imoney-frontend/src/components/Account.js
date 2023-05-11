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
    <div className='search-option'>
      <ul>
        <li>First Name: {account.firstName}</li>
        <li>Last Name: {account.lastName}</li>
        <li>Balance: {account.balance}</li>
        <li>Phone number: {account.phoneNumber}</li>
        <li>Birth Date: {new Date(account.birthDate).toLocaleDateString()}</li>
      </ul>
    </div>
  )
}

export default Account