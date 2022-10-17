import React from 'react';
import {NotificationManager} from 'react-notifications';

function Notification(type, title, message, callback, priority){
    const popUpTime = 6000;
    switch (type) {
        case 'info':
            NotificationManager.info(message, title, popUpTime, callback, priority);
            break;
        case 'success':
            NotificationManager.success(message, title, popUpTime, callback, priority);
            break;
        case 'warning':
            NotificationManager.warning(message, title, popUpTime, popUpTime, priority);
            break;
        case 'error':
            NotificationManager.error(message, title, popUpTime, popUpTime, priority);
            break;

    }
}

export default Notification;