import { devUrl, backendUrl } from '../../Config/Urls';
import {Axios} from '../../Config/Utils'
const BaseUrl = devUrl+'users/';
// const BaseUrl = backendUrl+'/api/users';

export const register = (user) => {
    return Axios.post(BaseUrl+'register',{
        user:user
    });
}

export const getAllUsers = () => {
    return Axios.get(BaseUrl,);
}

export const getUserById = (id) => {
    return Axios.get(BaseUrl+id);
}

export const updateUser = (id, user)  => {
    return Axios.put(BaseUrl+id, {
        user: user
    });
}

export const login = (loginMap) => {
    return Axios.post(BaseUrl+'login', {
        loginMap:loginMap
    });
}