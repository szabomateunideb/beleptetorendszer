import { useState } from 'react'
import './App.css'
import HelloPage from "./pages/HelloPage.jsx";
import LoginPage from "./pages/LoginPage.jsx";

export default function App() {
  const [token, setToken] =
      useState(localStorage.getItem('token'))

  function belepes(ujtoken){
    localStorage.setItem('token',ujtoken)
    setToken(ujtoken)
  }

  function kilepes(){
    localStorage.removeItem('token')
    setToken(null)
  }

  if(token){
    return <HelloPage token={token} onKilepes={kilepes} />
  }
  return <LoginPage onSikeresBelepes={belepes} />
}


