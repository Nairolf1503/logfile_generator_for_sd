package de.opm.dataset.events;

import de.opm.dataset.cases.Case;
import de.opm.template.activities.Activity;

public class Events {
    /**
     * 
     * @param activity Activity which serves as a template for the Event
     * @param case_ Case from which special attributes like Order Ammount are derived
     * @return 
     */
    public static Event getEventFromTemplates(Activity activity, Case case_){
        Event event = null;
        long timestamp = case_.getNextTimestamp();
        switch(activity.getType()){
            case normal:
                event = new Event(activity, timestamp);
                break;
            case order:
                int order_ammount = case_.getOrderAmmount();
                event = new OrderEvent(activity, timestamp, order_ammount);
                break;
            case payment:
                double payment_ammount = case_.getPaymentAmmount();
                event = new PaymentEvent(activity, timestamp, payment_ammount);
                break;
            case shipment:
                int shipment_ammount = case_.getShipmentAmmount();
                String shipment_carrier = case_.getShipmentCarrier();
                event = new ShipmentEvent(activity, timestamp, shipment_ammount, shipment_carrier);
                break;
            default:
                break;
            
        }

        return event;
    }
}
