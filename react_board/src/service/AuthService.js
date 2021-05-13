import http from "../utils/http";

class AuthService {
    excuteAuthentication(username, password) {
        http.get("/authentication", {
            headers: {
                "Authentication": this.makeBasicAuthenticationToken(username, password)
            }
        })
    }

    makeBasicAuthenticationToken(username, password) {
        // make basic authentication toke
        return "Basic " + window.btoa(username + ":" + password);
    }
}

export default AuthService()