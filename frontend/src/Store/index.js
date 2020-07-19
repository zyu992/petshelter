import {atom} from 'recoil';

export const Token = atom({
    name:"Token",
    default: ''
});

export const curUser = atom({
    name:"currentUser",
    default: undefined
});

export const petList = atom({
    name:"petList",
    default:[]
});

export const shoppingCart = atom({
    name:"shoopingCart",
    default:[]
});

