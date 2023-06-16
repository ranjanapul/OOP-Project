package com.example.oop;
import java.io.*;
import java.net.Socket;

import static com.example.oop.SocketConnector.talkToAdmin;

public class Register {
    String username;
    String password;
    static String userId = "0";

    Register(String username, String password){
        this.username = username;
        this.password = password;
        userId = Integer.toString((Integer.parseInt(userId) + 1));
        User user = new User(username, password);
        addUser(user);
    }
    void addUser(User user){


    }
    public static boolean addUser(String username, String password) throws IOException {
//        Socket client = new Socket("localhost",1000);
//        //To send data
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        //To recieve data
//        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//
//
//        dos.writeBytes(msg);
//        String response = br.readLine();
//        if(response.equals("ok")){
//            return true;
//        }
//
//        return false;
        String msg = "register/" + username + "/" + password +"\n";
        String res = talkToAdmin(msg);
        if(res.equals("ok")){
            return true;
        }
        return false;
    }
}
