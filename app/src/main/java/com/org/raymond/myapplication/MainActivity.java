package com.org.raymond.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textBox = (EditText) findViewById(R.id.edit_message);


        final Button b4 = (Button) findViewById(R.id.button4);
        final Button b5 = (Button) findViewById(R.id.button5);
        final Button regButton = (Button) findViewById(R.id.regButton);
        //final RelativeLayout textContainer = (RelativeLayout) findViewById(R.id.textList);

        final LinearLayout textContainer = (LinearLayout) findViewById(R.id.textList);
        final ListView listContainer = (ListView) findViewById(R.id.list2);
        final ArrayList<String> listOfText = new ArrayList<String>();

        //adaptor for listView
        //final List<String> aList = new ArrayList<String>();



        //setting up sockets
        //String serverIP = "192.168.1.12";

//        try {
//            Socket s = new Socket(serverIP, serverPort);
//            //System.out.println("Connected to Server");
//            Log.d("Server:","Connected to Server");
//        }
//        catch (IOException e) {
//            //System.out.println("Failed to connect to Server");
//            Log.d("Server:", "Failed to connect to Server");
//        }
//        SocketClient client = new SocketClient(s);
//        client.start();
//        client.sendMessage("some text lalalalalaa");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listOfText);
        listContainer.setAdapter(arrayAdapter);


        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textBox.getText().length() > 0) {
                    listOfText.add(textBox.getText().toString());
                }
                textBox.setText("");

                for (String temp : listOfText) {
                    System.out.println(temp);
                }
                //genTextViews(listOfText, textContainer);
                //arrayAdapter.add(listOfText.get(listOfText.size()-1));
                arrayAdapter.notifyDataSetChanged();

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessage();
            }
        });
        regButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoReg();
            }
        });

        // Creating the settings page

    }


    public void sendMessage() {
        Intent intent = new Intent(this, SettingsActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void gotoReg() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
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

    public String genId(String name, int id) {
        return name + "_" + id;
    }
}
