package de.opm.dataset.events;

import de.opm.dataset.output.LogEntry;
import de.opm.template.activities.Activity;

/**
 * An Event which specifies Shipment Ammount and Shipment Carrier
 */
public class ShipmentEvent extends Event{
    private int shipment_ammount;
    private String shipment_carrier;

    protected ShipmentEvent(Activity activity, long timestamp, int shipment_ammount, String shipment_carrier){
        super(activity, timestamp);
        this.shipment_ammount = shipment_ammount;
        this.shipment_carrier = shipment_carrier;
    }

    @Override
    public LogEntry toLogEntry(int case_id){
        LogEntry entry = super.toLogEntry(case_id)
        .addShipmentAmmount(shipment_ammount)
        .addShipmentCarrier(shipment_carrier);

        return entry;
    }
    
}
