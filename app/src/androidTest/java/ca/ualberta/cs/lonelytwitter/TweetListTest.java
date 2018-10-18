package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ListIterator;

/**
 * Created by: Jose on Oct 17, 2018
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        //assertTrue(Boolean.FALSE); //This will automatically make it fail
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDuplicateTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.addTweet(tweet);
        try {
            tweets.addTweet(tweet);
            assertTrue(Boolean.FALSE);
        }
        catch(Exception e){
            // we have caught the exception
            assertTrue(Boolean.TRUE);
        }
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
        tweets.deleteTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testGetCount() {
        // Tests the getCount function from and instance of tweet list
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        Tweet tweet2 = new ImportantTweet("Important Tweet");
        tweets.addTweet(tweet);
        assertEquals(tweets.getCount(), 1);
        tweets.addTweet(tweet2);
        assertEquals(tweets.getCount(), 2);

    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        Tweet tweet2 = new ImportantTweet("Important Tweet");
        tweets.addTweet(tweet);
        tweets.addTweet(tweet2);
        ListIterator<Tweet> itr = tweets.getTweets().listIterator();
        while (itr.hasNext()){

        }
        for (Tweet itr: tweets.getTweets().iterator()) {

        }
    }
}
