import axios from 'axios';
import { BackendHost } from '../../Config/config';

const backendHost = BackendHost.concat('/api/users/');

export const register = (user) => {
    return axios.post(backendHost+"register", {
        data: user
    }
    );
}

export const getAllUsers = (token) => {
    return axios.get(backendHost,{
        headers: {
            'Authorization': "Bearer:"+token
        }
    });
}

export const getUserById = (id) => {
    return axios.get(backendHost+id);
}

export const updateUser = (token, user) => {
    return axios.put(backendHost+user.id, data=user, {
        headers: {
            'Authorization': "Bearer:"+token
        }
    });
}

export const login = (user) => {
    return axios.post(backendHost+'login', data=user);
}

