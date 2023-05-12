import React from 'react'
import { useNavigate } from 'react-router-dom'

const C2bTransaction = ({c2bTransaction}) => {
  const navigate = useNavigate();
  const viewC2bTransaction = (e, id) => {
    e.preventDefault();
    navigate(`/c2bTransactionDetail/${id}`)
  }

  return (
    <tr key={c2bTransaction.c2bId}>
        <td>{c2bTransaction.senderName}</td>
        <td>{c2bTransaction.merchant}</td>
        <td>{c2bTransaction.receiverAccountNumber}</td>
        <td>{c2bTransaction.amount}</td>
        <td><a
          onClick={(e, id) => viewC2bTransaction(e, c2bTransaction.c2bId)}
          className="details-link">
          View
        </a></td>
    </tr>
  )
}

export default C2bTransaction