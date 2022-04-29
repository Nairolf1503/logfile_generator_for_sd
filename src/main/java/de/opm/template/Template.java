package de.opm.template;

import java.io.File;

import de.opm.template.activities.Activities;
import de.opm.template.variants.Variants;
import de.opm.template.variants.parameters.Parameters;

public class Template {
    /**
     * 
     * @param path_to_activities path on machine leadig to JSON-file containting Activities
     * @param path_to_variants path on machine leadig to JSON-file containting Variants
     */

    public static void loadParamsFromFile(File file){
        Parameters.loadDefaultParams(file);
    }

    public static void loadActivitiesFromFile(File file){
        Activities.reset();
        Activities.loadActivitiesFromFile(file);
    }

    public static void loadVariantsFromFile(File file){
        Variants.reset();
        Variants.loadVariantsFromDisk(file);
    }
}
