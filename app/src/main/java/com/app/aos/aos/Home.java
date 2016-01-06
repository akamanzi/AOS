package com.app.aos.aos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class Home extends Activity {

    private NewAdapter newAdapter;
    private ArrayList<GroupItems> groupItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar.setTitle("Africa Olleh Services");
        /*
        ExpandableListView expandableListView = getExpandableListView();
        expandableListView.setDividerHeight(2);
        expandableListView.setClickable(true);
        */

        //setGroupData();
        //setChildData();

        ExpandList = (ExpandableListView) findViewById(R.id.expandable_listview);
        ExpandList.setIndicatorBounds(0,0);
        groupItems = setGroupItems();
        newAdapter = new NewAdapter(Home.this,groupItems);
        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
               switch (i) {
                    case 0:

                        break;


                    case 2:

                        switch (i1) {
                            case 0:
                                Intent it_services = new Intent(Home.this, Redirection.class);
                                it_services.putExtra("url", "http://www.aos.rw/siit-services/");
                                startActivity(it_services);
                                break;
                            case 1:
                                Intent cloud_services = new Intent(Home.this, Redirection.class);
                                cloud_services.putExtra("url", "http://www.aos.rw/cloudidc-services/");
                                startActivity(cloud_services);
                                break;
                            case 2:
                                Intent new_biz_lines = new Intent(Home.this, Redirection.class);
                                new_biz_lines.putExtra("url", "http://www.aos.rw/new-biz-lines/");
                                startActivity(new_biz_lines);
                                break;
                        }
                        break;

                    case 3:

                        switch (i1) {
                            case 0:
                                Intent security = new Intent(Home.this, Redirection.class);
                                security.putExtra("url", "http://www.aos.rw/security/");
                                startActivity(security);
                                break;
                            case 1:
                                Intent energy = new Intent(Home.this, Redirection.class);
                                energy.putExtra("url", "http://www.aos.rw/energy/");
                                startActivity(energy);
                                break;
                            case 2:
                                Intent hospital_it = new Intent(Home.this, Redirection.class);
                                hospital_it.putExtra("url", "http://www.aos.rw/hospital-it/");
                                startActivity(hospital_it);
                                break;
                            case 3:
                                Intent education = new Intent(Home.this, Redirection.class);
                                education.putExtra("url", "http://www.aos.rw/education/");
                                startActivity(education);
                                break;
                            case 4:
                                Intent saas = new Intent(Home.this, Redirection.class);
                                saas.putExtra("url", "http://www.aos.rw/saas/");
                                startActivity(saas);
                                break;
                            case 5:
                                Intent groupware = new Intent(Home.this, Redirection.class);
                                groupware.putExtra("url", "http://www.aos.rw/groupware/");
                                startActivity(groupware);
                                break;

                        }
                        break;

                    case 1:

                        switch (i1) {

                            case 5:
                                Intent career = new Intent(Home.this, Redirection.class);
                                career.putExtra("url", "http://www.aos.rw/career/");
                                startActivity(career);
                                break;
                            case 4:
                                Intent kt_news = new Intent(Home.this, Redirection.class);
                                kt_news.putExtra("url", "http://www.aos.rw/kt-news/");
                                startActivity(kt_news);
                                break;

                            case 0:
                                Intent company_overview = new Intent(Home.this, Redirection.class);
                                company_overview.putExtra("url", "http://www.aos.rw/company-overview/");
                                startActivity(company_overview);
                                break;

                            case 1:
                                Intent vision_culture = new Intent(Home.this, Redirection.class);
                                vision_culture.putExtra("url", "http://www.aos.rw/vision-culture/");
                                startActivity(vision_culture);
                                break;

                            case 2:
                                Intent ceo_message = new Intent(Home.this, Redirection.class);
                                ceo_message.putExtra("url", "http://www.aos.rw/ceos-message/");
                                startActivity(ceo_message);
                                break;

                            case 3:
                                Intent news_latest = new Intent(Home.this, Redirection.class);
                                news_latest.putExtra("url", "http://www.aos.rw/latest-news/");
                                startActivity(news_latest);
                                break;


                        }
                        break;

                    case 4:
                        switch (i1){

                            case 0:
                                Intent twitter_posting = new Intent(Home.this, TwitterPosting.class);
                                startActivity(twitter_posting);
                                break;

                            case 1:
                                Intent twitter = new Intent(Home.this, TwitterPage.class);
                                startActivity(twitter);
                                break;
                        }
                        break;



            }

            return false;
        }

    });
        ExpandList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                switch (i){
                    case 0:
                        Intent vision_culture = new Intent(Home.this, Redirection.class);
                        vision_culture.putExtra("url", "http://www.aos.rw");
                        startActivity(vision_culture);
                        break;

                    case 5:
                        Intent contact_us = new Intent(Home.this, Redirection.class);
                        contact_us.putExtra("url", "http://www.aos.rw/contact-us-2/");
                        startActivity(contact_us);
                        break;

                }
                return false;
            }
        });

        ExpandList.setAdapter(newAdapter);
        Log.d("adapter","Adapter Added");
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.AOS);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    public ArrayList<GroupItems> setGroupItems(){

        String group_options_names[] = {
                "Home","About Us","Services","Solutions","Social Media",
                "Contact US"
        };
        String child_items[] = {
                "vision and culture","CEO's Message","-","-","-","-","SI/IT services","Cloud/IDC services","New Biz Lines",
                "-","-","-","Security","Energy","Hospital IT",
                "Education","Saas","Group Ware","Latest News","kT News","-","-","-","-","Twitter","Aos#","-",
                "-","-","-","Map","Contact Box","-","-","-","-","-","-","-","-","-","-"
        };

        int group_options_avatar[] =
                {
                        R.drawable.profile48,R.drawable.services48, R.drawable.solution48,
                        R.drawable.news48, R.drawable.social48,
                        R.drawable.msg48
                };

        ArrayList<GroupItems> list = new ArrayList<GroupItems>();
        //ArrayList<ChildItems> childItems;
        /*
        int size =6;
        int imgsize = 1;
        int j = 0;
        int i = 0;

                    for (String group_name : group_options_names) {
                        GroupItems gru = new GroupItems();
                        gru.setOption(group_name);
                        int sizeOfArray = group_options_avatar.length;
                        String sizeInString = String.valueOf(sizeOfArray);
                        Log.d("Check", sizeInString);
                        for(;i<imgsize;i++) {
                            gru.setOption_icon(group_options_avatar[i]);
                            Log.d("Check", "Debugging Error of Index");

                        }

                        //group_options_avatar[i];


                        childItems = new ArrayList<ChildItems>();
                        for (; j < size; j++) {
                            ChildItems ch = new ChildItems();
                            ch.setChild_option(child_items[j]);
                            Log.d("Check", "Debugging second Array");
                            //ch.setImage(Images[j]);
                            childItems.add(ch);
                        }
                        gru.setChildItems(childItems);
                        groupItems.add(gru);

                        size = size + 6;
                        imgsize = imgsize +1;
                    }
                    */

        for (int i=1;i<7;i++){
            Log.d("Listing","Listing the items");

            GroupItems items = new GroupItems();
            if (i == 1){
                items.setOption(group_options_names[0]);
                items.setOption_icon(group_options_avatar[0]);

                items.setChildItems(new ArrayList<ChildItems>());
                /*
                //create child class object
                final ChildItems child = new ChildItems();
                child.setChild_option("");

                //adding this child class to parent
                items.getChildItems().add(child);
                */
            }

            else if (i == 3){
                items.setOption(group_options_names[2]);
                items.setOption_icon(group_options_avatar[1]);
                items.setChildItems(new ArrayList<ChildItems>());

                //creating child object
                final ChildItems child = new ChildItems();
                child.setChild_option("SI/IT Services");
                //adding the child to the parent
                items.getChildItems().add(child);

                final ChildItems child1 = new ChildItems();
                child1.setChild_option("Cloud/IDC Services");
                //adding the child to parent
                items.getChildItems().add(child1);

                final ChildItems child2 = new ChildItems();
                child2.setChild_option("New Biz Lines");
                //adding the child to parent
                items.getChildItems().add(child2);


            }

            else if (i==4){
                items.setOption(group_options_names[3]);
                items.setOption_icon(group_options_avatar[2]);
                items.setChildItems(new ArrayList<ChildItems>());

                //creating children for solutions
                final ChildItems child1 = new ChildItems();
                child1.setChild_option("Security");
                //adding child to parent
                items.getChildItems().add(child1);

                final ChildItems child2 = new ChildItems();
                child2.setChild_option("Energy");
                //adding child to parent
                items.getChildItems().add(child2);

                final ChildItems child3 = new ChildItems();
                child3.setChild_option("Hospital IT");
                //adding child to parent
                items.getChildItems().add(child3);

                final ChildItems child4 = new ChildItems();
                child4.setChild_option("Education");
                //adding child to parent
                items.getChildItems().add(child4);

                final ChildItems child5 = new ChildItems();
                child5.setChild_option("Saas");
                //adding child to parent
                items.getChildItems().add(child5);

                final ChildItems child6 = new ChildItems();
                child6.setChild_option("Group Ware");
                //adding child to parent
                items.getChildItems().add(child6);
            }

            else if (i==2){
                items.setOption(group_options_names[1]);
                items.setOption_icon(group_options_avatar[3]);
                items.setChildItems(new ArrayList<ChildItems>());

                final ChildItems child1 = new ChildItems();
                child1.setChild_option("Company Overview");
                //adding child to parent
                items.getChildItems().add(child1);

                final ChildItems child2 = new ChildItems();
                child2.setChild_option("Vision & Culture");
                //adding child to parent
                items.getChildItems().add(child2);

                final ChildItems child3 = new ChildItems();
                child3.setChild_option("CEO's Message");
                //adding child to parent
                items.getChildItems().add(child3);

                final ChildItems child4 = new ChildItems();
                child4.setChild_option("Latest News");
                //adding child to parent
                items.getChildItems().add(child4);

                final ChildItems child5 = new ChildItems();
                child5.setChild_option("KT News");
                //adding child to parent
                items.getChildItems().add(child5);

                final ChildItems child6 = new ChildItems();
                child6.setChild_option("Careers");
                //adding child to parent
                items.getChildItems().add(child6);



            }

            else if (i ==5){
                items.setOption(group_options_names[4]);
                items.setOption_icon(group_options_avatar[4]);
                items.setChildItems(new ArrayList<ChildItems>());

                final ChildItems child1 = new ChildItems();
                child1.setChild_option("Twitter");
                //adding child to parent
                items.getChildItems().add(child1);

                final ChildItems child2 = new ChildItems();
                child2.setChild_option("#AoS");
                //adding child to parent
                items.getChildItems().add(child2);

            }

            else if (i == 6){
                items.setOption(group_options_names[5]);
                items.setOption_icon(group_options_avatar[5]);
                items.setChildItems(new ArrayList<ChildItems>());

                /*
                final ChildItems child1 = new ChildItems();
                child1.setChild_option("#AoS");
                //adding child to parent
                items.getChildItems().add(child1);
                */

            }


            list.add(items);
        }

        Log.d("adding Lis","Complete Population");
         return list;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
