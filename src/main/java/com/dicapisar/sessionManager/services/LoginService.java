package com.dicapisar.sessionManager.services;

import com.dicapisar.sessionManager.dtos.requests.LoginRequestDTO;
import com.dicapisar.sessionManager.dtos.responses.LoginResponseDTO;
import com.dicapisar.sessionManager.exceptions.ErrorLoginException;
import com.dicapisar.sessionManager.models.User;
import com.dicapisar.sessionManager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class LoginService implements ILoginService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public LoginResponseDTO loginUser(LoginRequestDTO loginRequest, HttpSession session) throws ErrorLoginException {
        User user = getUser(loginRequest);
        validateUser(user, loginRequest);
        generateSession(user, session);
        return generateLoginResponse(user, session);
    }

    private User getUser(LoginRequestDTO loginRequest) {
        return userRepository.getUserByIdAndIsActive(loginRequest.getName());
    }

    private void validateUser(User user, LoginRequestDTO loginRequest) throws ErrorLoginException {
        if (user == null) {
            throw new ErrorLoginException();
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new ErrorLoginException();
        }
    }

    private void generateSession(User user, HttpSession session) {
        session.setAttribute("Name", user.getName());
        session.setAttribute("Id", user.getName());
        session.setAttribute("Rol_Name", user.getName());
        session.setAttribute("Rol_Id", user.getName());
    }

    private LoginResponseDTO generateLoginResponse(User user, HttpSession session) {
        return new LoginResponseDTO(user.getId(),
                user.getName(),
                user.getRol().getId(),
                user.getRol().getName(),
                session.getId());
    }
}
