import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import CreateTransaction from './components/CreateTransaction';
import GetTransactionsByAccountNumber from './components/GetTransactionsByAccountNumber';

import Home from './components/Home';
import Navbar from './components/Navbar';

function App() {
  return (
    <>
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route index element={<Home />} />
        <Route path='/' element={<Home />} />
        <Route path='/createTransaction' element={<CreateTransaction />} />
        <Route path='/getTransactionsByAcountNumber/:merchant/:accountNumber' element={<GetTransactionsByAccountNumber />} />
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
