import React from 'react';
import Navbar from "../navbar";
import './Header.css'

function Header(){
    return (
        <div className={"temporary-height-fix"}>
            <Navbar/>
        </div>
    )
}

export default Header;