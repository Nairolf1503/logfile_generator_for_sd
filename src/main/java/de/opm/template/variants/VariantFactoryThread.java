package de.opm.template.variants;

import org.json.*;

import de.opm.template.variants.parameters.*;

public class VariantFactoryThread extends Thread {
    private String variant_key;
    private JSONObject variant_json;

    protected VariantFactoryThread (String variant_key, JSONObject variant_json){
        this.variant_key = variant_key;
        this.variant_json = variant_json;
    }

    @Override
    public void run(){
        VariantParameters params = Parameters.getVariantParameters(variant_json);
        Variant variant = new Variant(variant_key, params);

        JSONArray array = variant_json.getJSONArray("order_of_execution");
        for(int i = 0 ; i < array.length() ; i++){
            JSONObject json_step = array.getJSONObject(i);

            String activity_key = json_step.getString("activity");

            int chance_of_occurrence = json_step.optInt("chance_of_occurrence", 100);
            int chance_of_repetition = json_step.optInt("chance_of_repetition", 0);

            VariantStep step = new VariantStep(activity_key, chance_of_occurrence, chance_of_repetition);
            variant.addStep(step);
        }
        VariantRepository.addVariant(variant);
    }
}
