import React, {useState} from 'react'
import {Link, Route} from "react-router-dom";
import Home from "./Home";
import SignIn from "./SignIn";
import Login from "./Login";

const Viewer = () => {
    return (
        <div>
            <Route exact path="/" component={Home} />
            <Route exact path="/signin" component={SignIn}/>
            <Route exact path="/login" component={Login}/>
        </div>
    )
}

export default Viewer