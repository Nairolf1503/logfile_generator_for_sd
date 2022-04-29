package de.opm.template.activities;

public class Activity {
    private String key;
    private String name;
    private String transaction;
    private String role;
    private String department;
    private ActivityType type = ActivityType.normal;

    /**
     * 
     * @param key unique identifier for each Activity
     * @param name Name used to describe activity
     * @param transaction ERP-Transaction code of the activity
     * @param role Role / Person executing this activity
     * @param department Department of Role executing this activity
     * @param type Type of activity, later used to generate extra information when Activity is turned into an event (Order Ammount etc.). normal will not generate extra information
     */
    protected Activity(String key, String name, String transaction, String role, String department, ActivityType type){
        this.key = key;
        this.name = name;
        this.transaction = transaction;
        this.role = role;
        this.department = department;
        this.type = type;
    }

    public String getKey(){ return key; }
    public String getName(){ return name; }
    public String getTransaction(){ return transaction; }
    public String getRole(){ return role; }
    public String getDepartment(){ return department; }
    public ActivityType getType(){ return type; }
}
