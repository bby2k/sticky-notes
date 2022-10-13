import React from 'react';
import {NotificationContainer} from "react-notifications";

import './NotificationContainer.css'

// This extra step is only needed to separate the custom CSS from the outer layers for easier management in development.
function NotificationContainerBox(){
    return(
        <NotificationContainer/>
    )
}

export default NotificationContainerBox;