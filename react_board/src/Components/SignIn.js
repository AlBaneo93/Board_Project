import React, {useState, useEffect} from 'react'
import http from '../Utils/http'
import {useHistory} from "react-router-dom";

const SignIn = () => {

    const history = useHistory();
    const [Member, setMember] = useState({});

    const signinHandler = (e) => {
        e.preventDefault();
        http.post('/api/member', Member)
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
                <label>이메일 <input name="email" type="text"/></label><br/>
                <label>비밀번호 <input name="password" type="text"/></label><br/>
                <label>비밀번호 확인 <input name="password-cfm" type="text"/></label><br/>
                <label>기본 주소 <input name="addr1" type="text"/></label><br/>
                <label>상세 주소 <input name="addr2" type="text"/></label><br/>
                <label>우편 번호 <input name="zipcode" type="number"/></label><br/>
                <label><input type="submit" value="가입"/></label>
                <label>
                    <button onClick={(e) => {
                        e.preventDefault();
                        // TODO : 공통 메서드 모듈화 하기
                        // 이전페이지로 돌아가기
                        history.go(-1)
                    }}>돌아가기
                    </button>
                </label>

            </form>
        </div>
    )
}

export default SignIn