import React from 'react'
import { useNavigate } from 'react-router-dom'

const B2cTransaction = ({b2cTransaction}) => {
  const navigate = useNavigate();
  const viewB2cTransaction = (e, id) => {
    e.preventDefault();
    navigate(`/b2cTransactionDetail/${id}`)
  }

  return (
    <tr key={b2cTransaction.b2cId}>
        <td>{b2cTransaction.senderAccount}</td>
        <td>{b2cTransaction.merchant}</td>
        <td>{b2cTransaction.amount}</td>
        <td>{b2cTransaction.partyB}</td>
        <td>{b2cTransaction.occassion}</td>
        <td><a
          onClick={(e, id) => viewB2cTransaction(e, b2cTransaction.b2cId)}
          className="details-link">
          View
        </a></td>
    </tr>
  )
}

export default B2cTransaction