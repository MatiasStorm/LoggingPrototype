package easyon.loggingprototype.repository.logging;

import easyon.loggingprototype.model.Log;

public interface ILogHandler{
    public void setNext(ILogHandler handler);
    public void handle(Log log);
}
