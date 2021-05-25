package easyon.loggingprototype.repository.logging;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractLogHandler implements ILogHandler{
    protected ILogHandler next;
    protected JdbcTemplate jdbcTemplate;

    public AbstractLogHandler(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setNext(ILogHandler handler){
        this.next = handler;
    }
}

