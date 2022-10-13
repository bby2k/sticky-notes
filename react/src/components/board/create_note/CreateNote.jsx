//React library imports
import React, {useContext} from 'react'
import axios from "axios";

//CSS3 imports
import './CreateNote.css'

//React Components imports
import {BoardContext} from "../../../context/BoardContext";
import Notification from "../../../hooks";

function CreateNote() {
    let {shownBoard} = useContext(BoardContext)
    const [textAreaCharCount, setTextAreaCharCount] = React.useState(0);

    return (
        <div className={"modal fade note-modal"} tabIndex={-1} data-backdrop={"static"} data-keyboard={"false"} id={"createNoteModal"} role={"dialog"} aria-labelledby={"exampleModalLabel"} aria-hidden={"true"}>
            <div className={"modal-dialog"} role={"document"}>
                <div className={"modal-content"}>
                    <div className="modal-header">
                        <input className={"note-create-title"} id={"note-title"} type="text" placeholder={"Note title"} maxLength={20}/>
                    </div>
                    <div>
                            <div className="modal-body">
                                <textarea className={"note-create-description"} id={"note-content"} name="test" cols="24" rows="7" maxLength={"150"} onChange={e => setTextAreaCharCount(e.target.value.length)}/>
                                <button onClick={() => addNoteListener(shownBoard.id)}>Add note</button>
                                <p className={"counter"}>{textAreaCharCount}/150</p>
                            </div>

                    </div>
                </div>
            </div>
        </div>
    );
}
function addNoteListener(boardID) {
    let noteTitle = document.getElementById("note-title").value
    let noteContent = document.getElementById("note-content").value

    let isTitleTextValid = validText(noteTitle)
    let isContentTextValid = validText(noteContent)

    //Checking if both of the inputs are valid characters, don't accept whitespaces and newlines.
    if(isTitleTextValid && isContentTextValid){
        addNote(noteTitle, noteContent, boardID)
    //If the title text isn't valid but the content text is.
    } else if (!isTitleTextValid && isContentTextValid){
        Notification('error', 'Missing text', 'Missing text from note title. You cannot add nameless notes')
    //If the content text isn't valid but the title text is.
    } else if (!isContentTextValid && isTitleTextValid){
        Notification('error', 'Missing text', 'Missing text from note content. You cannot add empty notes.')
    } else {
    //If both of the title & content text are incorrect.
        Notification('error', "Missing text", "Missing text from note title & content. You cannot add nameless or empty notes.");
    }
}

function addNote(noteTitle, noteContent, boardID){


    axios.post(`/api/note/addNote/${boardID}`, {
        note: {
            title:noteTitle,
            content:noteContent
        }
    }).then(function (response){
        if(response.status === 200){
            Notification('success',"Note added to board");
        }
    }).catch(function (error) {
        if(error.response){
            console.log(error);
            Notification("error", error.message)
        }
    })
}

// Check if the given text only contains whitespace or new line characters
function validText(text) {
    if(text.length > 0) {
        for (let textElement of text) {
            if(textElement !== '\n' && textElement !== ' ')
                return true
        }
    }
    return false
}

export default CreateNote;