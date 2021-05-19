package com.lga.netty.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {


    public void start(int port) {
        try {
            final ServerSocket serverSocket = new ServerSocket(port);

            Socket socket;
            while ((socket =serverSocket.accept()) != null) {

                System.out.println("client connected.....");

                final ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                final ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                Message message =(Message)objectInputStream.readObject();
                System.out.println("receive message:"+message.getContent());

                message.setContent("1234567");
                objectOutputStream.writeObject(message);
                objectOutputStream.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        final HelloServer helloServer = new HelloServer();
        helloServer.start(9999);

    }
}
