package com.dicapisar.sessionManager.services;

import com.dicapisar.sessionManager.dtos.requests.LoginRequestDTO;
import com.dicapisar.sessionManager.dtos.responses.LoginResponseDTO;
import com.dicapisar.sessionManager.exceptions.ErrorLoginException;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;


public interface ILoginService {
    LoginResponseDTO loginUser(LoginRequestDTO loginRequest, HttpSession session) throws ErrorLoginException;
}
