import React, {useEffect} from 'react'
import {useHistory} from "react-router-dom";
import http from "../utils/http";

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
            .then(data => alert(JSON.stringify(data)))
            .catch(err => console.log)
            .finally(() => {
                history.replace("/")
            })
    }

    useEffect(() => {
        getUser()
    }, [])

    return (
        <div>
            Processing...
        </div>
    )
}

export default NaverCallback