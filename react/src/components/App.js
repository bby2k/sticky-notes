// React library imports
import React from "react";
import {BrowserRouter, Routes, Route} from "react-router-dom";

// CSS3 imports
import './App.css';

//React Components imports
import Board from "./board";
import {Header, Notification} from './common'
import {BoardContext} from "../context/BoardContext";

import {Login} from "./authentication";


function App() {
    //TODO: This is a temporary test board, it will work dynamically with backend and axios fetching.
    const welcomeBoard = {
        name:"Welcome to Sticky Notes",
        id:"1",
        permission:"EDITOR",
        notes:[{
                title : "The Project",
                message : "Sticky Notes is a web application where you can share Board and Notes with other users."
            },
            {
                title : "Current Stack",
                message : "React, HTML5, CSS3, Git, Bootstrap"
            },
            {
                title : "UX & UI",
                message : "The main point of this pet project is to get better with React. I wanted to develop this project with a functioning mobile viewport & responsive features."
            },
            {
                title: "Features",
                message: "Menu, Create-board, Navbar, Responsive Viewport, Notifications, Add-note, Add-board, "
            }
        ]
    }
    let [shownBoard, setShownBoard] = React.useState(welcomeBoard);
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={
                    <BoardContext.Provider value={{shownBoard, setShownBoard}}>
                        <Notification/>
                        <Header/>
                        <Board/>
                    </BoardContext.Provider>
                }/>
                <Route path={"/login"} element={
                    <Login/>
                }/>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
