package de.opm.template.variants;

import org.json.JSONArray;
import org.json.JSONObject;

import de.opm.template.variants.parameters.Parameters;
import de.opm.template.variants.parameters.VariantParameters;

public class VariantJSON {
    /**
     * 
     * @param json_Variant JSONObject containing variant data
     * @param key identifier for Variant
     * @return Instance of Variant that was created
     */
    protected static Variant getVariantFromJSON(JSONObject json_Variant, String key){
        VariantParameters params = Parameters.getVariantParameters(json_Variant);
        Variant variant = new Variant(key, params);

        JSONArray array = json_Variant.getJSONArray("order_of_execution");
        for(int i = 0 ; i < array.length() ; i++){
            JSONObject json_step = array.getJSONObject(i);

            String activity_key = json_step.getString("activity");

            int chance_of_occurrence = json_step.optInt("chance_of_occurrence", 100);
            int chance_of_repetition = json_step.optInt("chance_of_repetition", 0);

            VariantStep step = new VariantStep(activity_key, chance_of_occurrence, chance_of_repetition);
            variant.addStep(step);
        }

        return variant;
    }
}
