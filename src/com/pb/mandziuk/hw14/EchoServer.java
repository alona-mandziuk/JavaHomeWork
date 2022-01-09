
package com.pb.mandziuk.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

class Server extends Thread {


    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public Server(Socket socket) throws IOException {
        this.socket = socket;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.story.printStory(out);
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            word = in.readLine();
            try {
                out.write(word + "\n");
                out.flush();
            } catch (IOException ignored) {
            }
            try {
                while (true) {
                    word = in.readLine();
                    if (word.equals("stop")) {
                       this.downService();
                        break;
                    }
                    System.out.println("Echoing: " + word);
                    Server.story.addStoryE1(word);
                    for (Server vr : Server.serverList) {
                        vr.send(word);
                    }
                }
            } catch (NullPointerException ignored) {
            }
        } catch (IOException e) {
            this.downService();
        }
    }

    public void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }

    public void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (Server vr : Server.serverList)
                    if (vr.equals(this)) vr.interrupt();
                Server.serverList.remove(this);
            }
        } catch (IOException ignored) {
        }
    }



    public class Story {
        public LinkedList<String> story = new LinkedList<>();
        public void addStoryE1(String e1){
            if (story.size()>=10){
                story.removeFirst();
                story.add(e1);
            }else {
                story.add(e1);
            }
        }
        public void printStory(BufferedWriter writer){
            if (story.size() > 0){
                try {
                    writer.write("History messages " + "\n");
                    for (String vr : story){
                        writer.write(vr + "\n");
                    }
                    writer.write("/...." + "\n");
                    writer.flush();
                }catch (IOException ignored){}
            }
        }
    }
}

public class EchoServer{
    public static final int PORT = 8080;

    public static LinkedList<Server> serverList = new LinkedList<>();

    public static void main (String[] args) throws IOException{
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is started");
        try{
            while (true){
                Socket socket = server.accept();
                try {
                    serverList.add(new Server(socket));
                }catch (IOException e){
                    socket.close();
                }
            }
        }finally {
            server.close();
        }
    }
}
