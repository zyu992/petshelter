import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import Login from './Components/Login';

const App = () => {
  return (
  <Router>
    <div className="App">
      <Link to="/">
        <Login />
      </Link>
    </div>
  </Router>
  );
}

export default App;
