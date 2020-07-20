import React from 'react';
import './App.css';
import { useRecoilState } from 'recoil';
import { IsLoggedIn } from './Store';
import Authorized from './Pages/Authorized';
import Unauthorized from './Pages/Unauthorized';

const App = () => {
  const [isLoggedIn,_] = useRecoilState(IsLoggedIn);
  return isLoggedIn ? <Authorized /> : <Unauthorized />
}

export default App;
