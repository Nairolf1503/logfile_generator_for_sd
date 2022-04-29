package de.opm.dataset.cases;

/**
 * Singleton which returns automatically incrementing CaseIDs
 */
public class CaseID {
    private static CaseID instance = null;
    protected static CaseID getInstance() {
        if(instance == null){
            instance = new CaseID();
        }
        return instance;
    }
    protected static void reset(){
        instance = new CaseID();
    }

    private int id = 1;

    protected int getID() {
        return id++;
    }
    
}
