package de.opm.dataset.time;

import java.util.Random;

public class Timesequence {
    private static final long min_duration = 13 * 60000;
    private static final long max_duration = 17 * 60000;

    private long next_timestamp;
    private double time_factor;

    /**
     * 
     * @param first_timestamp millisecond-timestamp from which the following timestamps will start
     * @param time_factor shifts execution time to approximate normally distributes case_durations
     */
    public Timesequence(long first_timestamp, double time_factor){
        this.next_timestamp = first_timestamp;
        this.time_factor = time_factor;
    }

    /**
     * 
     * @return a number of milliseconds equal to about 15 minutes randomly equally distributed within this instance, 
     * but about normally distributed for multiple instances, since each instance multiplies this value with a 
     * normally distributed factor determined on creation
     */
    public long getNextTimestamp(){
        next_timestamp += getRandomDuration() * time_factor;
        return next_timestamp;
    }

    /**
     * 
     * @return a number of milliseconds equal to about 15 minutes randomly equally distributed
     */
    public long getRandomDuration(){
        return new Random().nextLong() % (max_duration - min_duration) + min_duration;
    }
}
