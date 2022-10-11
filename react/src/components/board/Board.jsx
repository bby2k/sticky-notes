//React library imports
import React, {useEffect} from 'react'
import axios from 'axios';

//CSS3 imports
import './Board.css'

//React Components imports
import Note from "./note";
import BoardHeader from "./board_header";
import Loading from "../common/loading";

function Board(props){
    let boardId = props.id;
    let [notes, setNotes] = React.useState([]);
    useEffect(() => {
        axios(`api/board/${boardId}`)
            .then(response => {setNotes(response.data.notes)})

    }, [boardId])

    return(
        <div>
            <BoardHeader/>
            <div className={"container board"}>
                <div className={"row justify-content-flex-start"}>
                    {notes.length === 0?
                        <div className={"board-loading"}>
                            <Loading appearance={"text-light"}/>
                        </div>
                        : notes.map(data => {
                        return(
                            <div className="col col-lg-4">
                                <Note title={data.title} description={data.description}/>
                            </div>
                        )
                    })}

                    {/*<div className="col col-lg-4">*/}
                    {/*    <Note title={"Working prop"} description={"Working prop"}/>*/}
                    {/*</div>*/}
                </div>
            </div>
        </div>
    )
}

export default Board