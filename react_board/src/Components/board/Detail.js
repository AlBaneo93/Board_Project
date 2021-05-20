import React from 'react'
import {useLocation} from 'react-router-dom'
import Comments from "./Comments";

const Detail = () => {

    const location = useLocation()

    const board = location.state.board

    return (
        <div>
            <h3>
                {board.title}
            </h3>
            <div>
                {board.writer}
            </div>
            <div>{board.createdAt}</div>
            <div>
                {board.content}
            </div>
            <Comments comments={board.comments}/>

        </div>
    )
}

export default Detail