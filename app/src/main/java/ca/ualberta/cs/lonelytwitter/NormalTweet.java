package ca.ualberta.cs.lonelytwitter;

public class NormalTweet extends Tweet {
    public NormalTweet(String message) throws TooLongTweetException {
        super(message);
    }

    public boolean isImportant() {
        return false;
    }
}
