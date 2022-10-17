import React from 'react';
import './Menu.css';
import UserBox from "../../user_box";

function Menu(){
    return (
        <div className={"menu"}>
            <button className="navbar-toggler" type="button" data-bs-toggle={"offcanvas"} data-bs-target={"#offcanvasExample"} aria-controls={"offcanvasExample"}>
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="offcanvas offcanvas-start" tabIndex={"-1"} id={"offcanvasExample"} aria-labelledby={"offcanvasExampleLabel"}>
                <div className="offcanvas-header">
                    <h5 className="offcanvas-title" id="offcanvasWithBackdropLabel">Sticky Notes</h5>
                    <button type="button" className="btn-close text-reset" data-bs-dismiss="offcanvas"
                            aria-label="Close">
                    </button>
                </div>
                <UserBox/>
                <div className="container">
                    <ul className={"list-group list-group-flush justify-content-right"}>

                        {/*Create Board list group element with dropdown functionality*/}
                        <li className={"list-group-item"}>
                            <button className="hidden-btn" type="button" id="create-board-button" onClick={()=>clickEvent("create-board")}>
                                    <div className="container justify-content-right ">
                                        <div className="row">
                                            <div className="col">
                                                <div className="icon-flipped">
                                                    <i className="bi bi-file-plus"></i>
                                                </div>
                                            </div>
                                            <div className="col-9 menu-text">
                                                <h5>Create Board</h5>
                                            </div>
                                        </div>
                                    </div>
                            </button>
                            <div className={"menu-button-display box hidden"} id={"create-board"}>
                                <div className="container">
                                    <input type="text" className="from-control box-input" placeholder={"New board's name . . ."} maxLength={20}/>
                                </div>
                            </div>
                        </li>

                        {/*This is the 'My Boards' menu point, it's a button which contains two element, an icon and the text itself.*/}
                        <li className={"list-group-item"}>
                            <button className="hidden-btn" type={"button"} id={"my-boards-button"} onClick={() => clickEvent("my-boards")}>
                                <div className="container justify-content-right">
                                    <div className="row">
                                        <div className="col">
                                            <i className="bi bi-collection"></i>
                                        </div>
                                        <div className="col-9 menu-text">
                                            <h5>My Boards</h5>
                                        </div>
                                    </div>
                                </div>
                            </button>
                            <div className={"menu-button-display box hidden"} id={"my-boards"}>
                                This is my boards
                            </div>
                        </li>

                        {/*This is the 'Join Board' menu point. it's a button which contains two element, an icon and the text itself. */}
                        <li className={"list-group-item"}>
                            <button className={"hidden-btn"} type={"button"} id={"join-board-button"} onClick={() => clickEvent("join-board")}>
                                <div className="container justify-content-right">
                                    <div className="row">
                                        <div className="col">
                                            <i className="bi bi-person-video"></i>
                                        </div>
                                        <div className="col-9 menu-text">
                                            <h5>Join Board</h5>
                                        </div>
                                    </div>
                                </div>
                            </button>
                            <div className={"menu-button-display box hidden"} id={"join-board"}>
                                Join this board
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    )
}
function clickEvent(target){
    const menuButtonDisplayElements = document.getElementsByClassName("menu-button-display");
    const element = document.getElementById(target);
    for (let menuButtonDisplayElement of menuButtonDisplayElements) {
        if(menuButtonDisplayElement !== element){
            menuButtonDisplayElement.classList.add('hidden')
        }
    }
    element.classList.toggle('hidden');
    // if(element.style.display !== "block"){
    //     element.style.display = "block"
    // } else {
    //     element.style.display = "none"
    // }
}

export default Menu;