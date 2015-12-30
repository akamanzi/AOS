package com.app.aos.aos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Arnold on 11/28/15.
 */
public class TwitterCustomAdapter extends ArrayAdapter<Tweet> {

    ArrayList<Tweet> tweets;

    public TwitterCustomAdapter(Context context, int textviewIds, ArrayList<Tweet> items){
        super(context,textviewIds,items);
        this.tweets = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View v = convertView;
        if(v== null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.twitter_custom_layout,null);
        }

        Tweet o = tweets.get(position);
        TextView tweeted = (TextView) v.findViewById(R.id.content);
        TextView writer = (TextView) v.findViewById(R.id.author);
        tweeted.setText(o.content);
        writer.setText(o.author);
        return v;
    }

}
