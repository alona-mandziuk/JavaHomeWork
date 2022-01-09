package com.pb.mandziuk.hw14;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class SomeCleint {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader inputUser;
    private String addr;
    private int port;
    private String nickname;
    private Date time;
    private String dtime;
    private SimpleDateFormat dt1;

    public SomeCleint (String addr, int port){
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        }catch (IOException e) {
            System.out.println("Socket failed");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressNickname();
            new ReadMsg().start();
            new WriteMsg().start();
        }catch (IOException e) {}
    }
    private  void pressNickname (){
        System.out.println("Enter your nick: ");
        try {
            nickname = inputUser.readLine();
            out.write("Hello " + nickname + "\n");
            out.flush();
        }catch (IOException ignored){}
    }
   private class ReadMsg extends Thread{
        @Override
       public void run(){
            String str;
            try {
                while (true){
                    str = in.readLine();
                    if (str.equals("stop")){
                        break;
                    }
                    System.out.println(str);
                }
            }catch (IOException e){}
        }
   }

   public class WriteMsg extends Thread {
        @Override
       public void run(){
            while (true){
                String userWord;
                try {
                    time = new Date();
                    dt1 = new SimpleDateFormat("HH:mm:ss");
                    dtime = dt1.format(time);
                    userWord = inputUser.readLine();
                    if (userWord.equals("stop")){
                        out.write("stop"+"\n");
                        break;
                    }else {
                        out.write("(" + dtime + ")" + nickname + ": "+ userWord + "\n");
                    }
                    out.flush();
                }catch (IOException e){}
            }
        }
   }
}
public class Client {
    public static String ipAddr = "localhost";
    public static int port = 8080;

    public static void main (String[] args){
        new SomeCleint(ipAddr, port);
    }
}
