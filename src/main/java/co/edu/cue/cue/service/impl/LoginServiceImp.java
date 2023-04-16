package co.edu.cue.cue.service.impl;

import co.edu.cue.cue.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImp implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new
                Cookie[0];
        return Arrays.stream(cookies).filter(c-> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
