import React from 'react'
import './UserBox.css'

function UserBox(){
    return(
        <div className={"container profile-container"}>
            <div className={"row justify-content-center"}>
                <div className={"profile-picture circle"}>
                    <div className={"picture"}>
                        <i className="bi bi-person-fill icon-lg color-light"></i>
                    </div>
                </div>
            </div>
            <div>
                Login
            </div>
        </div>
    )
}

export default UserBox;