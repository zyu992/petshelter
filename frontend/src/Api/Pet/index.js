import axios from 'axios';
import { BackendHost } from '../../Config/config';

const backendHost = BackendHost+"/api/pets/";

export const createPet = (token, pet) => {
    return axios.post(backendHost+'create', data=pet, {
        headers: {
            "Authorization": "Bearer:"+ token
        }
    });
}

export const getAllPets = (token) => {
    return axios.get(backendHost,{
        headers: {
            "Authorization": "Bearer:"+ token
        }
    });
}

export const getPetById = (id,token) => {
    return axios.get(backendHost+id,{
        headers: {
            "Authorization": "Bearer:"+token
        }
    });
}