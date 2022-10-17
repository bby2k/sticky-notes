import React from 'react'
import './Note.css'

function Note(props){
    return(
        <div className={"note"}>
            <div className="container note-content-container">
                <h2>{props.title}</h2>
                <p>{props.description}</p>
            </div>
            <div className="container note-fold-container">
                <div className={"note-fold"} onClick={() => {moveToArchivedNotes()}}></div>
            </div>
        </div>
    )
}
function moveToArchivedNotes(){
}
export default Note;