package de.opm.dataset.events;

import de.opm.dataset.output.LogEntry;
import de.opm.template.activities.Activity;

/**
 * most basic form of an Event. Contains Activity and timestamp. 
 */
public class Event {
    private long timestamp;
    private Activity activity;

    protected Event(Activity activity, long timestamp){
        this.activity = activity;
        this.timestamp = timestamp;
    }
    
    /**
     * 
     * @param case_id 
     * @return Logentry-instance, wich contains all attributes of an Event 
     */
    public LogEntry toLogEntry(int case_id){
        LogEntry entry = new LogEntry(case_id, activity, timestamp);
        return entry;
    }
}