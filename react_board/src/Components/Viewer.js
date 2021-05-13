import React, {useState} from 'react'
import {Link, Route} from "react-router-dom";
import Home from "./Home";
import SignIn from "./SignIn";
import Login from "./Login";
import UserInfo from "./UserInfo";

const Viewer = () => {
    return (
        <div>
            <Route exact path="/" component={Home}/>
            <Route exact path="/signin" component={SignIn}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/info" component={UserInfo}/>
        </div>
    )
}

export default Viewer