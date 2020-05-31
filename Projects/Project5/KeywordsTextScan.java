//Program modifiedfrom original file, "TextScan.java"
//from CSci 1933 spring 2020 canvas page

import java.util.Scanner;
import java.io.*;

public class KeywordsTextScan {

    public static void main(String[] args){

        HashTableKeywords<String> hash1 =  new HashTableKeywords<String>(311);
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
            hash1.add(s);
        }
        hash1.display();


    }  // main

}  // TextScan
