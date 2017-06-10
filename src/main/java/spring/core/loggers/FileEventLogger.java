package spring.core.loggers;

import org.apache.commons.io.FileUtils;
import spring.core.beans.Event;
import spring.core.beans.EventLoger;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class FileEventLogger implements EventLoger{

    private String fileName;
    private File fileEventLog;

    FileEventLogger(String fileName){
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try{
            FileUtils.writeStringToFile(fileEventLog, event.toString(), true);
        } catch (IOException exception){
            System.out.println("Oops. Something wrong with saving too file");
        }
    }

    public void init() throws IOException{
        this.fileEventLog = new File(fileName);

        if (!fileEventLog.canWrite() && fileEventLog.exists()){
            throw new IOException("File: " + fileName + " not ready!");
        } else if (!fileEventLog.exists()){
            try{
                fileEventLog.createNewFile();
            } catch(Exception exception){
                throw new IllegalArgumentException("Can't create file ", exception);
            }
        }
    }
}
