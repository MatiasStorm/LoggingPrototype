package easyon.loggingprototype.repository.logging;

import org.springframework.jdbc.core.JdbcTemplate;

import easyon.loggingprototype.model.ErrorLog;
import easyon.loggingprototype.model.Log;

public class ErrorLogHandler extends AbstractLogHandler {

    public ErrorLogHandler(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }

    public void handle(Log log){
        if(log.getClass() == ErrorLog.class){
            this.jdbcTemplate.update(
                    "INSERT INTO error_log (origin, description, order_number) VALUES (?, ?, ?)",
                    log.getOrigin(),
                    log.getDescription(),
                    log.getOrderNumber()
            );
        }
    }
}
