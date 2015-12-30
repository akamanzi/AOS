package com.app.aos.aos;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.brickred.socialauth.Photo;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;

import java.util.List;

/**
 * Created by Arnold on 12/1/15.
 */
public class TwitterPosting extends ActionBarActivity {

    SocialAuthAdapter adapter;
    Profile profileMap;
    List<Photo> photoList;

    //Declaring Widget Views
    EditText editText;
    Button share;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_posting);

        update = (Button)findViewById(R.id.update);
        share = (Button) findViewById(R.id.sharebutton);

        //Hiding the visibility of the update button
        update.setVisibility(View.GONE);

        //referencing the views in the xml
        TextView text = (TextView) findViewById(R.id.text);
        text.setText("Connect to the world by sharing your thoughts, choose any social network by " +
                "pressing Login Button and then post your thought by clicking on Post button");

        editText = (EditText) findViewById(R.id.edittext);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.focus_layout);
                    Log.d("Focus", "Focus Changed");
                }
            }
        });




        //adding the share button to the social adapter

        adapter = new SocialAuthAdapter(new ResponseListener());

        //adding providers
        adapter.addProvider(SocialAuthAdapter.Provider.TWITTER, R.drawable.twitter);

        //adding callbacks for the providers that require them

        adapter.addCallBack(SocialAuthAdapter.Provider.TWITTER, "http://www.aos.rw/about-us/");

        //enabling the providers

        adapter.enable(share);

        //initiate action bar

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#99cc00")));
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Social Media");

    }

    //initiating the response class

    public final class ResponseListener implements DialogListener {

        @Override
        public void onComplete(Bundle bundle) {

            Log.d("ShareButton", "Authentication Successful");

            // getting the name of the provider after the authentication

            final String providerName = bundle.getString(SocialAuthAdapter.PROVIDER);

            Log.d("ShareButton", "Provider Name = " + providerName);
            Toast.makeText(TwitterPosting.this, providerName + "Connected",Toast.LENGTH_LONG).show();
            update.setVisibility(View.VISIBLE);

            //Button update = (Button) findViewById(R.id.update);
            //postMessage();
            //share = (Button) findViewById(R.id.sharebutton);

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(editText.getText().toString().equalsIgnoreCase("")){
                        Toast.makeText(TwitterPosting.this,"No Message to Post",Toast.LENGTH_LONG).show();
                    }
                    adapter.updateStatus(editText.getText().toString(), new MessageListener(), false);
                }
            });


        }

        @Override
        public void onError(SocialAuthError socialAuthError) {
            Log.d("ShareButton","Authentication Error: " + socialAuthError.getMessage());
        }

        @Override
        public void onCancel() {
            Log.d("ShareButton", "Authentication Cancelled");
        }

        @Override
        public void onBack() {
            Log.d("ShareButton","Dialog Closed by Pressing Back Key");
        }
    }

    // to get the status of the message after authentication

    public final class MessageListener implements SocialAuthListener<Integer> {

        @Override
        public void onExecute(String provider, Integer t) {

            Integer status = t;
            if(status.intValue()==200 || status.intValue()== 201 || status.intValue()== 204) {


                Toast.makeText(TwitterPosting.this, "Message Posted on" + provider, Toast.LENGTH_LONG).show();
                editText.getText().clear();
            }

            else Toast.makeText(TwitterPosting.this, "Message Not Posted on" + provider, Toast.LENGTH_LONG).show();

        }

        @Override
        public void onError(SocialAuthError socialAuthError) {

        }
    }

    public void postMessage() {
        share = (Button) findViewById(R.id.sharebutton);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.updateStatus(editText.getText().toString(), new MessageListener(), false);
            }
        });
    }
}


