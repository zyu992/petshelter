import React from 'react';
import { useHistory, Link } from 'react-router-dom';
import { register } from '../../Apis/User';
import {Button, Form, Input} from 'antd';
import 'antd/dist/antd.css';
import './index.scss';
import { HomeOutlined, LoginOutlined } from '@ant-design/icons';
const Registration = () => {
    const history = useHistory();

    const layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 16 },
    };
    const tailLayout = {
        wrapperCol: { offset: 8, span: 16 },
    };
    
    const onFinish = values => {
        var user = {
            username : values.username,
            password : values.password,
            email: values.email
        }
        register(user).then(()=>{
            alert("Register succeed, please proceed to login");
        }).catch((e) => {
            alert(e);
        })
    }

    const onFinishFailed = () => {
        alert("Please check your inputs!");
    }
    

        
    return (
        <div className="register-container">
            <div className="top">
                <h2>Pet Shelter</h2>
            <div className="icons">
            <Link to="/">
                <HomeOutlined style={{color:"black", fontSize: "20px"}}/>
            </Link>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Link to="/login">
                <LoginOutlined style={{color:"black", fontSize: "20px"}}/>
            </Link>
            </div>
            </div>
            <Form className="register-form"
            {...layout}
            name="register-form"
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
                <Form.Item
                label="Email"
                name="email"
                rules={[{ required: true, message: "Please input your email~"}]}>
                    <Input style={{maxWidth:"50%"}}/>
                </Form.Item>
                <Form.Item {...tailLayout}>
                    <Button type="primary" htmlType="submit">
                        Register
                    </Button>
                </Form.Item>
            </Form>
        </div>
    )
}

export default Registration;