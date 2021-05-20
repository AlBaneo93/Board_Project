import React, {useState} from 'react'
import {useHistory} from "react-router-dom";
import http from "../Utils/http";

const CustomLogin = () => {

    const history = useHistory();
    const [member, setMember] = useState({"username": "", "password": ""})

    const loginHandler = (e) => {
        e.preventDefault();
        http.post('/auth/login', member)
            .then(res => console.log)
            .catch(err => {
                alert('로그인 실패, 이메일 및 비밀번호를 확인해주세요')
                console.log(err)
            })
    }

    const inputHandler = (e) => {
        e.preventDefault()

        // 함수를 이용한 업데이트 방법
        // setMember(prev => {
        //     prev[e.target.name] = e.target.value
        //     console.log("prev: ", prev)
        //     return prev // return을 해주어야 한다
        // })

        // spread 연산자를 이용한 업데이트 방법
        setMember({
            ...member,
            [e.target.name]: e.target.value
        })
    }

    return (
        <div>
            <form onSubmit={loginHandler}>
                <label>이메일 <input onChange={inputHandler} name="username" type="text"/></label><br/>
                <label>비밀번호 <input onChange={inputHandler} name="password" type="text"/></label><br/>
                <label><input type="submit" value="로그인"/></label>
                <label>

                    <button onClick={e => {
                        e.preventDefault()
                        // TODO : 공통 메서드 모듈화 하기
                        history.go(-1)
                    }}>돌아가기
                    </button>
                </label>
            </form>
        </div>
    )
}

export default CustomLogin