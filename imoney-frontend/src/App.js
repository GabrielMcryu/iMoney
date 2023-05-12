import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import CreateTransaction from './components/CreateTransaction';
import GetTransactionsByAccountNumber from './components/GetTransactionsByAccountNumber';

import Home from './components/Home';
import Navbar from './components/Navbar';
import ITransactions from './components/ITransactions';
import B2cTransactions from './components/B2cTransactions';
import C2bTransactions from './components/C2bTransactions';
import ITransactionsList from './components/ITransactionsList';
import C2bTransactionsList from './components/C2bTransactionsList';
import B2cTransactionsList from './components/B2cTransactionsList';
import Accounts from './components/Accounts';
import Account from './components/Account';
import ITransactionDetail from './components/ITransactionDetail';
import B2cTransactionDetail from './components/B2cTransactionDetail';
import C2bTransactionDetail from './components/C2bTransactionDetail';

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
        <Route path='/imoneyTransactions' element={<ITransactions />} />
        <Route path='/getImoneyTransactions/:accountNumber' element={<ITransactionsList />} />
        <Route path='/imoneyTransactionDetail/:id' element={<ITransactionDetail />} />
        <Route path='/b2cTransactions' element={<B2cTransactions />} />
        <Route path='/getb2cTransactions/:accountNumber' element={<B2cTransactionsList />} />
        <Route path='/b2cTransactionDetail/:id' element={<B2cTransactionDetail />} />
        <Route path='/c2bTransactions' element={<C2bTransactions />}/>
        <Route path='/getc2bTransactions/:accountNumber' element={<C2bTransactionsList />} />
        <Route path='/c2bTransactionDetail/:id' element={<C2bTransactionDetail />} />
        <Route path='/accounts' element={<Accounts />} />
        <Route path='/account/:id' element={<Account />} />
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
