package de.opm.template.variants;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;

import de.opm.template.input.Input;

public class Variants {
    /**
     * 
     * @return All Keys for Variants from the VariantPool
     */
    public static String[] getVariantKeys(){
        String[] variant_keys = VariantRepository.getVariantKeys();
        return variant_keys;
    }

    /**
     * 
     * @param variant_key identifiers Variant in VariantPool
     * @return Variant with corresponding key, null if there is no Variant for this Key
     */
    public static Variant getVariantByKey(String variant_key){
        Variant variant = VariantRepository.getVariantByKey(variant_key);
        return variant;
    }

    /**
     * Resets VariantPool-Instance, clearing the Variant-Hashtable in the Process
     */
    public static void reset(){
        VariantRepository.reset();
    }

    /**
     * 
     * @param path_to_variants path to JSON-File containting variants
     */
    public static void loadVariantsFromDisk(File file){
        JSONObject json = null;
        try {
            json = Input.getJSONFromFile(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
