package co.edu.cue.cue.service.impl;

import co.edu.cue.cue.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceSessionImp implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
       HttpSession session = req.getSession();
       String username = (String) session.getAttribute("username");
        if (username != null) {
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
