package de.opm.template.activities;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityJSON {
    /**
     * 
     * @param json JSONObject which contains data to a single activity
     * @param key unique identifier for activity for the activity, usually JSON-Key of passed Object
     * @return Activity-Instance read from JSON
     * @throws JSONException the JSONObject does not have information on keys required to build activity
     */
    protected static Activity getActivityFromJSON(JSONObject json, String key) throws JSONException{
        String name = json.getString("name");
        String transaction = json.getString("transaction");
        String role = json.getString("role");
        String department = json.getString("department");

        String type_str = json.optString("type");
        type_str = type_str.toLowerCase();
        ActivityType type = ActivityType.normal;
        try{
            type = ActivityType.valueOf(type_str);
        }catch(IllegalArgumentException e){
            type = ActivityType.normal;
        }

        Activity activity = new Activity(key, name, transaction, role, department, type);
        
        return activity;
    }
}
