package ioTraining.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dsk16 on 10/11/2018.
 */
public class EchoServer {

    public  EchoServer(int port) throws IOException {
        startServer(port);
    }

    private void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket;
        //socket = serverSocket.accept();
        while (true){
            socket = serverSocket.accept();


//            InputStream inputStream = socket.getInputStream();
//
//            byte[] buffer = new byte[1024];
//            int count = inputStream.read(buffer);
//            String messageFromServer = new String(buffer, 0, count);
//            System.out.println(messageFromServer);
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = bf.readLine();
            System.out.println("I've got: "+line);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("echo: "+line+'\n');
            bw.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        EchoServer es = new EchoServer(3000);
    }
}
