package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet {
    // will hold each tweet
    private String message;
    private Date date;
    // have a list of emotions for each tweet
    private ArrayList<Mood> moods;

    public Tweet (String message) {
        this.message = message;
        this.date = new Date();
    }

    public Tweet (String message, Date date) {
        this.message = message;
        this.date = date;
    }
    public void setMessage(String message) throws TooLongTweetException{
        if (message.length() > 140) {
            throw new TooLongTweetException();
        }
        this.message = message;
    }

    public void addMood(Mood mood) {
        // add a mood to the list of moods for the tweet
        this.moods.add(mood);
    }

    public ArrayList<Mood> getMoods() {
        // returns a list of moods
        return this.moods;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getMessage(){
        return this.message;
    }

    public Date getDate() {
        return this.date;
    }

    public abstract boolean isImportant();

    public String toString() {
        return this.date.toString()+" | "+this.message;
    }
}
