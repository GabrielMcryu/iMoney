import React from 'react'
import { useNavigate } from 'react-router-dom'

const ITransaction = ({iTransaction}) => {
  const navigate = useNavigate();
  const viewITransaction = (e, id) => {
    e.preventDefault();
    navigate(`/imoneyTransactionDetail/${id}`)
  }

  return (
    <tr key={iTransaction.iTransation}>
      <td>{iTransaction.senderAccount}</td>
      <td>{iTransaction.receiverAccount}</td>
      <td>{iTransaction.amount}</td>
      <td><a
          onClick={(e, id) => viewITransaction(e, iTransaction.iTransation)}
          className="details-link">
          View
        </a></td>
    </tr>
  )
}

export default ITransaction