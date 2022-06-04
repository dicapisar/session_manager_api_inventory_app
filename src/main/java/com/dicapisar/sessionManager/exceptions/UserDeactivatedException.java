package com.dicapisar.sessionManager.exceptions;

import org.springframework.http.HttpStatus;

public class UserDeactivatedException extends SessionManagerException{
    public UserDeactivatedException(){
        super("User deactivated", HttpStatus.BAD_REQUEST);
    }
}
