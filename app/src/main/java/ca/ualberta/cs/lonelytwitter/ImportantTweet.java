package ca.ualberta.cs.lonelytwitter;

public class ImportantTweet extends Tweet {

    public ImportantTweet(String message) throws TooLongTweetException{
        super(message);
    }

    public boolean isImportant() {
        return true;
    }
}
