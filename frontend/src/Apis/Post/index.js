import Axios from '../../Config/Utils'
import { devUrl, backendUrl } from '../../Config/Urls';

const BaseUrl = devUrl+'posts/';
// const BaseUrl = backendUrl+'/api/posts';

export const createPost = (post) => {
    return Axios.post(BaseUrl,data={
        post:post
    });
}

export const getAllPosts = () => {
    return Axios.get(BaseUrl);
}

export const getPostById = (id) => {
    return Axios.get(BaseUrl+id);
}

export const assignAdopter = (postId, applicationId) => {
    return Axios.put(BaseUrl+'assign',data={
        post: postId,
        application:applicationId
    });
}

export const findPostsByUser = (id) => {
    return Axios.get(BaseUrl+`user/${id}`);
}

export const findPostsByApplication = (id) => {
    return Axios.get(BaseUrl+`application/${id}`);
}
