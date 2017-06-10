package spring.core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class Event {
private final static AtomicInteger AUTO_ID = new AtomicInteger(0);
private int id;
private String msg;
private Date date;
private DateFormat dateFormat;

    public Event(Date eventDate, DateFormat dateFormat){
        this.id = AUTO_ID.getAndIncrement();
        this.date = eventDate;
        this.dateFormat = dateFormat;
    }

    public void setMessage(String eventMessage){
        this.msg = eventMessage;
    }

    public String getMessage(){
        return this.msg;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String toString(){
        String eventFields = "Id = " + id + "; Message = " + msg + "; Date = " + dateFormat.format(date) + ";";
        return eventFields;
    }
}
