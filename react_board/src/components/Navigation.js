import React from 'react'
import {Link} from 'react-router-dom'

const Navigation = () => {


    return (
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

        </div>
    )
}

export default Navigation