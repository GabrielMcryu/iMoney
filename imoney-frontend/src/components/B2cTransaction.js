import React from 'react'

const B2cTransaction = ({b2cTransaction}) => {
  console.log(b2cTransaction.b2cId);

  return (
    <tr key={b2cTransaction.b2cId}>
        <td>{b2cTransaction.senderAccount}</td>
        <td>{b2cTransaction.merchant}</td>
        <td>{b2cTransaction.amount}</td>
        <td>{b2cTransaction.partyB}</td>
        <td>{b2cTransaction.occassion}</td>
    </tr>
  )
}

export default B2cTransaction