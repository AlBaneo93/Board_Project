import React, {useState} from 'react'
import http from "../Utils/http";

const Login = () => {

    const [member, setMember] = useState({})

    const loginHandler = (e) => {
        e.preventDefault();
        http.post('/login', member)
            .then(res => console.log)
            .catch(err => {
                alert('로그인 실패, 이메일 및 비밀번호를 확인해주세요')
                console.log(err)
            })
    }

    const inputHandler = (e) => {
        e.preventDefault()
        setMember(prev => {
            prev[e.target.name] = e.target.text
        })
        console.log(member)
    }

    return (
        <div>
            <form onSubmit={loginHandler}>
                <label>이메일 <input onChange={inputHandler} name="email" type="text"/></label>
                <label>비밀번호 <input onChange={inputHandler} name="password" type="text"/></label>
                <label><input type="submit" value="로그인"/></label>
                <label>
                    <button>돌아가기</button>
                </label>
            </form>
        </div>
    )
}

export default Login