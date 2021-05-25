package easyon.loggingprototype.repository.logging;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import easyon.loggingprototype.model.Log;

public class LogHandler extends AbstractLogHandler {

    public LogHandler(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }
    
    public void handle(Log log){
        if(log.getClass() == Log.class){
            this.jdbcTemplate.update(
                    "INSERT INTO log (origin, description, order_number) VALUES (?, ?, ?)",
                    log.getOrigin(),
                    log.getDescription(),
                    log.getOrderNumber()
            );
        }
        else {
            this.next.handle(log);
        }
    }


}
