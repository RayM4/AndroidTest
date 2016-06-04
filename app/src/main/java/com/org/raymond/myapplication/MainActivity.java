package com.org.raymond.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button randButton = (Button) findViewById(R.id.button);
        final Button enterButton = (Button) findViewById(R.id.enterbutton);
        final TextView textF = (TextView) findViewById(R.id.number);
        final TextView text1 = (TextView) findViewById(R.id.text1);

        final Button b1 = (Button) findViewById(R.id.button1);
        final Button b2 = (Button) findViewById(R.id.button2);
        final Button b3 = (Button) findViewById(R.id.button3);
        final ArrayList<Button> buttons = new ArrayList<Button>();
        final ArrayList<NameText> textStrings = new ArrayList<NameText>();

        final ListView myList = (ListView) findViewById(R.id.listView);
        ArrayAdapter<NameText> myAdapter = new ArrayAdapter<NameText>(this,android.R.layout.simple_list_item_1, textStrings);
        myList.setAdapter(myAdapter);

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);

        enterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String tempText = text1.getText().toString();
                //System.out.println(tempText);
                addText(textStrings,tempText);
            }
        });

        randButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println(Math.floor(Math.random()*10));
                textF.setText(String.valueOf(Math.floor(Math.random() * 100)));
                rotateColors(buttons);
            }
        });


    }


    public void rotateColors(ArrayList<Button> buttons) {
        Drawable firstColor = buttons.get(0).getBackground();
        for (int i = 0; i < buttons.size()-1; i++) {
            System.out.println(i);
            buttons.get(i).setBackground(buttons.get(i+1).getBackground());
        }
        buttons.get(buttons.size()-1).setBackground(firstColor);
    }
    public void addText(ArrayList<NameText> stringText,String enteredText) {
        stringText.add(new NameText(enteredText));
        System.out.println("hi");
    }
}
