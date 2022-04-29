package de.opm.template.variants;

import java.util.Random;

/**
 * Stores Activity-Key and properties regarding its role in a Variant
 */
public class VariantStep {
    private String activity_key;
    private int chance_of_occurence = 100;
    private int chance_of_repetition = 0;

    /**
     * 
     * @param activity_key Key which identifies an Activity
     * @param chance_of_occurrence chance of the activity happening
     * @param chance_of_repetition chance of the activity repeating
     */
    public VariantStep(String activity_key, int chance_of_occurrence, int chance_of_repetition){
        this.activity_key = activity_key;
        if(chance_of_occurrence < 0 | chance_of_occurrence > 100){
            System.out.println("Chance of Occurrence for " + activity_key + " is not between 1 and 100");
        }
        else{
            this.chance_of_occurence = chance_of_occurrence;
        }

        if(chance_of_repetition < 0 | chance_of_repetition > 100){
            System.out.println("Chance of Occurrence for " + activity_key + " is not between 1 and 100");
        }
        else{
            this.chance_of_repetition = chance_of_repetition;
        }

    }

    /**
     * 
     * @return whether this activity happens or not
     */
    public boolean doesHappen(){
        int random_number = new Random().nextInt(100);
        if(random_number < chance_of_occurence) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * 
     * @return whether this activity is repeated in a Case
     */
    public boolean happensAgain(){
        int random_number = new Random().nextInt(100);
        if(random_number < chance_of_repetition) {
            return true;
        }else{
            return false;
        }
    }

    public String getActivityKey(){
        return activity_key;
    }

}
