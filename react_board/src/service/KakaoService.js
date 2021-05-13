import http from "../utils/Http";

const {Kakao} = window

class KakaoService {
    // client_id = "09bca32d090ac2266c9f3c688908be8e";
    // redirect_url = "http://localhost:3000/callback/kakao";

    // getAuthCode() {
    //     console.log("addr: " + this.parseURL(this.client_id, this.redirect_url))
    //     return http.get(this.parseURL(this.client_id, this.redirect_url))
    // }
    //
    // parseURL(client_id, redirect_url) {
    //     return "https://kauth.kakao.com/oauth/authorize?" +
    //         "&client_id=" + client_id +
    //         "&redirect_uri=" + redirect_url +
    //         "&response_type=code";
    // }

    login() {
        Kakao.Auth.login({
            success: (authObj) => {
                console.log(authObj)
                http.post('http://localhost:8080/callback', JSON.stringify(authObj))
            },
            fail: err => {
                alert(JSON.stringify(err))
            }
        })
    }
}

export default new KakaoService()