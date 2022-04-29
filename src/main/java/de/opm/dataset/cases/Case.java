package de.opm.dataset.cases;

import java.util.ArrayList;
import java.util.List;

import de.opm.dataset.events.Event;
import de.opm.dataset.time.Timesequence;
import de.opm.template.variants.Variant;

/**
 * Data Class containing important information for a Case
 */
public class Case {
    private int case_id = CaseID.getInstance().getID();
    private List<Event> events = new ArrayList<Event>();
    private Variant variant;
    private int order_ammount;
    private int shipment_ammount;
    private Timesequence time_sequence;

    /**
     * 
     * @param variant Template for this Case, from this Order Ammount etc are derived
     * @param first_timestamp starting timestamp for the Events of this Case
     * @param time_factor all Events-durations are multiplied by this factorto create a normally distributed duration for each case
     */
    protected Case(Variant variant, long first_timestamp, double time_factor){
        this.variant = variant;
        this.order_ammount = variant.getOrderAmmount();
        this.shipment_ammount = order_ammount;
        this.time_sequence = new Timesequence(first_timestamp, time_factor);
    }

    public int getCaseID(){ return case_id; }
    public int getOrderAmmount(){ return order_ammount; }
    public int getShipmentAmmount(){ return shipment_ammount; }
    public String getShipmentCarrier(){ return variant.getShipmentCarrier(); }
    public double getPaymentAmmount(){ return variant.getPaymentAmmount(order_ammount); }

    public long getNextTimestamp(){
        return time_sequence.getNextTimestamp();
    }

    protected void addEvent(Event event){ events.add(event); }

    public Event[] getEvents(){
        int list_size = events.size();
        Event[] events_arr = events.toArray(new Event[list_size]);
        return events_arr;
    }
}
