package de.opm.template.variants.parameters;

import java.io.File;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import de.opm.template.input.Input;

public class DefaultParameters {
    private static int min_order = 1;
    private static int max_order = 100;
    private static String[] shipment_carriers = new String[]{"DHL", "DPD", "Hermes", "FedEx", "UPS"};
    private static double price = 500;
    private static int min_discount = 0;
    private static int max_discount = 10;

    protected static void loadDefaultParams(File file){
        JSONObject config = null;
        try {
            config = Input.getJSONFromFile(file);
            JSONObject params_json = config.getJSONObject("parameters");

            VariantParameters params = Parameters.getVariantParameters(params_json);
            min_order = params.getMinOrder();
            max_order = params.getMaxOrder();
            shipment_carriers = params.getShipmentCarriers();
            price = params.getPrice(); 
            min_discount = params.getMinDiscount();
            max_discount = params.getMaxDiscount();
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println(file.getAbsolutePath() + " does not contain valid JSON to create config");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error occured when trying to read " + file.getAbsolutePath() + ". Please ensure that this file exists next to the Generator-JAR");
        }
    }

    public static int getDefaultMinOrder(){ return min_order; }
    public static int getDefaultMaxOrder(){ return max_order; }
    public static String[] getDefaultShipmentCarriers(){ return shipment_carriers; }
    public static double getDefaultPrice(){ return price; }
    public static int getDefaultMinDiscount(){ return min_discount; }
    public static int getDefaultMaxDiscount(){ return max_discount; }

}
