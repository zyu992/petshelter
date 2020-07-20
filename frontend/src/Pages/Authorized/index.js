import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Home from '../../Components/Home';
import Pets from '../../Components/Pets';
import Applications from '../../Components/Applications';
import Profile from '../../Components/Profile';
import Donation from '../../Components/Donation';
const Authorized = () => {
    return (
        <Router>
            <div className="authorized-container">
                <Route exact path="/" component={Home}/>
                <Route exact path="/pets" component={Pets} />
                <Route exact path="/Applications" component={Applications}/>
                <Route exact path="/profile" component={Profile}/>
                <Route exact path="/donation" component={Donation}/>
            </div>
        </Router>
    )
}

export default Authorized;