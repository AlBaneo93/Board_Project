import React, {useState, useEffect} from 'react'
import http from '../Utils/http'

const SignIn = () => {

    const [Member, setMember] = useState({});

    const signinHandler = (e) => {
        e.preventDefault();
        http.post('/api/member/signin', Member)
            .then(data => console.log)
            .catch(err => console.log);
    }

    const memberHandler = (e) => {
        e.preventDefault();
        setMember(prev => prev[e.target.name] = e.target.text)

        console.log(Member)
    }

    return (
        <div>
            <form onSubmit={signinHandler}>
                <label>이메일 <input name="email" type="text"/></label>
                <label>비밀번호 <input name="password" type="text"/></label>
                <label>비밀번호 확인 <input name="password-cfm" type="text"/></label>
                <label>기본 주소 <input name="addr1" type="text"/></label>
                <label>상세 주소 <input name="addr2" type="text"/></label>
                <label>우편 번호 <input name="zipcode" type="number"/></label>
                <label><input type="submit" value="가입"/></label>
                <label>
                    <button>돌아가기</button>
                </label>

            </form>
        </div>
    )
}

export default SignIn