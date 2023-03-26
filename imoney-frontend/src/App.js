import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';

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
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
