package com.org.raymond.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

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
                textBox.setText("Some Text");
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
}
