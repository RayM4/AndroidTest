package com.org.raymond.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button randButton = (Button) findViewById(R.id.button);
        final TextView textF = (TextView) findViewById(R.id.number);
        final EditText textBox = (EditText) findViewById(R.id.text1);

        final Button b1 = (Button) findViewById(R.id.button1);
        final Button b2 = (Button) findViewById(R.id.button2);
        final Button b3 = (Button) findViewById(R.id.button3);
        final ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);

        final Button b4 = (Button) findViewById(R.id.button4);
        //final RelativeLayout textContainer = (RelativeLayout) findViewById(R.id.textList);
        final LinearLayout textContainer = (LinearLayout) findViewById(R.id.textList);
        final ListView listContainer = (ListView) findViewById(R.id.list2);
        final ArrayList<String> listOfText = new ArrayList<String>();

        //adaptor for listView
        //final List<String> aList = new ArrayList<String>();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listOfText);
        listContainer.setAdapter(arrayAdapter);

        randButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println(Math.floor(Math.random()*10));
                textF.setText(String.valueOf(Math.floor(Math.random() * 100)));
                //textBox.setBackgroundColor(Color.WHITE);
                rotateColors(buttons);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Drawable tempColor = b1.getBackground();
                textBox.setBackground(tempColor);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Drawable tempColor = b2.getBackground();
                textBox.setBackground(tempColor);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Drawable tempColor = b3.getBackground();
                textBox.setBackground(tempColor);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //textBox.setText("Some Text");
                if (textBox.getText().length() > 0) {
                    listOfText.add(textBox.getText().toString());
                }
                textBox.setText("");

                for (String temp : listOfText) {
                    System.out.println(temp);
                }
//                System.out.println(listOfText.size());
//                System.out.println(textContainer.getChildCount());
//                System.out.println("-------");
                //genTextViews(listOfText, textContainer);
                //genTextViews(listOfText, listContainer);
                //arrayAdapter.add(listOfText.get(listOfText.size()-1));
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }

    public void rotateColors(ArrayList<Button> buttons) {
        Drawable firstColor = buttons.get(0).getBackground();
        for (int i = 0; i < buttons.size()-1; i++) {
            //System.out.println(i);
            buttons.get(i).setBackground(buttons.get(i+1).getBackground());
        }
        buttons.get(buttons.size()-1).setBackground(firstColor);
    }

    public void genTextViews(ArrayList<String> arr, LinearLayout container) {
        if (container.getChildCount() < arr.size()) {
            int index = container.getChildCount();
            TextView temp = new TextView(this);
            temp.setText(arr.get(index));
            //temp.setId(index);
            //RelativeLayout.LayoutParams para = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams para = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            temp.setLayoutParams(para);
            container.addView(temp);
        }
    }
    //Listview version
    public void genTextViews(ArrayList<String> arr, List<String> adapt) {
        if (adapt.size() < arr.size()) {
//            int index = adapt.size();
//            TextView temp = new TextView(this);
//            temp.setText(arr.get(index));
//            //temp.setId(index);
//            //RelativeLayout.LayoutParams para = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//            ListView.LayoutParams para = new ListView.LayoutParams(ListView.LayoutParams.WRAP_CONTENT, ListView.LayoutParams.WRAP_CONTENT);
//            temp.setLayoutParams(para);
        }
    }

    public String genId(String name, int id) {
        return name + "_" + id;
    }
}
