package de.opm.template.activities;

import java.util.Hashtable;
/**
 * Singleton containing a Hashtable to store and look up all Activities for later use.
 */
public class ActivityPool {
    private static ActivityPool instance = null;
    protected static ActivityPool getInstance(){
        if(instance == null){
            instance = new ActivityPool();
        }
        return instance;
    }

    protected static void reset(){ instance = new ActivityPool(); }

    private ActivityPool(){}

    private Hashtable<String,Activity> activities_table = new Hashtable<String,Activity>();

    /**
     * 
     * @param activity activity to be added to ActivityPool. May Replace an existing Activity, if the keys are identical
     */
    protected void addActivity(Activity activity){
        String key = activity.getKey();
        activities_table.put(key, activity);
        System.out.println(key + " was added to the ActivityPool");
    }

    /**
     * 
     * @param key identifying key for activity to be retrieved
     * @return desired instance of Activity if there is one, null otherwise
     */
    protected Activity getActivity(String key){
        Activity activity = activities_table.get(key);
        if(activity == null){
            System.out.println(key + " was not found in the ActivityPool");
        }
        return activity;
    }

    /**
     * 
     * @return Array of String containing all keys to Activities currently in the Pool
     */
    protected String[] getActivityKeys(){
        int number_activities = activities_table.size();
        String[] keys = activities_table.keySet().toArray(new String[number_activities]);
        return keys;
    }
}
