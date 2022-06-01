package com.dicapisar.sessionManager.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorLoginException extends SessionManagerException{
    public ErrorLoginException(){
        super("User or Password incorrect", HttpStatus.BAD_REQUEST);
    }
}
