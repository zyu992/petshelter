import {atom} from 'recoil';

export const Token = atom({
    name:"Token",
    default: ''
});

export const CurUser = atom({
    name:"currentUser",
    default: undefined
});

export const PetList = atom({
    name:"petList",
    default:[]
});

export const ShoppingCart = atom({
    name:"shoopingCart",
    default:[]
});

export const IsLoggedIn = atom({
    name:"isLoggedIn",
    default:false
});