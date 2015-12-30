package com.app.aos.aos;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Arnold on 11/9/15.
 */
public class NewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<GroupItems> groupItems;


    public NewAdapter (Context context, ArrayList<GroupItems> groupItems){
        this.context = context;
        this.groupItems = groupItems;
    }

    @Override
    public Object getChild(int i, int i1) {
        ArrayList<ChildItems> chList = groupItems.get(i).getChildItems();
        return chList.get(i1);
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        ChildItems child = (ChildItems) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_item, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.child_item);
        //ImageView iv = (ImageView) convertView.findViewById(R.id.flag);

        tv.setText(child.getChild_option().toString());
       // iv.setImageResource(child.getImage());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<ChildItems> chList = groupItems.get(groupPosition).getChildItems();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupItems.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groupItems.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        GroupItems group = (GroupItems) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.group, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.main_menu_labels);
        tv.setText(group.getOption());
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_avatar);
        imageView.setImageResource(group.getOption_icon());
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}