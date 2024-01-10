import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

function App() {
  return (
   <Router>
    <ul>
      <li>Home</li>
      <li>Account</li>
      <li>Sign in / Sign Up</li>
    </ul>

    <Switch>
      <Route exact path='/'>
        <Home/>
      </Route>

      <Route exact path='/Account'>
        <Home/>
      </Route>    
    </Switch>

    <p>Footer</p>
   </Router>
  );
}

export default App;
