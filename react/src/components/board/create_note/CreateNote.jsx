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
                    <div className="modal-body">
                        <textarea className={"note-create-description"} name="test" id="note-content" cols="24" rows="7" maxLength={"150"} onChange={e => setTextAreaCharCount(e.target.value.length)}/>
                        <p className={"counter"}>{textAreaCharCount}/150</p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CreateNote;