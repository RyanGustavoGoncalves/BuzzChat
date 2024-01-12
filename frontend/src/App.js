import React from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from 'react-router-dom';
import Home from './components/pages/Home';
import Account from './components/pages/Account';
import Register from './components/pages/Register';
import Signin from './components/pages/Signin';

function App() {
  return (
    <Router>
      <div>
        <Link to='/'>Home</Link>
        <Link to='/Account'>Account</Link>
        <Link to='/Register'>Sign Up</Link>
        <Link to='/Signin'>Sign In</Link>
      </div>

      <Switch>
        <Route exact path='/'>
          <Home />
        </Route>

        <Route path='/Account'>
          <Account />
        </Route>

        <Route path='/Register'>
          <Register />
        </Route>

        <Route path='/Signin'>
          <Signin />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
