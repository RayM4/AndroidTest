package com.org.raymond.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.org.raymond.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_register);
        final Button randButton = (Button) findViewById(R.id.button);
        final TextView textF = (TextView) findViewById(R.id.number);
        final EditText textBox = (EditText) findViewById(R.id.edit_message);

        final Button b1 = (Button) findViewById(R.id.button1);
        final Button b2 = (Button) findViewById(R.id.button2);
        final Button b3 = (Button) findViewById(R.id.button3);
        final ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);

        final Button b4 = (Button) findViewById(R.id.button4);
        final Button b5 = (Button) findViewById(R.id.button5);
        final Button regButton = (Button) findViewById(R.id.regButton);
        //final RelativeLayout textContainer = (RelativeLayout) findViewById(R.id.textList);
        final LinearLayout textContainer = (LinearLayout) findViewById(R.id.textList);
        final ListView listContainer = (ListView) findViewById(R.id.list2);
        final ArrayList<String> listOfText = new ArrayList<String>();

        //adaptor for listView
        //final List<String> aList = new ArrayList<String>();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listOfText);
        listContainer.setAdapter(arrayAdapter);

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
                //textBox.setText("Some Text");
                sendMessage();
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoRegister();
            }
        });


    }



    public void sendMessage() {
        Intent intent = new Intent(this, SettingsActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void gotoRegister() {
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }

    public void rotateColors(ArrayList<Button> buttons) {
        Drawable firstColor = buttons.get(0).getBackground();
        for (int i = 0; i < buttons.size() - 1; i++) {
            //System.out.println(i);
            buttons.get(i).setBackground(buttons.get(i + 1).getBackground());
        }
        buttons.get(buttons.size() - 1).setBackground(firstColor);
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
