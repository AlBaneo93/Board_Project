import React from 'react'

const Comments = ({comments}) => {
    return (
        <div>
            {
                comments.map((comment) => {
                    return <li>{comment.content}</li>
                })
            }
        </div>
    )
}

export default Comments