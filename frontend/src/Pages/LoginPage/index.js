import React, {useState} from 'react';

import { useRecoilState } from "recoil";

import './index.scss';
import { currentUser, Token } from '../../Store';

const LoginPage = () => {
    const [user, setUser]  = useState('');
    const [password, setPassword] = useState('');
    const [curUser, setCurUser] = useRecoilState(currentUser);
    const [token, setToken] = useRecoilState(Token);

    const handleLogin = (username, password) => {
        console.log("handle Login");
    }

    return (
        <div className="login-container">
            <div className="login-form">
            <input autoFocus={true} value={username} placeholder="Please input your username"
                onChange={ e => {
                    const val = e.target.value;
                    setUsername(val);
                }
                } />
                <input autoFocus={true} value={password} placeholder="Please input your password"
                onChange={ e => {
                    const val = e.target.value;
                    setPassword(val);
                }
                } />
            </div>
            <div className="login-button">
                <input type="button" onClick={() => handleLogin(user, password)}/>
            </div>
        </div>
    )
}

export default LoginPage;