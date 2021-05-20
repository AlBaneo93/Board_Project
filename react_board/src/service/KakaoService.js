const {Kakao} = window

class KakaoService {

    constructor() {
        Kakao.init('09bca32d090ac2266c9f3c688908be8e')
        Kakao.isInitialized()
    }

    login() {
        return Kakao.Auth.login({
            success: (authObj) => {
                console.log(authObj)
                return authObj;
            },
            fail: err => {
                alert(JSON.stringify(err))
                return null;
            }
        })

    }
}

export default new KakaoService()