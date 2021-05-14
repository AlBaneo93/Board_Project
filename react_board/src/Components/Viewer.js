import React from 'react'
import {Route} from "react-router-dom";
import Home from "./Home";
import NaverCallback from "./NaverCallback";
import SignIn from "./SignIn";
import CustomLogin from "./CustomLogin";
import UserInfo from "./UserInfo";
import LoginViewer from "./LoginViewer";

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