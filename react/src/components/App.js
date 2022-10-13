// React library imports
import React from "react";

// CSS3 imports
import './App.css';

//React Components imports
import Board from "./board";
import {Header, Notification} from './common'
import {BoardContext} from "../context/BoardContext";


function App() {
  return (
    <div className="App">
        <div>
            <Header/>
        </div>
        <Board/>
    </div>
  );
}

export default App;
