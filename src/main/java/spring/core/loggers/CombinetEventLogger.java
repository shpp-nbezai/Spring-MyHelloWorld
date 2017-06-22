package spring.core.loggers;

import spring.core.beans.Event;

import java.util.Collection;

/**
 *
 */
public class CombinetEventLogger implements EventLogger {
   private Collection<EventLogger> loggers;

    public CombinetEventLogger(Collection<EventLogger> loggers){
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger: loggers){
            eventLogger.logEvent(event);
        }
    }

}
