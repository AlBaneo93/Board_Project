import React, {useState} from 'react'
import {Link, Route} from 'react-router-dom'
import Login from "./Login";
import SignIn from "./SignIn";
import Home from "./Home";

const Navigation = () => {

    const [user, setUser] = useState({"email": "need initial", "address": {}})

    return (
        <div>
            <Link to="/">Home</Link>
            <Link to="/signin">SignIn</Link>
            <Link to="/login">LogIn</Link>
            <Link to="/info">{user.email !== null ? user.email : "need init user Object"}</Link>

        </div>
    )
}

export default Navigation