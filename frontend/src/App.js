import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './components/pages/home';
import Account from './components/pages/account';
import Register from './components/pages/register';
import Signin from './components/pages/signin';

import Container from './components/layout/container'
import Navbar from './components/layout/navbar'
import Footer from './components/layout/footer'

function App() {
  return (
    <Router>
      <Navbar/>
        <Container customClass="min-height">
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/Account' element={<Account />} />
            <Route path='/Register' element={<Register />} />
            <Route path='/Signin' element={<Signin />} />
          </Routes>
        </Container> 
      <Footer/>
    </Router>
  );
}

export default App;
