import React from 'react';
import '@ant-design/icons';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import Login from '../../Components/Login';
import Registration from '../../Components/Registration';
import './index.scss';
import {LoginOutlined, UserAddOutlined } from '@ant-design/icons';
const Unauthorized = () => {
    return (
        <Router>
            <div className='unauthorized-container'>
                <Route exact path="/" >
                    <div className='main-page'>
                        <div className = 'icons'>
                            <Link to='/login'>
                                <LoginOutlined style={{color:"black", fontSize: "40px"}}/>
                            </Link>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <Link to= '/register'>
                                <UserAddOutlined style={{color:"black", fontSize: "40px", fontFamily:"bold"}}/>
                            </Link>
                        </div>
                    </div>
                </Route>
                <Route path="/login" component={Login} />
                <Route path="/register" component={Registration} />
            </div>
        </Router>
    )
}

export default Unauthorized;