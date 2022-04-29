package de.opm.dataset.events;

import de.opm.dataset.output.LogEntry;
import de.opm.template.activities.Activity;

/**
 * Event which specifies an Order Ammount
 */
public class OrderEvent extends Event{
    private int order_ammount;

    protected OrderEvent(Activity activity, long timestamp, int order_ammount){
        super(activity, timestamp);
        this.order_ammount = order_ammount;
    }

    @Override
    public LogEntry toLogEntry(int case_id){
        LogEntry entry = super.toLogEntry(case_id)
        .addOrderAmmount(order_ammount);
        
        return entry;
    }    
}
