import React from 'react'
import Menu from '../menu'
import './Navbar.css'

function Navbar(){
    return(
        <div className={"container"}>
            <nav className="navbar fixed-top justify-content-space-around bg-light">
                    <div className={"navbar-element"}>
                        <Menu/>
                    </div>
                    <div className="navbar-brand navbar-element">
                        Sticky Notes
                    </div>
                    <div className="navbar-text navbar-element">
                        Login
                    </div>
            </nav>
        </div>
    )
};

export default Navbar;