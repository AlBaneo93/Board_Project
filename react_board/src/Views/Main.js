import React, {useEffect, useState} from 'react'
import Navigation from "../components/Navigation";
import Viewer from "../components/Viewer";
import KakaoService from "../service/KakaoService";
import NaverService from "../service/NaverService";
import http from "../utils/http";

const {naver} = window


const Main = () => {

    const client_id = 'nrcctKic2og07bgqX85X';
    const redirect_uri = 'http://localhost:10001/naver/callback'
    const state = 'mystatecodehahaha'

    /*
    * 해시 형태로 데이터가 넘어오는 여기서 데이터를 파싱해야 한다
    * 네이버는 callbackurl로 리다이렉팅을 시켜서 데이터를 넘김
    * */
    const naverInit = () => {
        const naverLogin = new naver.LoginWithNaverId({
            clientId: client_id,
            callbackUrl: redirect_uri,
            isPopup: false,
            loginButton: {color: 'green', type: 3, height: '50'}
        });
        naverLogin.init();
    };

    const kakaoHandle = (e) => {
        e.preventDefault()
        KakaoService.login()
    }



    /*
    * 마운트시 실행하기 위한 코드
    * */
    useEffect(() => {
        naverInit()
    }, [])

    const naverHandle = (e) => {
        e.preventDefault()
    }

    return (
        <div>
            <button onClick={kakaoHandle}>
                Kakao
            </button>
            {/*<button onClick={naverHandle}>*/}
            {/*    Naver*/}
            {/*</button>*/}
            <div id='naverIdLogin'/>
            <Navigation/>
            <Viewer/>
        </div>
    )
}

export default Main