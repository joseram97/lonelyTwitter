package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happiness extends Mood {
    // Happiness is related to the super class "Mood"
    //set the constructors
    public Happiness(){
        // this is the default constructor
        super(new Date());
    }

    public Happiness(Date date){
        // this assigns a date to the mood
        super(date);
    }

    public String getFeeling() {
        return "I am Happy";
    }
}
