package de.opm.template.variants;

import java.util.Hashtable;

/**
 * Singleton containing a Hashtable to store and look up all Variants for later use.
 */
public class VariantPool {
    private static VariantPool instance = null;
    protected static VariantPool getInstance(){
        if(instance == null){
            instance = new VariantPool();
        }
        return instance;
    }

    protected static void reset(){ instance = new VariantPool(); }

    private VariantPool(){}

    private Hashtable<String,Variant> variants_table = new Hashtable<String,Variant>();

    /**
     * 
     * @param variant Variant which will be added to the Pool. May Replace an existing Variant, if the keys are identical
     */
    protected void addVariant(Variant variant){
        String variant_key = variant.getKey();
        variants_table.put(variant_key, variant);
        System.out.println(variant_key + " was added to the VariantPool");
    }

    /**
     * 
     * @param key identifying key for Variant to be retrieved
     * @return desired instance of Variant if there is one, null otherwise
     */
    protected Variant getVariantByKey(String variant_key){
        Variant variant = variants_table.get(variant_key);
        if(variant == null){
            System.out.println(variant_key + " was not found in the VariantPool");
        }
        return variant;
    }

    
    /**
     * 
     * @return Array of String containing all keys to Variants currently in the Pool
     */
    protected String[] getVariantKeys(){
        int number_variants = variants_table.size();
        String[] keys = variants_table.keySet().toArray(new String[number_variants]);
        return keys;
    }
}
