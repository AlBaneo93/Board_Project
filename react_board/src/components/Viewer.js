import React from 'react'
import {Route} from "react-router-dom";
import CustomLogin from "./CustomLogin";
import Home from "./Home";
import LoginViewer from "./LoginViewer";
import NaverCallback from "./NaverCallback";
import SignIn from "./SignIn";
import UserInfo from "./UserInfo";

const Viewer = () => {
    return (
        <div>
            <Route exact path="/" component={Home}/>
            <Route exact path="/signin" component={SignIn}/>
            <Route exact path="/login" component={CustomLogin}/>
            <Route exact path="/info" component={UserInfo}/>
            <Route exact path="/naver/callback" component={NaverCallback}/>
            <Route exact path="/social" component={LoginViewer}/>
        </div>
    )
}

export default Viewer