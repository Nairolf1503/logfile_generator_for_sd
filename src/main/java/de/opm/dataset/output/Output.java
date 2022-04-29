package de.opm.dataset.output;

import java.io.IOException;

import de.opm.dataset.cases.Case;
import de.opm.dataset.events.Event;

public class Output {

    /**
     * Writes generated Cases to ./logfile.csv
     * @param cases_arr Cases to be written to the Logfile
     */
    public static void pritToLogfile(Case[] cases_arr) {
        LogWriter writer = new LogWriter("./logfile.csv");
        
        try {
            writer.writeLineToLogFile(LogEntry.getHeader());
            for(Case case_ : cases_arr){
                Event[] events = case_.getEvents();
                for(Event event : events){
                    String line = event.toLogEntry(case_.getCaseID()).toLine();
                    writer.writeLineToLogFile(line);
                }
            }

            writer.closeWriter();
            System.out.println("Logfile Generator run was finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}