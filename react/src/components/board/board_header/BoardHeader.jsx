//React library imports
import React, {useContext} from "react";

//CSS3 imports
import './BoardHeader.css';

//React Components imports
import CreateNote from "../create_note";
import {BoardContext} from "../../../context/BoardContext";

function BoardHeader(){
    const {shownBoard} = useContext(BoardContext);
    return(
        <div className={"container options-container"}>
            <div className="row justify-content-center">
                <button className={"options-btn"} type={"button"} id={"add-note"} data-bs-toggle={"modal"} data-bs-target={"#createNoteModal"} data-keybord={"false"}>
                    <div className="col-2">
                        <i className="bi bi-sticky options-icon"></i>
                    </div>
                </button>
                <CreateNote/>

                <div className="col-8 options-board-name">
                    Magic Board
                </div>

                <button className={"options-btn"} type={"button"} id={"edit-board"}>
                    <div className="col-2">
                        <i className="bi bi-pencil options-icon"></i>
                    </div>
                </button>
            </div>

        </div>
    );
}

export default BoardHeader;