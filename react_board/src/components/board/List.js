import React, {useEffect, useState} from 'react'
import {useHistory} from "react-router-dom";
import http from "../../utils/http";

const List = () => {
    const [boards, setBoards] = useState([])
    const history = useHistory()

    useEffect(() => {
        getBoardList()
    }, [])

    const getBoardList = () => {
        http.get('/api/posts/page/0')
            .then(res => {
                setBoards(res.data.ret)
            })
            .catch(err => console.log(err))
    }

    const goBoardDetail = (board, e) => {
        e.preventDefault();

        history.push({
            pathname: "/detail",
            state: {"board": board}
        })
    }

    return (
        <div>
            <h2>자유 게시판</h2>
            {
                // TODO : link로 바꾸면 좋지 않을까?
                boards.map((board, index) => {
                        return <Link to={} onClick={(e) => {
                            goBoardDetail(board, e)
                        }} key={index}>{board.title}</Link>
                    }
                )
            }
        </div>
    )
}

export default List