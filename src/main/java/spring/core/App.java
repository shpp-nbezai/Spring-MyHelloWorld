package spring.core;

import spring.core.beans.Client;
import spring.core.beans.EventLoger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Meltic-Hollyolly on 11.05.2017.
 */
public class App {
    private Client client;
    private EventLoger eventLogger;
    public App(Client client, EventLoger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent("Some event from user 1");
        app.logEvent("Some event from user 2");
    }

    private void logEvent(String msg){
        String message = msg.replaceAll(client.getId().toString(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
