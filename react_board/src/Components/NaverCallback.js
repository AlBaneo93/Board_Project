import React, {useEffect} from 'react'
import {useHistory} from "react-router-dom";
import http from "../Utils/http";

const NaverCallback = () => {
    const history = useHistory()
    const getUser = () => {
        const queryParam = window.location.href.split('#')[1];
        console.log(queryParam)
        const item = {}
        queryParam.split("&").map(param => {
            const tmp = param.split('=')
            item[tmp[0]] = tmp[1]
        })

        http.post('/oauth/naver', item)
            .then(data => console.log)
            .catch(err => console.log)
            .finally(() => {
                history.push("/")
            })
    }

    useEffect(() => {
        getUser()
    }, [])

    return (
        <div>
            {'콜백 처리중'}
        </div>
    )
}

export default NaverCallback