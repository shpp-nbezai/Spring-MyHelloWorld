package spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.loggers.EventLogger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 *
 */
public class App {
    private Client client;
    private EventLogger defaultLogger;
    private enum TYPE_LOGGER {INFO, ERROR};
    private Map<TYPE_LOGGER, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<TYPE_LOGGER, EventLogger> loggers){
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        for (int i=0; i < 5; i++){
            Event event = ctx.getBean(Event.class);
            app.logEvent(TYPE_LOGGER.INFO, event, "Some event from user " + i);
            app.logEvent(TYPE_LOGGER.ERROR, event, "Some ERROR event from app " + i);
        }
        ctx.close();
    }

    private void logEvent(TYPE_LOGGER typeLogger, Event event, String msg){
        EventLogger logger = loggers.get(typeLogger);
        if (logger == null){
            logger = defaultLogger;
        }
        String message = msg.replaceAll(client.getId().toString(), client.getFullName());
        event.setMessage(message);
        logger.logEvent(event);
    }
}
