package de.opm.template.activities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONObject;

import de.opm.template.input.Input;
/**
 * Data Class which stores key information about Activities, which function as templates for Events
 */
public class Activities {

    /**
     * 
     * @return Keys to Activities stored in Hashtable inside ActivityPool-class
     */
    public static String[] getActivityKeys(){
        String[] activity_keys = ActivityPool.getInstance().getActivityKeys();
        return activity_keys;
    }

    /**
     * 
     * @param key String correlating to Activity in ActivityPool
     * @return Activity correlating to key if there is one, null otherwise
     */
    public static Activity getActivityByKey(String key){
        Activity activity = ActivityPool.getInstance().getActivity(key);
        return activity;
    } 

    /**
     * Resets ActivityPool-Instance, clearing the Activity-Hashtable in the Process
     */
    public static void reset(){
        ActivityPool.reset();
    }

    /**
     * All activities which were read from the File are transfered into the ActivityPool
     * @param path_to_activities Path on System leading to JSON-File containting Activity-Data
     */
    public static void loadActivitiesFromFile(File file){
        JSONObject json = null;
        try {
            json = Input.getJSONFromFile(file);
            ActivityPool activities = ActivityPool.getInstance();

            Iterator<String> keys = json.keys();
            while(keys.hasNext()){
                String key = keys.next();
                JSONObject json_activity = json.getJSONObject(key);
                Activity activity = ActivityJSON.getActivityFromJSON(json_activity, key);
                activities.addActivity(activity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
}
