package poly.edu.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        Object v = session.getAttribute(name);
        return v == null ? null : (T) v;
    }

    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    public void remove(String name) {
        session.removeAttribute(name);
    }
}
