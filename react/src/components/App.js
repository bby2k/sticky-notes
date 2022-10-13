// React library imports
import React from "react";

// CSS3 imports
import './App.css';

//React Components imports
import Board from "./board";
import {Header, Notification} from './common'
import {BoardContext} from "../context/BoardContext";


function App() {
    //TODO: This is a temporary test board, it will work dynamically with backend and axios fetching.
    const welcomeBoard = {
        name:"Welcome to Sticky Notes",
        id:"board id : 1",
        permission:"EDITOR",
        notes:{
            0:{
                title:"Working on requests",
                message:"Still working on request logic with Axios."},
            1:{
                title:"Better UX",
                message:"The main point of this pet project is to be better with react."
            }
        }
    }
    let [shownBoard, setShownBoard] = React.useState(welcomeBoard);
  return (
    <div className="App">
        <BoardContext.Provider value={{shownBoard, setShownBoard}}>
            <Notification/>
            <Header/>
            <Board/>
        </BoardContext.Provider>
    </div>
  );
}

export default App;
