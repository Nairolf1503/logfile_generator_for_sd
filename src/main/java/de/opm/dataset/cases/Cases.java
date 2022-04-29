package de.opm.dataset.cases;

import java.util.Random;

import de.opm.dataset.events.Event;
import de.opm.dataset.events.Events;
import de.opm.template.activities.Activities;
import de.opm.template.activities.Activity;
import de.opm.template.variants.Variant;

public class Cases {

    /**
     * 
     * @param variant template for Case
     * @param begin_timestamp first timestamp of this new Case
     * @return 
     */
    public static Case getCase(Variant variant, long begin_timestamp) {
        double time_factor = getTimeFactor();
        Case case_ = new Case(variant, begin_timestamp, time_factor);

        String[] activitiy_keys = variant.getOrderOfExection();
        for(String activity_key : activitiy_keys){
            Activity activity = Activities.getActivityByKey(activity_key);
            if(activity == null){
                System.out.println(activity_key + " in variant " + variant.getKey() + " does not exist");
                continue;
            }
            Event event = Events.getEventFromTemplates(activity, case_);
            case_.addEvent(event);
        }
        
        return case_;
    }
    
    public static double getTimeFactor(){
        double val = 0.0;
        do{
            val = new Random().nextGaussian() * 0.2;
        }while(Math.abs(val) > 1);
        return val + 1;
    }
}
