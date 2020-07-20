import React from 'react';
import { useRecoilState } from 'recoil';
import { useHistory, Link } from 'react-router-dom';
import { CurUser, Token, IsLoggedIn } from '../../Store';
import { login } from '../../Apis/User';
import { Axios } from '../../Config/Utils';
import {Button, Form, Input} from 'antd';
import 'antd/dist/antd.css';
import './index.scss';
import { HomeOutlined, UserAddOutlined } from '@ant-design/icons';
const Login = () => {
    const [curUser, setCurUser] = useRecoilState(CurUser);
    const [token, setToken] = useRecoilState(Token);
    const [isLoggedIn, setIsLoggedIn] = useRecoilState(IsLoggedIn); 
    const history = useHistory();

    const layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 16 },
    };
    const tailLayout = {
        wrapperCol: { offset: 8, span: 16 },
    };
    
    const onFinish = values => {
        var loginMap = {
            username : values.username,
            password : values.password
        }
        login(loginMap).then((data)=>{
            setCurUser(data.user);
            setToken(data.token);
            setIsLoggedIn(true);
        }).catch((e) => {
            alert(e);
        })
    }

    const onFinishFailed = () => {
        alert("Please check your username or password!");
    }
    

        
    return (
        <div className="login-container">
            <div className="top">
                <h2>Pet Shelter</h2>
            <div className="icons">
            <Link to="/">
                <HomeOutlined style={{color:"black", fontSize: "20px"}}/>
            </Link>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Link to="/register">
                <UserAddOutlined style={{color:"black", fontSize: "20px"}}/>
            </Link>
            </div>
            </div>
            <Form className="login-form"
            {...layout}
            name="login-form"
            onFinish={onFinish}
            onFinishFailed={onFinishFailed}
            >
                <Form.Item
                label="Username"
                name="username"
                rules ={[{ required: true, message: "Please input your username~"}]}>
                    <Input style={{maxWidth:"50%"}}/>
                </Form.Item>
                <Form.Item
                label="Password"
                name="password"
                rules={[{ required: true, message: "Please input your password~"}]}>
                    <Input.Password style={{maxWidth:"50%"}}/>
                </Form.Item>
                <Form.Item {...tailLayout}>
                    <Button type="primary" htmlType="submit">
                        Login
                    </Button>
                </Form.Item>
            </Form>
        </div>
    )
}

export default Login;