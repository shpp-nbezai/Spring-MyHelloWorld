package spring.core.loggers;

import spring.core.beans.EventLoger;

/**
 * Created by Meltic-Hollyolly on 11.05.2017.
 */
public class ConsoleEventLoger implements EventLoger {

    public void logEvent(String msg){
        System.out.println("Message: " + msg);
    }
}
