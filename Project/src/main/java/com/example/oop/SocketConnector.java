package com.example.oop;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketConnector {
    public static String talkToAdmin(String msg) throws IOException {
        Socket client = new Socket("localhost",1000);
        //To send data
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        //To recieve data
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println("Sending msg...");
        dos.writeBytes(msg);
        System.out.println("Awaiting response...");
        String response = br.readLine();
        System.out.println("Response recieved");
        return response;
    }
}
