import React from 'react'

const ITransaction = ({iTransaction}) => {
  return (
    <tr key={iTransaction.iTransation}>
      <td>{iTransaction.senderAccount}</td>
      <td>{iTransaction.receiverAccount}</td>
      <td>{iTransaction.amount}</td>
    </tr>
  )
}

export default ITransaction