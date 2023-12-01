package com.pawnyy.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.function.Function;
import java.io.IOException;

public class Utils {
    public static String readFileInput(String path) throws IOException {
        File file = new File(path);
        // Return the entire content of the file as a String
        BufferedReader br = new BufferedReader(new FileReader(file));
        String result = "";
        try {
            // Add every line to the variable result
            String line;
            while ((line = br.readLine()) != null) {
                result += line + "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        br.close();
        return result;
    }


    public static void forEachLine(String path, Function<String, Void> f) throws FileNotFoundException, IOException {
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                f.apply(line);
            }
        }
    }

    
}
