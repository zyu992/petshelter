import axios from 'axios';

import { BackendHost } from '../../Config/config';

const backendHost = BackendHost+"/api/posts/";

export const createPost=(token, post) => {
    return axios.post(backendHost, data=post,
    {
        headers: {
            'Authorization': "Bearer:"+ token
        }
    }
    );
}

export const findAllPosts = (token) => {
    return axios.get(backendHost,{
        headers: {
            'Authorization': "Bearer:"+ token
        }
    });
}

export const findById = (token, id) => {
    return axios.get(backendHost+id, {
        headers: {
            'Authorization': "Bearer:"+ token
        }
    });
}

export const assignAdopter = (token, postId, applicationId) => {
    return axios.put(backendHost+"assign",data={
        post: postId,
        application: applicationId
    },
    {
        headers: {
            'Authorization': "Bearer:"+token
        }
    })
}

export const findByUser = (token, userId) => {
    return axios.get(backendHost+`user/${userId}`,{
        headers: {
            "Authorization": "Bearer:"+token
        }
    });
}

export const findByApplication = (token, applicationId) => {
    return axios.get(backendHost+`application/${applicationId}`, {
        headers: {
            'Authorization': "Bearer:"+token
        }
    })
}

