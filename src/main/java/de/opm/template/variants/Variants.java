package de.opm.template.variants;

import java.io.*;
import java.util.*;

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

        System.out.println(System.currentTimeMillis());

        Set<String> key_set = json.keySet();
        String[] keys = key_set.toArray(new String[key_set.size()]);

        Thread[] creation_threads = new VariantFactoryThread[keys.length];

        for(int i = 0 ; i < keys.length ; i++){
            String variant_key = keys[i];
            JSONObject variant_json = json.getJSONObject(variant_key);
            creation_threads[i] = new VariantFactoryThread(variant_key, variant_json);
            creation_threads[i].start();
        }

        for(int i = 0 ; i < creation_threads.length ; i++){
            try {
                creation_threads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis());
    }
}
