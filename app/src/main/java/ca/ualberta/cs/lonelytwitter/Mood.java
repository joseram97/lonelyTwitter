package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    //
    private Date moodDate;

    public Mood(Date date){
        this.moodDate = date;
    }

    public void setDate(Date date) {
        this.moodDate = date;
    }

    public Date getDate(){
        return this.moodDate;
    }

    public abstract String getFeeling();
}
