import React from 'react'
import {Route, Switch} from "react-router-dom";
import Detail from "./board/Detail";
import List from "./board/List";
import CustomLogin from "./CustomLogin";
import Home from "./Home";
import LoginViewer from "./LoginViewer";
import NaverCallback from "./NaverCallback";
import SignIn from "./SignIn";
import UserInfo from "./UserInfo";


const Viewer = () => {
    return (
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/signin" component={SignIn}/>
            <Route exact path="/login" component={CustomLogin}/>
            <Route exact path="/info" component={UserInfo}/>
            <Route exact path="/naver/callback" component={NaverCallback}/>
            <Route exact path="/social" component={LoginViewer}/>
            <Route exact path="/detail" component={Detail}/>
            <Route exact path="/boards" component={List}/>
        </Switch>
    )
}

export default Viewer