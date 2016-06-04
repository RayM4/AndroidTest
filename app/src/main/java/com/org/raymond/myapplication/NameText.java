package com.org.raymond.myapplication;

import java.util.jar.Attributes;

/**
 * Created by Alyssa on 6/4/2016.
 */
public class NameText {
    private String tempString;

    public NameText(String name){
        tempString = name;
    }
    @Override
    public String toString() {
        return tempString;
    }
}
