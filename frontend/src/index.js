import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './index.css';
import App from './App';
import Home from './components/pages/Home';
import Account from './components/pages/Account';
import Register from './components/pages/Register';
import Signin from './components/pages/Signin';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
     <Router>
      <Routes>
        <Route path="/" element={<App> <Home /> </App>} />
        <Route path="/Home" element={<App> <Home /> </App>} />
        <Route path="/Account" element={<App> <Account /> </App>} />
        <Route path="/Register" element={<App> <Register /> </App>} />
        <Route path="/Signin" element={<App> <Signin /> </App>} />
      </Routes>
    </Router>
  </React.StrictMode>,
);
