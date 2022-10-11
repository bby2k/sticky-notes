import React from 'react';

function Loading(props) {
    return (
        <div className={"spinner-border "+ props.appearance}  role={"status"}>
            <span className="sr-only"></span>
        </div>
    )
}

export default Loading;