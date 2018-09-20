package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    protected Date moodDate;

    public Mood() {
        this.moodDate = new Date();
    }

    public Mood(Date newDate) {
        this.moodDate = newDate;
    }

    public abstract void setDate(Date date);

    public abstract Date getDate();
}
