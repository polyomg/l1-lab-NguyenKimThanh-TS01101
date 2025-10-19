package poly.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Lab2Ts01101Java5Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Lab2Ts01101Java5Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Lab2Ts01101Java5Application.class);
    }
}
