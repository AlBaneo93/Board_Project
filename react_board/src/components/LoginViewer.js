import React, {useEffect, useRef} from 'react'
import KakaoService from "../service/KakaoService";

const {naver} = window

const LoginViewer = () => {
    const naver_client_id = 'nrcctKic2og07bgqX85X';
    const naver_redirect_uri = 'http://localhost:10001/naver/callback'
    const googleLoginBtn = useRef(null);

    /*
    * 마운트시 실행하기 위한 코드
    * */
    useEffect(() => {
        naverInit()
        googleRender()
        googleSDK()
    }, [])

    const googleSDK = () => {
        // google sdk init
        window.googleSDKLoaded = () => {
            window.gapi.load('auth2', () => {
                const auth2 = window.gapi.auth2.getAuthInstance()

                auth2.attachClickHandler(
                    googleLoginBtn.current,
                    {},
                    (googleUser) => {
                        const profile = googleUser.getBasicProfile();
                        console.log(profile);
                        console.log(`Token || ${googleUser.getAuthResponse().id_token}`);
                        console.log(`ID: ${profile.getId()}`);
                        console.log(`Name: ${profile.getName()}`);
                        console.log(`Image URL: ${profile.getImageUrl()}`);
                        console.log(`Email: ${profile.getEmail()}`);
                    },
                    (error) => console.log
                );
            })
        }

        // google sdk 로드
        (function (d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) {
                return;
            }
            js = d.createElement(s);
            js.id = id;
            js.src = "https://apis.google.com/js/platform.js?onload=googleSDKLoaded";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'google-jssdk'))

    }

    const googleRender = () => {
        window.gapi.signin2.render('google-signin', {
            'scope': 'profile email',
            'width': 240,
            'height': 50,
            'longtitle': true
        })
    }

    /*
    * 해시 형태로 데이터가 넘어오는 여기서 데이터를 파싱해야 한다
    * 네이버는 callbackurl로 리다이렉팅을 시켜서 데이터를 넘김
    * */
    const naverInit = () => {
        const naverLogin = new naver.LoginWithNaverId({
            clientId: naver_client_id,
            callbackUrl: naver_redirect_uri,
            isPopup: false,
            loginButton: {color: 'green', type: 3, height: '50'}
        });
        naverLogin.init();
    };

    const kakaoHandle = (e) => {
        e.preventDefault()
        KakaoService.login()
    }

    return (
        <>
            <img src={"/images/kakao/ko/kakao_login_medium_narrow.png"} onClick={kakaoHandle} alt={''}/>
            <div id='naverIdLogin'/>
            {/*google에서 제공하는 로그인 버튼*/}
            <div ref={googleLoginBtn} id="google-signin"/>
        </>
    )
}

export default LoginViewer