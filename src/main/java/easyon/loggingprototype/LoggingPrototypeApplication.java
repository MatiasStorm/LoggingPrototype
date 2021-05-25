package easyon.loggingprototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class LoggingPrototypeApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoggingPrototypeApplication.class, args);
    }
}
