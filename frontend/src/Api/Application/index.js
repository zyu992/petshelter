import axios from 'axios';
import { BackendHost } from '../../Config/config';

const backendHost = BackendHost+'/api/application';

export const createApplication = (token, application) => {
    return axios.post(backendHost, data=application,{
        headers: {
            "Authorization": "Bearer:" + token
        }
    });
}

export const findAllApplication = (token) => {
    return axios.get(backendHost, {
        headers: {
            "Authorization": "Bearer:" + token
        }
    });
}

export const findByApplicationId = (token,id) => {
    return axios.get(backendHost+`${id}`, {
        headers: {
            "Authorization": "Bearer:" + token
        }
    });
}

export const findApplicationByUser = (token,id) => {
    return axios.get(backendHost+`user/${id}`,{
        headers: {
            "Authorization": "Bearer:" + token
        }
    });
}

export const findApplicationByPost = (token, id) => {
    return axios.get(backendHost+`post/${id}`, {
        headers: {
            "Authorization": "Bearer:"+token
        }
    });
}

