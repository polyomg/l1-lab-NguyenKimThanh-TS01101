package poly.edu.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CookieService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    public Cookie get(String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        for (Cookie c : cookies) {
            if (c.getName().equals(name)) return c;
        }
        return null;
    }

    public String getValue(String name) {
        Cookie c = get(name);
        return c == null ? "" : c.getValue();
    }

    public Cookie add(String name, String value, int hours) {
        Cookie c = new Cookie(name, value);
        c.setMaxAge(hours * 3600);
        c.setPath("/");
        response.addCookie(c);
        return c;
    }

    public void remove(String name) {
        Cookie c = new Cookie(name, "");
        c.setMaxAge(0);
        c.setPath("/");
        response.addCookie(c);
    }
}
