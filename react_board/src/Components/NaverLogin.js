import React, {useEffect} from 'react'

const NaverLogin = () => {

    const naver_client_id = 'nrcctKic2og07bgqX85X';
    const naver_redirect_uri = 'http://localhost:10001/naver/callback'

    useEffect(() => {
        sdkInit()
    }, [])

    const sdkInit = () => {
        const naverSdk = document.createElement('script');
        naverSdk.src = 'https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js'
        naverSdk.type = 'text/javascript'
        document.head.appendChild(naverSdk);

        // naver script sdk 로드 완료시
        naverSdk.onload = () => {
            const naverLogin = new window.naver.LoginWithNaverId({
                clientId: naver_client_id,
                callbackUrl: naver_redirect_uri,
                callbackHandle: true,
                isPopup: false,
                loginButton: {color: 'green', type: 1, height: '50'}
            })

            naverLogin.init();
            // naverLogin.logout();

            naverLogin.getLoginStatus(status => {
                if (status) {
                    console.log("Naver logged in", naverLogin.user)
                    const {id, email, gender} = naverLogin.user
                } else {
                    console.log('naver logged out')
                }
            })
        }
    }


    return (
        <div>
            <div id='naverIdLogin'/>
        </div>
    )
}

export default NaverLogin