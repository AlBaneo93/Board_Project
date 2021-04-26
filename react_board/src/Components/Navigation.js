import React, {useState} from 'react'
import {Link, Route} from 'react-router-dom'
import Login from "./Login";
import SignIn from "./SignIn";
import Home from "./Home";

const Navigation = () => {
    return (
        <div>
            <Link to="/">Home</Link>
            <Link to="/signin">SignIn</Link>
            <Link to="/login">LogIn</Link>
        </div>
    )
}

export default Navigation