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
        <div className='container'>
            <h1>Accounts</h1>
            <div className="search-option">
                <input
                    type="text"
                    name="id"
                    placeholder='Enter Account Number'
                    value={searchAccount.id}
                    onChange={(e) => handleSearchChange(e)}
                    className="search-field"
                />
                <button className='submit-btn' id="search-btn" onClick={goToAccount}>Search</button>
                <button className='submit-btn' onClick={resetSearch}>Clear</button>
            </div>

            <div className='form-div'>
                <h2 className='form-header'>Create An Account</h2>
                <div>
                    <label className='form-label'>
                        First Name:
                    </label>
                    <input
                        type="text"
                        name="firstName"
                        value={account.firstName}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Last Name:
                    </label>
                    <input
                        type="text"
                        name="lastName"
                        value={account.lastName}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Phone Number:
                    </label>
                    <input
                        type="number"
                        name="phoneNumber"
                        value={account.phoneNumber}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <label className='form-label'>
                        Date of Birth:
                    </label>
                    <input
                        type="date"
                        name="birthDate"
                        value={account.birthDate}
                        onChange={(e) => handleChange(e)}
                        className="input-field"
                    />
                </div>
                <div>
                    <button className='submit-btn' onClick={saveAnAccount}>Save</button>
                    <button className='submit-btn' onClick={reset}>Clear</button>
                </div>
            </div>
        </div>
    </>
  )
}

export default Accounts