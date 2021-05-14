import http from "../utils/http";

const {Kakao} = window

class KakaoService {

    constructor() {
        Kakao.init('09bca32d090ac2266c9f3c688908be8e')
        Kakao.isInitialized()
    }

    login() {
        Kakao.Auth.login({
            success: (authObj) => {
                console.log(authObj)
                http.post('http://localhost:8080/callback', authObj)
            },
            fail: err => {
                alert(JSON.stringify(err))
            }
        })
    }
}

export default new KakaoService()