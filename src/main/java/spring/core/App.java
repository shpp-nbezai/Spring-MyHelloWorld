package spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.beans.EventLoger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class App {
    private Client client;
    private EventLoger eventLogger;
    public App(Client client, EventLoger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        for (int i=0; i < 5; i++){
            Event event = ctx.getBean(Event.class);
            app.logEvent(event, "Some event from user " + i);
        }
        ctx.close();
    }

    private void logEvent(Event event, String msg){
        String message = msg.replaceAll(client.getId().toString(), client.getFullName());
        event.setMessage(message);
        eventLogger.logEvent(event);
    }
}
