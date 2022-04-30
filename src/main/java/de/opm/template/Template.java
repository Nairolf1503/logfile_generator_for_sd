package de.opm.template;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.opm.template.activities.Activities;
import de.opm.template.variants.Variants;
import de.opm.template.variants.parameters.Parameters;

public class Template {
    /**
     * 
     * @param path_to_activities path on machine leadig to JSON-file containting Activities
     * @param path_to_variants path on machine leadig to JSON-file containting Variants
     */

    private static List<ConfigChangeObserver> observers = new ArrayList<ConfigChangeObserver>();

    public static void loadInitialFiles(){
        loadParamsFromFile(new File("config.json"));
        loadActivitiesFromFile(new File("activities.json"));
        loadVariantsFromFile(new File("variants.json"));
    }

    public static void addObserver(ConfigChangeObserver observer){
        observers.add(observer);
    }

    public static void loadParamsFromFile(File file){
        Parameters.loadDefaultParams(file);

        if(!file.isFile()){ return; }
        for(ConfigChangeObserver observer : observers){
            String path_to_config = file.getAbsolutePath();
            observer.setConfigPath(path_to_config);
        }
    }

    public static void loadActivitiesFromFile(File file){
        Activities.reset();
        Activities.loadActivitiesFromFile(file);

        if(!file.isFile()){ return; }
        for(ConfigChangeObserver observer : observers){
            String path_to_activities = file.getAbsolutePath();
            observer.setActivitiesPath(path_to_activities);
        }
    }

    public static void loadVariantsFromFile(File file){
        Variants.reset();
        Variants.loadVariantsFromDisk(file);

        if(!file.isFile()){ return; }
        for(ConfigChangeObserver observer : observers){
            String path_to_variants = file.getAbsolutePath();
            observer.setVariantsPath(path_to_variants);
        }
    }
}
