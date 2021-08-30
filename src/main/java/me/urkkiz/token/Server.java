package me.urkkiz.token;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args)  {
        Logger logger = new Logger();
        Thread th = new Thread(() -> {
            while (true) {
                try {
                    ServerSocket srv = new ServerSocket(8080);
                    Socket cli = srv.accept();
                    DataOutputStream out = new DataOutputStream(cli.getOutputStream());
                    out.writeUTF("hallo");
                    System.out.println("Connection received : " + cli.getInetAddress());
                    logger.log(cli.getInetAddress().toString() + "\n----------------------------------------------");
                    DataInputStream in = new DataInputStream(cli.getInputStream());
                    while (in.available() != -1) {
                        logger.log(in.readUTF());
                    }
                } catch (IOException ignored) {}
            }
        });
        th.start();
    }
}
