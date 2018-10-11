package ioTraining.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by dsk16 on 10/11/2018.
 */
public class EchoClient {

    public EchoClient(String my, int portServerTo) throws IOException {
        startSessionWith(my,portServerTo);
    }

    private void startSessionWith(String my, int portServerTo) throws IOException {
       // Socket socket = new Socket(my,portServerTo);
        ArrayList<String> ls = new ArrayList<>();
        ls.add("My name is Bogdan"+'\n');
        ls.add("Ich heise Bogdan"+'\n');
        ls.add("Je ma bel Bogdan"+'\n');
        while (true) {

            for (String value : ls) {
                Socket socket = new Socket(my,portServerTo);


                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write(value);
               // BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
               // System.out.println(br.readLine());
                bw.flush();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(br.readLine());

            }
        }
    }

    public static void main(String[] args) throws IOException {
        EchoClient cl = new EchoClient("localhost",3000);
    }

}
