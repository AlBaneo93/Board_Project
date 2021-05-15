import React from 'react'
import {Link, useHistory} from 'react-router-dom'

const Navigation = () => {
    const history = useHistory();


    return (
        <>
            <img src={'/logo192.png'} onClick={() => history.push('/')} style={{'cursor': 'pointer', 'height': '100px', 'width': '100px'}} alt={'home'}/>
            <div>
                <Link to="/">Home</Link>
                <br/>
                <Link to="/signin">SignIn</Link>
                <br/>
                <Link to="/login">LogIn</Link>
                <br/>
                <Link to="/info">Info</Link>
                <br/>
                <Link to="/social">Social Login</Link>
                <br/>
                <Link to="/boards">Boards</Link>
            </div>
        </>
    )
}

export default Navigation