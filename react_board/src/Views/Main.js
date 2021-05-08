import React, {useState} from 'react'
import Navigation from "../components/Navigation";
import Viewer from "../components/Viewer";

const Main = () => {
    return (
        <div>
            <Navigation/>
            <Viewer/>
        </div>
    )
}

export default Main