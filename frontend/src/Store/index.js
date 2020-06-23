import atom from "recoil";

//State management class
export const Token = atom({
    key: 'Token',
    default: ''
})

export const currentUser =  atom({
    key: 'currentUser',
    default: null
})


export const availableAnimals = atom({
    key: 'availableAnimals',
    default: []
})

