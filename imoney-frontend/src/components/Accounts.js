import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

import { saveAccount } from '../services/AccountService';

const Accounts = () => {
    const navigate = useNavigate();

    const [searchAccount, setSearchAccount] = useState({
        id: 0
    })

    const handleSearchChange = (e) => {
        const value = e.target.value;

        setSearchAccount({...searchAccount, [e.target.name]: value})
    }

    const [account, setAccount] = useState({
        firstName: "",
        lastName: "",
        balance: 0,
        phoneNumber: "",
        birthDate: ""
    });

    const handleChange = (e) => {
        const value = e.target.value;

        setAccount({...account, [e.target.name]: value});
    }

    const saveAnAccount = (e) => {
        e.preventDefault();
        saveAccount(account)
            .then((response) => {
                console.log(response);
            })
            .catch((error) => {
                console.log(error);
            })
    }

    const goToAccount = (e) => {
        e.preventDefault();
        navigate(`/account/${searchAccount.id}`)
    }

    const resetSearch = (e) => {
        e.preventDefault();
        setSearchAccount({
            id: 0
        })
    }

    const reset = (e) => {
        e.preventDefault();
        setAccount({
            firstName: "",
            lastName: "",
            balance: 0,
            phoneNumber: 0,
            birthDate: ""
        })
    }

  return (
    <>
        <h1>Accounts</h1>
        <div className="search-option">
            <input
                type="text"
                name="id"
                placeholder='Enter Account Number'
                value={searchAccount.id}
                onChange={(e) => handleSearchChange(e)}
                className=""
            />
            <button className="btn-search" id="search-btn" onClick={goToAccount}>Search</button>
            <button onClick={resetSearch}>Clear</button>
        </div>

        <h2>Create An Account</h2>
        <div className='form-div'>
            <div>
                <label>
                    First Name:
                </label>
                <input
                    type="text"
                    name="firstName"
                    value={account.firstName}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
                <label>
                    Last Name:
                </label>
                <input
                    type="text"
                    name="lastName"
                    value={account.lastName}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
                <label>
                    Phone Number:
                </label>
                <input
                    type="number"
                    name="phoneNumber"
                    value={account.phoneNumber}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
                <label>
                    Date of Birth:
                </label>
                <input
                    type="date"
                    name="birthDate"
                    value={account.birthDate}
                    onChange={(e) => handleChange(e)}
                    className=""
                />
            </div>
            <div>
                <button onClick={saveAnAccount}>Save</button>
                <button onClick={reset}>Clear</button>
            </div>
        </div>
    </>
  )
}

export default Accounts