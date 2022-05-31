package com.kiau;

import java.io.*;

public class FileOperation extends Thread {

    @Override
    public void run() {
        readFile();
    }

    public void readFile() {
        File file = new File("file.txt");
        try {
            Thread.sleep(30000);
            FileReader fileReader = new FileReader(file);
            int ascii = fileReader.read();
            String content = "";
            while(ascii != -1) {
                content += (char) ascii;
                ascii = fileReader.read();
            }
            fileReader.close();
            if(content.equals(""))
                System.out.println("file is empty");
            else
                System.out.println("file content is: " + content);
        } catch(IOException | InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
