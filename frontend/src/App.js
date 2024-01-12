import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './components/pages/home';
import Account from './components/pages/account';
import Register from './components/pages/register';
import Signin from './components/pages/signin';

import Container from './components/layout/container'

function App() {
  return (
    <Router>
      <div>
        <Link to='/'>Home</Link>
        <Link to='/Account'>Account</Link>
        <Link to='/Register'>Sign Up</Link>
        <Link to='/Signin'>Sign In</Link>
      </div>

      <Container>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/Account' element={<Account />} />
          <Route path='/Register' element={<Register />} />
          <Route path='/Signin' element={<Signin />} />
        </Routes>
      </Container>
    </Router>
  );
}

export default App;
