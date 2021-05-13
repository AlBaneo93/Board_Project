const {naver} = window

class NaverService {

    client_id = "nrcctKic2og07bgqX85X"
    callback_url = "http://localhost:10001/callback/naver"


    login() {
        const naverLogin = new naver.LoginWithNaverId({
            clientId: "nrcctKic2og07bgqX85X",
            callbackUrl: "http://localhost:10001/callback/naver",
            isPopup: false,
            loginButton: {color: 'white', type: 1, height: '47'}
        });

        naverLogin.init();
    }
}

export default new NaverService()