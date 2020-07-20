import Axios from '../../Config/Utils';
import { devUrl, backendUrl } from '../../Config/Urls';

const BaseUrl = devUrl+'applications/';
// const BaseUrl = backendUrl+'/api/applications';

export const createApplication = (application) => {
    return Axios.post(BaseUrl, 
        data={
        application: application
        },
        );
}

export const getApplicationById = (id) => {
    return Axios.get(BaseUrl+id);
}

export const getApplicationsByUser = (id) => {
    return Axios.get(BaseUrl+`user/${id}`);
}

export const getApplicationsByPost = (id) => {
    return Axios.get(BaseUrl+`post/${id}`);
}

