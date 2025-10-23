package poly.edu.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    public String getString(String name, String defaultValue) {
        String v = request.getParameter(name);
        return (v == null || v.isEmpty()) ? defaultValue : v;
    }

    public int getInt(String name, int defaultValue) {
        try {
            String v = request.getParameter(name);
            return (v == null || v.isEmpty()) ? defaultValue : Integer.parseInt(v);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public double getDouble(String name, double defaultValue) {
        try {
            String v = request.getParameter(name);
            return (v == null || v.isEmpty()) ? defaultValue : Double.parseDouble(v);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        String v = request.getParameter(name);
        return (v == null || v.isEmpty()) ? defaultValue : Boolean.parseBoolean(v);
    }

    public Date getDate(String name, String pattern) {
        try {
            String v = request.getParameter(name);
            if (v == null || v.isEmpty()) return null;
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(v);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public File save(MultipartFile file, String path) {
        if (file == null || file.isEmpty()) return null;
        try {
            String realPath = request.getServletContext().getRealPath("/");
            File dir = new File(realPath + path);
            if (!dir.exists()) dir.mkdirs();
            String name = file.getOriginalFilename();
            File saved = new File(dir, name);
            file.transferTo(saved);
            return saved;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
