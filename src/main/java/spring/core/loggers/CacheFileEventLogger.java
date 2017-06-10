package spring.core.loggers;

import spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CacheFileEventLogger extends FileEventLogger{

    private int cacheSize;
    private ArrayList<Event> cacheList;


    CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cacheList = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event){
        cacheList.add(event);
        if (cacheList.size() == cacheSize){
            this.writeEventFromCache();
            cacheList.clear();
        }
    }

    private void writeEventFromCache() {
        for(Event event: cacheList){
            super.logEvent(event);
        }
    }

    public void destroy(){
        if (!cacheList.isEmpty()){
            this.writeEventFromCache();
        }
    }
}
