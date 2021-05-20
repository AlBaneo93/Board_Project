import React, {useEffect, useRef, useState} from 'react'
import {useHistory} from "react-router-dom";
import http from '../Utils/http'

const LoginViewer = () => {
    const naver_client_id = 'nrcctKic2og07bgqX85X';
    const naver_redirect_uri = 'http://localhost:10001/naver/callback'
    const googleLoginBtn = useRef(null);
    const history = useHistory();

    const [member, setMember] = useState({})
    const inputHandler = e => {
        e.preventDefault()
        setMember({
            ...member,
            [e.target.name]: e.target.value
        })
    }

    const submitHandler = e => {
        e.preventDefault()
        http.post('/oauth/login', member)
            .then(res => console.log)  // accesstoken을 받아온다
            .catch(err => console.log)
    }

    /*
    * 마운트시 실행하기 위한 코드
    * */
    useEffect(() => {
        naverInit()
        kakaoInit()
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
        // 즉시 실행 함수
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
    * init() 이후의 코드는 sdk에서 제공하는 유저 정보를 가져오는 코드
    * */
    const naverInit = () => {
        // TODO : naversdk가 있는지 확인하고 없으면 append, 있으면 다음단계
        const naverSdk = document.createElement('script');
        naverSdk.src = 'https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js'
        naverSdk.type = 'text/javascript'
        document.head.appendChild(naverSdk);

        naverSdk.onload = () => {
            const naverLogin = new window.naver.LoginWithNaverId({
                clientId: naver_client_id,
                callbackUrl: naver_redirect_uri,
                isPopup: false,
                loginButton: {color: 'green', type: 1, height: '50'}
            });
            naverLogin.init();
            naverLogin.logout();
            // send accesstoken to server for get user information
            naverLogin.getLoginStatus(status => {
                if (status) {
                    console.log("Naver logged in", naverLogin.user)
                    const {id, email, gender} = naverLogin.user
                } else {
                    console.log('naver logged out')
                }
            })
        }
    };

    const kakaoInit = () => {
        const kakaoSdk = document.createElement('script')
        kakaoSdk.src = 'https://developers.kakao.com/sdk/js/kakao.js'
        document.head.appendChild(kakaoSdk);

        kakaoSdk.onload = () => {
            window.Kakao.init(process.env.REACT_APP_KAKAO_SECRET);
            window.Kakao.Auth.createLoginButton({
                container: '#kakao-login-btn',
                success: auth => {
                    console.log('kakao login success', auth)
                    window.Kakao.API.request({
                        url: '/v2/user/me',
                        success: res => {
                            console.log('Kakao 사용자 정보', res)
                        },
                        fail: err => {
                            console.log(err)
                        }
                    })
                },
                fail: err => {
                    console.log(err)
                }
            })
        }
    }

    const kakaoHandle = (e) => {
        e.preventDefault()
    }

    return (
        <>
            <div>
                <form onSubmit={submitHandler}>
                    <table>
                        <tr>
                            <td>
                                <div>
                                    <input onChange={inputHandler} style={{'height': '30px'}} placeholder="아이디" type="text" name="username"/><br/>
                                    <input onChange={inputHandler} style={{'height': '30px'}} placeholder="패스워드" type="password" name="password"/>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <button style={{'height': '70px', 'width': '70px'}} type="submit">LOG IN</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                {/*<img src={"/images/kakao/ko/kakao_login_medium_narrow.png"} onClick={kakaoHandle} alt={''}/>*/}
                <div id='kakao-login-btn'/>
                <div id='naverIdLogin'/>
                {/*google에서 제공하는 로그인 버튼*/}
                <div ref={googleLoginBtn} id="google-signin"/>
            </div>
        </>
    )
}

export default LoginViewer