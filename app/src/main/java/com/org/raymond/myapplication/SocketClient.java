package com.org.raymond.myapplication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Raymond on 6/8/2016.
 */
public class SocketClient extends Thread{
    Socket s;

    SocketClient(Socket s2) {s = s2;}

    public void sendMessage(String message) {
        try {
            PrintStream strOut = new PrintStream(s.getOutputStream());
            strOut.println(message);
            strOut.flush();
        }
        catch(IOException e) {
            System.out.println("Message fail to send");
        }
    }

    public void run() {
        try {
            Scanner listener = new Scanner(s.getInputStream());
            String line = listener.nextLine();
            System.out.println(line);
            while(true) {
                line = listener.nextLine();
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("Failed to connect to Server");
        }
    }
}
