package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;

/**
 * Created by romansky on 10/20/16.
 */
public class ElasticsearchTweetController {

    private static JestDroidClient client = null;

    public static class AddtweetTask extends AsyncTask<Tweet, Void, Void>{
        protected Void doInBackground(Tweet... params){
            setClient();
            Tweet tweet = params[0];
            Index index = new Index.Builder(tweet)
                    .index("jose-wednesday")
                    .type("tweet").build();
            try {
                DocumentResult result = client.execute(index);
                if(result.isSucceeded()){
                    tweet.setTweetID(result.getId());
                }
            }
            catch(IOException e) {

            }
            return null;
        }
    }

    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        @Override
        //String instead of void to implement search
        protected ArrayList<Tweet> doInBackground(String... params) {
            setClient();
            ArrayList<Tweet> tweets = new ArrayList<Tweet>();
            Search search = new Search.Builder(params[0])
                    .addIndex("jose-wednesday")
                    .addType("tweet")
                    .build();
            try {
                JestResult result = client.execute(search);

                if(result.isSucceeded()){
                    List<NormalTweet> tweetList;
                    tweetList = result.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(tweetList);
                }
            }
            catch(IOException e){

            }
            return tweets;
        }
    }

    public static class SearchTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        @Override
        //String instead of void to implement search
        protected ArrayList<Tweet> doInBackground(String... params) {
            setClient();
            ArrayList<Tweet> tweets = new ArrayList<Tweet>();
            // Taken from https://github.com/searchbox-io/Jest/tree/master/jest#searching-documents
            // under the 'Searching documents' section
            String query = "{\n" +
                    "            \"query\" : {\n" +
                    "                \"query_string\" : {\n" +
                    "                    \"default_field\" : \"message\",\n" +
                    "                    \"query\" : \"" + params[0] + "\"\n" +
                    "                }\n" +
                    "            }\n" +
                    "}";


            Search search = new Search.Builder(query)
                    .addIndex("jose-wednesday")
                    .addType("tweet")
                    .build();
            try {
                JestResult result = client.execute(search);

                if(result.isSucceeded()){
                    List<NormalTweet> tweetList;
                    tweetList = result.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(tweetList);
                }
            }
            catch(IOException e){

            }
            return tweets;
        }
    }

    public static void setClient() {
        if (client == null) {
            DroidClientConfig config = new DroidClientConfig
                    .Builder("http://cmput301.softwareprocess.es:8080/").build();
            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }

    // TODO we need a function which gets tweets from elastic search
/*    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<NormalTweet>> {
        @Override
        protected ArrayList<NormalTweet> doInBackground(String... search_parameters) {
            verifySettings();

            ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

                // TODO Build the query

            try {
               // TODO get the results of the query
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return tweets;
        }
    }*/




    public static void verifySettings() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}