package com.app.aos.aos;

import java.util.ArrayList;

/**
 * Created by Arnold on 11/9/15.
 */
public class GroupItems {

    String Option;
    int Option_icon;
    ArrayList<ChildItems> childItems;

    public String getOption() {
        return Option;
    }

    public void setOption(String option) {
        Option = option;
    }

    public int getOption_icon() {
        return Option_icon;
    }

    public void setOption_icon(int option_icon) {
        Option_icon = option_icon;
    }

    public ArrayList<ChildItems> getChildItems() {
        return childItems;
    }

    public void setChildItems(ArrayList<ChildItems> childItems) {
        this.childItems = childItems;
    }
}
