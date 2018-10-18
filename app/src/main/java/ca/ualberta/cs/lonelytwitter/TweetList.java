package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jose on Oct 17, 2018
 */
public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) throws IllegalArgumentException{
        if (this.tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        else {
            this.tweets.add(tweet);
        }
    }

    public boolean hasTweet(Tweet tweet) {
        return this.tweets.contains(tweet);
    }

    public void deleteTweet(Tweet tweet) {
        this.tweets.remove(tweet);
    }

    public Tweet getTweet(int index) {
        return this.tweets.get(index);
    }

    public int getCount() {
        return this.tweets.size();
    }

    public List<Tweet> getTweets() {
        Collections.sort(this.tweets, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());
            }
        });

        return this.tweets;
    }
}
