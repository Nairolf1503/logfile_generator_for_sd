package de.opm.template.variants;

import java.util.ArrayList;
import java.util.List;

import de.opm.template.variants.parameters.VariantParameters;

public class Variant {
    private String key;
    private List<VariantStep> order_of_execution = new ArrayList<VariantStep>();

    private VariantParameters params;
    
    protected Variant(String key, VariantParameters params){
        this.key = key;
        this.params = params;
    }

    public String getKey(){
        return key;
    }

    protected void addStep(VariantStep step){
        order_of_execution.add(step);
        System.out.println("Variant " + key + " now is made up of " + order_of_execution.size() + " Activities after " + step.getActivityKey() + " was added");
    }

    public int getOrderAmmount(){
        int order_ammount = params.getOrderAmmount();
        return order_ammount;
    }

    public int getShipmentAmmount(int order_ammount){
        int shipment_ammount = params.getShipmentAmmount(order_ammount);
        return shipment_ammount;
    }

    public String getShipmentCarrier(){
        String shipment_carrier = params.getShipmentCarrier();
        return shipment_carrier;
    }

    public double getPaymentAmmount(int shipment_ammount){
        double payment_ammount = params.getPaymentAmmount(shipment_ammount);
        return payment_ammount;
    }
    /**
     * 
     * @return Array of String containing Activity-Keys. Keys may appear duplicate or be skipped if the chance_of_repetition or chance_of_occurrence
     */
    public String[] getOrderOfExection(){
        List<String> activity_keys = new ArrayList<String>();
        order_of_execution.forEach((variant_step) -> {
            String activity_key = variant_step.getActivityKey();
            activity_keys.add(activity_key);
        });
        
        String[] act_arr = activity_keys.toArray(new String[activity_keys.size()]);
        return act_arr;
    }

    public String[] getActivities(){
        List<String> activities_happend = new ArrayList<>();
        for(int i = 0 ; i < order_of_execution.size() ; i++){
            VariantStep step = order_of_execution.get(i);
            if(step.doesHappen()){
                String activity_key = step.getActivityKey();
                activities_happend.add(activity_key);
                if(step.happensAgain()){
                    activities_happend.add(activity_key);
                }
            }
        }
        int list_size = activities_happend.size();
        String[] act_arr = activities_happend.toArray(new String[list_size]);
        return act_arr;
    }
}
