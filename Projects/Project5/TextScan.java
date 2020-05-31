//Program modified from original file, "TextScan.java"
//from CSci 1933 spring 2020 canvas page

import java.util.Scanner;
import java.io.*;

public class TextScan {

    public static void main(String[] args) {

        HashTable<String> hash2 =  new HashTable<String>(89);
        Scanner readFile = null;
        String s;

        System.out.println();
        System.out.println("Attempting to read from file: " + args[0]);
        try {
            readFile = new Scanner(new File(args[0]));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + args[0] + " not found");
            System.exit(1);
        }

        System.out.println("Connection to file: " + args[0] + " successful");
        System.out.println();
        while (readFile.hasNext()) {
            s = readFile.next();
            hash2.add(s);
        }
        hash2.display();

    }  // main

}  // TextScan
