package de.opm.template.variants.parameters;

import java.util.Random;

public class VariantParameters {
    private int min_order = DefaultParameters.getDefaultMinOrder();
    private int max_order = DefaultParameters.getDefaultMaxOrder();
    private String[] shipment_carriers = DefaultParameters.getDefaultShipmentCarriers();
    private double price = DefaultParameters.getDefaultPrice();
    private int min_discount = DefaultParameters.getDefaultMinDiscount();
    private int max_discount = DefaultParameters.getDefaultMaxDiscount();

    protected void setMinOrder(int min_order){ this.min_order = min_order; }
    protected int getMinOrder(){ return min_order; }

    protected void setMaxOrder(int max_order){ this.max_order = max_order; }
    protected int getMaxOrder(){ return max_order; }

    protected void setShipmentCarriers(String[] shipment_carriers){ this.shipment_carriers = shipment_carriers; }
    protected String[] getShipmentCarriers(){ return shipment_carriers; }

    protected void setPrice(double price){ this.price = price; }
    protected double getPrice(){ return price; }

    protected void setMinDiscount(int min_discount){ this.min_discount = min_discount; }
    protected int getMinDiscount(){ return min_discount; }

    protected void setMaxDiscount(int max_discount){ this.max_discount = max_discount; }
    protected int getMaxDiscount(){ return max_discount; }

    public int getOrderAmmount(){
        int number = new Random().nextInt(max_order - min_order + 1) + min_order;
        return number;
    }

    public String getShipmentCarrier(){
        int number_carriers = shipment_carriers.length;
        int select_index = new Random().nextInt(number_carriers);
        String carrier = shipment_carriers[select_index];
        return carrier;
    }

    public int getShipmentAmmount(int order_ammount){
        return order_ammount;
    }
    
    public double getPaymentAmmount(int shipment_ammount){
        double total_full = price * shipment_ammount;
        int discount_perc = new Random().nextInt(max_discount - min_discount + 1) + min_discount;
        int payment_perc = 100 - discount_perc;
        double payment_ammount = payment_perc * total_full / 100;

        // rounding result to two decimal places
        payment_ammount = payment_ammount * 100;
        long rounded = Math.round(payment_ammount);
        payment_ammount = rounded / 100;

        return payment_ammount;
    }
}
