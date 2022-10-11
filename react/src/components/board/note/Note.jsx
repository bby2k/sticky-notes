import React from 'react'
import './Note.css'

function Note(props){
    return(
        <div className={"note"}>
            <h2>{props.title}</h2>
            <p>{props.description}</p>
        </div>
    )
}
export default Note;