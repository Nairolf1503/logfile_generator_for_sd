package de.opm.template.variants;

import java.util.Hashtable;

/**
 * Singleton containing a Hashtable to store and look up all Variants for later use.
 */
public class VariantRepository {
    private static VariantRepository instance = new VariantRepository();
    private Hashtable<String,Variant> variants_table = new Hashtable<String,Variant>();

    private VariantRepository(){}

    public static void reset(){ instance = new VariantRepository(); }

    public static void addVariant(Variant variant){
        String variant_key = variant.getKey();
        instance.variants_table.put(variant_key, variant);
        System.out.println(variant_key + " was added to the VariantPool");
    }

    public static Variant getVariantByKey(String variant_key){
        Variant variant = instance.variants_table.get(variant_key);
        if(variant == null){
            System.out.println(variant_key + " was not found in the VariantPool");
        }
        return variant;
    }

    public static String[] getVariantKeys(){
        int number_variants = instance.variants_table.size();
        String[] keys = instance.variants_table.keySet().toArray(new String[number_variants]);
        return keys;
    }
}
