package timecheckbackend.timecheckbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TimeCheckBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TimeCheckBackendApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TimeCheckBackendApplication.class);
    }

}
