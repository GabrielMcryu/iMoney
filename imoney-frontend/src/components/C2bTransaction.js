import React from 'react'

const C2bTransaction = ({c2bTransaction}) => {
  return (
    <tr key={c2bTransaction.c2bId}>
        <td>{c2bTransaction.senderName}</td>
        <td>{c2bTransaction.merchant}</td>
        <td>{c2bTransaction.receiverAccountNumber}</td>
        <td>{c2bTransaction.amount}</td>
    </tr>
  )
}

export default C2bTransaction