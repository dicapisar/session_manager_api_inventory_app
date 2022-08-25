package com.dicapisar.sessionManager.controllers;

import com.dicapisar.sessionManager.dtos.requests.LoginRequestDTO;
import com.dicapisar.sessionManager.dtos.responses.LoginResponseDTO;
import com.dicapisar.sessionManager.exceptions.ErrorLoginException;
import com.dicapisar.sessionManager.exceptions.UserDeactivatedException;
import com.dicapisar.sessionManager.services.ILoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private ILoginService loginService;

    @PostMapping()
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody @Valid LoginRequestDTO loginRequestDTO,
                                                      HttpSession session) throws ErrorLoginException, UserDeactivatedException {
        LoginResponseDTO response = loginService.loginUser(loginRequestDTO, session);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
