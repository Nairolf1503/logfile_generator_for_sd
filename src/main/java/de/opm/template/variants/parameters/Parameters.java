package de.opm.template.variants.parameters;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;

public class Parameters {

    public static VariantParameters getVariantParameters(JSONObject json_variant){
        VariantParameters params = new VariantParameters();

        final int error_value = -1;
        int min_order = json_variant.optInt("min_order", error_value);
        if(min_order != error_value){
            params.setMinOrder(min_order);
        }

        int max_order = json_variant.optInt("max_order", error_value);
        if(max_order != error_value){
            params.setMaxOrder(max_order);
        }

        JSONArray carriers_arr = json_variant.optJSONArray("shipment_carriers");
        if(carriers_arr != null){
            int size_carriers = carriers_arr.length();
            String[] shipment_carriers = carriers_arr.toList().toArray(new String[size_carriers]);
            params.setShipmentCarriers(shipment_carriers);
        }

        double price = json_variant.optDouble("price");
        if(!Double.isNaN(price)){
            params.setPrice(price);
        }

        int min_discount = json_variant.optInt("min_discount", error_value);
        if(min_discount != error_value){
            params.setMinDiscount(min_discount);
        }

        int max_discount = json_variant.optInt("max_discount", error_value);
        if(max_discount != error_value){
            params.setMaxDiscount(max_discount);
        }

        return params;
    }

    public static void loadDefaultParams(File file){
        DefaultParameters.loadDefaultParams(file);
    }
}
