import React, {useState} from 'react'
import {Link, Route} from "react-router-dom";
import Home from "./Home";
import SignIn from "./SignIn";
import Login from "./Login";
import Test from "./Test";
import UserInfo from "./UserInfo";

const Viewer = () => {
    return (
        <div>
            <Route exact path="/" component={Home}/>
            <Route exact path="/signin" component={SignIn}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/info" component={UserInfo}/>
            <Route exact path="/test" component={Test}/>
        </div>
    )
}

export default Viewer