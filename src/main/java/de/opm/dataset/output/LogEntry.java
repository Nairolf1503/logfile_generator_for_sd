package de.opm.dataset.output;

import java.text.SimpleDateFormat;

import de.opm.template.activities.Activity;

/**
 * Data class which stores all possible attributes for an Event and transforms them into a String
 */
public class LogEntry {
    private final static String sep = ",";
    private final SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public static String getHeader(){
        LogEntry header = new LogEntry();
        header.case_id = "CaseID";
        header.activity = "Activity";
        header.transaction = "Transaction";
        header.timestamp = "Timestamp";
        header.role = "Role";
        header.department = "Department";
        header.order_ammount = "Order_Ammount";
        header.shipment_ammount = "Shipment_Ammount";
        header.shipment_carrier = "Shipment_Carrier";
        header.payment_ammount = "Payment_Ammount";

        return header.toLine();
    }


    private String case_id = "";
    private String activity = "";
    private String transaction = "";
    private String timestamp = ""; 
    private String role = "";
    private String department = "";
    private String order_ammount = "";
    private String shipment_ammount = "";
    private String shipment_carrier = "";
    private String payment_ammount = "";

    private LogEntry(){}

    public LogEntry(int case_id, Activity activity, long timestamp){
        this.case_id = Integer.toString(case_id);
        this.activity = activity.getName();
        this.transaction = activity.getTransaction();
        this.role = activity.getRole();
        this.department = activity.getDepartment();
        this.timestamp = date_format.format(timestamp);
    }
    
    public LogEntry addOrderAmmount(int order_ammount){ 
        this.order_ammount = Integer.toString(order_ammount); 
        return this; 
    }

    public LogEntry addShipmentAmmount(int shipment_ammount){ 
        this.shipment_ammount = Integer.toString(shipment_ammount); 
        return this;
    }

    public LogEntry addShipmentCarrier(String shipment_carrier){ 
        this.shipment_carrier = shipment_carrier; 
        return this; 
    }

    public LogEntry addPaymentAmmount(double payment_ammount){ 
        this.payment_ammount = Double.toString(payment_ammount); 
        return this; 
    }

    /**
     * 
     * @return String, which contains Events attributes seperated by comma (CSV)
     */
    public String toLine(){
        String line = case_id + sep + activity + sep + transaction + sep + timestamp + sep + role + sep + department + sep + order_ammount + sep + shipment_ammount + sep + shipment_carrier + sep + payment_ammount;
        return line; 
    }
}
