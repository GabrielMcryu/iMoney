import React from 'react'
import './TransactionStyles.css';

const Transaction = ({transaction}) => {
  return (
    <tr key={transaction.transactionId}>
        <td>{transaction.senderName}</td>
        <td>{transaction.accountNumber}</td>
        <td>{transaction.amount}</td>
        <td>{transaction.merchant}</td>
    </tr>
  )
}

export default Transaction