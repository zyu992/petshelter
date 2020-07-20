import Axios from '../../Config/Utils'
import { devUrl, backendUrl } from '../../Config/Urls';

const BaseUrl = devUrl+'pets/';
// const BaseUrl = backendUrl +'pets/';

export const createPet = (pet) => {
    return Axios.post(BaseUrl,data={
        pet:pet
    },);
}

export const getAllPets = () => {
    return Axios.get(BaseUrl);
}

export const getPetById = (id) => {
    return Axios.get(BaseUrl+id);
}

export const getPetByPost = (id) => {
    return Axios.get(BaseUrl+`post/${id}`);
}