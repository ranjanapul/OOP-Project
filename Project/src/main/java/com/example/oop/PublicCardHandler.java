package com.example.oop;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static com.example.oop.SocketConnector.talkToAdmin;

public class PublicCardHandler {
    public static boolean makeCardPublic(User user, Card card) throws IOException {
//        Socket client = new Socket("localhost",1000);
//        //To send data
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        //To recieve data
//        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        int type;
        if(card.cardType.equals("Fill in the blanks")){
            type = 2;
        }
        else if(card.cardType.equals("True/False")){
            type = 3;
        }
        else {
            type = 1;
        }
        String msg = "addCard/" +type + "/" + card.getQuestion() + "/" + card.getAnswer() + "/" + card.getDifficulty() + "/" + user.getName() + "\n";
        String res = talkToAdmin(msg);
        if(res.equals("ok")){
            return true;
        }
        else {
            return false;
        }
//        System.out.println("Sending request");
//        dos.writeBytes(msg);
//        System.out.println("Awaiting response");
//        String response = br.readLine();
//        System.out.println("Recieving ressponse");
//        br.close();
//        dos.close();
//        client.close();
//        if (response.equals("ok")){
//            return true;
//        }
//        else {
//            return false;
//        }

    }

    public static String getPublicCards() throws IOException {
//        Socket client = new Socket("localhost",1000);
//        //To send data
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        //To recieve data
//        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//
//
//        dos.writeBytes(msg);
//        String response = br.readLine();
//        br.close();
//        dos.close();
//        client.close();
        String msg = "getCards/\n";
        String res = talkToAdmin(msg);
        System.out.println(res);
        return res;

    }
    public static String getTopContributors() throws IOException {
        String msg = "getCont/\n";
        String res = talkToAdmin(msg);
        return res;
    }
}
