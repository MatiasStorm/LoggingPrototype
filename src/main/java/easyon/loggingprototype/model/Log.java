package easyon.loggingprototype.model;

import java.sql.Timestamp;

public class Log {
    private long id;
    private String origin;
    private String description;
    private int orderNumber;
    private Timestamp timeStamp;
    protected String type;

    public Log() {
        this.type = "NOTIFICATION";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getType(){
        return this.type;
    }
}
