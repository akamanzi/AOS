package com.app.aos.aos;

import android.app.DownloadManager;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;


import java.util.ArrayList;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by Arnold on 11/28/15.
 */
public class TwitterPage extends ListActivity{

    ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new RunInBackground().execute();




        // WhatsOnCustomAdapter adapter = new WhatsOnCustomAdapter(this, R.layout.whats_on, loadTweets());
        //setListAdapter(adapter);
    }



    private class RunInBackground extends AsyncTask<Void,Void,Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(TwitterPage.this, "","Loading Tweets...",true);
        }

        @Override
        protected Void doInBackground(Void... params) {

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true);
            cb.setOAuthConsumerKey("h4HssaO4ui2Kp5Df21FyIcWSI");
            cb.setOAuthConsumerSecret("JHRUPM4vsV5eaRGczP8f1btCbJY8LFvRyhe85FsA8qAbnSLQ4h");
            cb.setOAuthAccessToken("2687054592-uDfUBwpnWRTBKC5wmN5RK9qvDAfVRxwo2isRK9t");
            cb.setOAuthAccessTokenSecret("v2786ALl6DkovoM21ZMDWQXzlzEFYP6W45WcEzXkG2pUp");
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            //DownloadManager.Query query = new DownloadManager.Query();
            Query query = new Query();
            query.setQuery("@AoS_rw");
            QueryResult queryResult;
            try {
                queryResult = twitter.search(query);
                for (twitter4j.Status status : queryResult.getTweets()){
                    i++;
                    String username = "@" + status.getUser().getScreenName();
                    String content =  status.getText();
                    System.out.println(username);
                    Tweet tweet = new Tweet();
                    tweet.content = content;
                    tweet.author = username;
                    tweets.add(tweet);

                }
            } catch (TwitterException e) {
                e.printStackTrace();
            }


            return null;

        }

        @Override
        protected void onPostExecute(Void result) {
            progressDialog.dismiss();
            TwitterCustomAdapter adapter = new TwitterCustomAdapter(TwitterPage.this, R.layout.twitter_custom_layout, tweets);
            setListAdapter(adapter);
        }
    }
}
