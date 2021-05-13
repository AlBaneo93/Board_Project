import React, {useState} from 'react'
import Navigation from "../components/Navigation";
import Viewer from "../components/Viewer";
import KakaoService from "../service/KakaoService";


const Main = () => {

    const kakaoHandle = (e) => {
        e.preventDefault()
        KakaoService.login()

    }

    return (
        <div>
            <button onClick={kakaoHandle}>kakao</button>
            <Navigation/>
            <Viewer/>
        </div>
    )
}

export default Main