package com.org.raymond.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    ListView list;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    //RelativeLayout main;
    RelativeLayout settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        System.out.println("ajkshajkshjkahsjashajkhsajshakshakhsakj");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        list = (ListView) findViewById(R.id.listView);
//        String[] values = new String[] {"Themes",
//                                        "Fonts",
//                                        "Font Color",
//                                        "Font Size",
//                                        "Background Color"
//
//        };
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, values);
//        list.setAdapter(adapter);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                int itemPosition = position;
//                String itemValue = (String) list.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(),"Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();
//            }
//        });

//        final TextView descriptionText = (TextView) findViewById(R.id.themeSetting);
//        final TextView showAll = (TextView) findViewById(R.id.themeSetting_all);
//        showAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showAll.setVisibility(View.INVISIBLE);
//                descriptionText.setMaxLines(Integer.MAX_VALUE);
//            }
//        });
       // main = (RelativeLayout) findViewById(R.id.main);
        settings = (RelativeLayout) findViewById(R.id.settings);
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                //int header = Integer.parseInt(listDataHeader.get(groupPosition));
                //int child = Integer.parseInt(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition) + ", " + groupPosition
                                + " : "
                                + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) + ", " + childPosition, Toast.LENGTH_SHORT).show();
                changeSetting(groupPosition,childPosition);
                return false;
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();}
        });
    }

    public void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Main Settings
        listDataHeader.add("Themes");
        listDataHeader.add("Fonts");
        listDataHeader.add("Font Color");
        listDataHeader.add("Font Size");
        listDataHeader.add("Background Color");

        // Settings Items

        List<String> themes = new ArrayList<String>();
        themes.add("Dark");
        themes.add("Light");
        themes.add("Neutral");

        List<String> fonts = new ArrayList<String>();
        fonts.add("Arial");
        fonts.add("Times New Roman");

        List<String> fontColor = new ArrayList<String>();
        fontColor.add("Blue");
        fontColor.add("White");

        List<String> fontSize = new ArrayList<String>();
        fontSize.add("8px");
        fontSize.add("10px");

        List<String> background = new ArrayList<String>();
        background.add("Grey");
        background.add("White");

        listDataChild.put(listDataHeader.get(0), themes);
        listDataChild.put(listDataHeader.get(1), fonts);
        listDataChild.put(listDataHeader.get(2), fontColor);
        listDataChild.put(listDataHeader.get(3), fontSize);
        listDataChild.put(listDataHeader.get(4), background);

    }

    public void changeSetting(int headerPos, int childPos)
    {

        switch(headerPos){
            case 0:
                changeTheme(childPos);
                break;
            case 1:
                changeFont(childPos);
                break;
            case 2:
                break;
        }
    }

    public void changeTheme(int childPos){
        switch(childPos){
            case 0:
                settings.setBackgroundColor(Color.rgb(10,10,10));
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                break;
            case 1:
                settings.setBackgroundColor(Color.WHITE);
                System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                break;
            case 2:
                settings.setBackgroundColor(Color.rgb(240,240,240));
                System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
                break;
        }
    }

    public void changeFont(int childPos){

    }

    public void changeFontColor(int childPos){

    }

    public void changeFontSize(int childPos){

    }

    public void changeBackground(int childPos){
        settings.setBackgroundColor(Color.rgb(10,10,10));

    }
}
