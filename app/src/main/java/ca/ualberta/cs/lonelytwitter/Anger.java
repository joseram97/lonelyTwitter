package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Anger extends Mood {
    // This is an angry class
    public Anger() {
        // sets the default date for the Anger object
        super(new Date());
    }

    public Anger(Date newDate){
        // sets a specific date
        super(newDate);
    }

    public String getFeeling() {
        // returns the emotion of the string
        return "I am angry";
    }
}
