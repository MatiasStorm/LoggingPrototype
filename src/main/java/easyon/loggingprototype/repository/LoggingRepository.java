package easyon.loggingprototype.repository;

import easyon.loggingprototype.model.ErrorLog;
import easyon.loggingprototype.model.Log;
import easyon.loggingprototype.repository.logging.*;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoggingRepository {
    private JdbcTemplate jdbcTemplate;
    private ILogHandler handler;

    public LoggingRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.handler = new LogHandler(jdbcTemplate);
        this.handler.setNext(new ErrorLogHandler(jdbcTemplate));
    }

    public void log(Log log){
        this.handler.handle(log);
    }

    public List<Log> getLogs(){
        List<Log> logs = jdbcTemplate.query(
            "SELECT * FROM log",
            (ResultSet rs, int rowCount) -> {
                Log log = new Log();
                log.setId(rs.getInt("id"));
                log.setOrigin(rs.getString("origin"));
                log.setDescription(rs.getString("description"));
                log.setOrderNumber(rs.getInt("order_number"));
                log.setTimeStamp(rs.getTimestamp("time_stamp"));
                return log;
            }
        );
        List<ErrorLog> errorLogs = jdbcTemplate.query(
            "SELECT * FROM error_log",
            (ResultSet rs, int rowCount) -> {
                ErrorLog log = new ErrorLog();
                log.setId(rs.getInt("id"));
                log.setOrigin(rs.getString("origin"));
                log.setDescription(rs.getString("description"));
                log.setOrderNumber(rs.getInt("order_number"));
                log.setTimeStamp(rs.getTimestamp("time_stamp"));
                return log;
            }
        );

        logs.addAll(errorLogs);

        return logs;
    }
}

