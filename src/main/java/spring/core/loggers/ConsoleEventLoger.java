package spring.core.loggers;

import spring.core.beans.Event;
import spring.core.beans.EventLoger;

/**
 *
 */
public class ConsoleEventLoger implements EventLoger {

    public void logEvent(Event event){
        System.out.println("Message: " + event.toString());
    }
}
