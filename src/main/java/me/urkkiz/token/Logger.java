package me.urkkiz.token;

import java.io.*;

public class Logger {
    public void log(String input) throws IOException {
        String path = "C:\\Users\\username\\Desktop\\log.txt";

        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write(input + "\n");
            fw.flush();
            fw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
