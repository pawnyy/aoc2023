package com.pawnyy.day03;

import java.util.ArrayList;
import java.io.IOException;

import com.pawnyy.common.*;

public class Answer {
    static int sum = 0;
    public static void main(String[] args) throws IOException{
        // part1();
        part2();
        System.out.println(sum);
    }

    public static Boolean isCharacterAdjacentToSymbol(String line, String lineBefore, String lineAfter, int index) {
        
        int lineLength = line.length();
        lineBefore += '.';
        lineAfter += '.';

        char[] charsAround = new char[8];
        try {
            charsAround[0] = index > 0 ? line.charAt(index-1) : '.';
            charsAround[1] = index < lineLength-1 ? line.charAt(index+1) : '.';

            charsAround[2] = index > 0 ? lineBefore.charAt(index-1) : '.';
            charsAround[3] = lineBefore.charAt(index);
            charsAround[4] = index < lineLength-1 ? lineBefore.charAt(index+1) : '.';

            charsAround[5] = index > 0 ? lineAfter.charAt(index-1) : '.';
            charsAround[6] = lineAfter.charAt(index);
            charsAround[7] = index < lineLength-1 ? lineAfter.charAt(index+1) : '.';
        } catch (Exception e) {
            System.out.println("index: " + index);
            System.out.println("lineLength: " + lineLength);
            System.out.println("line: " + line);
            System.out.println("lineBefore: " + lineBefore);
            System.out.println("lineAfter: " + lineAfter);
            System.out.println("LineBefore length: " + lineBefore.length());
            System.out.println("LineAfter length: " + lineAfter.length());
            throw e;
        }
        for (char c : charsAround) {
            if (!Character.isDigit(c) && c != '.') {
                return true;
            }
        }
        return false;
    }

    public static void part1() throws IOException {
        String input = Utils.readFileInput("src/main/java/com/pawnyy/day03/input.txt");
        String[] lines = input.split("\n");
        for (int i=0; i<lines.length; i++) {
            String line = lines[i];
            // System.out.println(i);
            line += '.';
            String lineBefore;
            if (i > 0) {
                lineBefore = lines[i-1];
            } else {
                lineBefore = ".".repeat(line.length());
            }
            String lineAfter;
            if (i < lines.length-1) {
                lineAfter = lines[i+1];
            } else {
                lineAfter = ".".repeat(line.length());
            }
            Boolean inNum = false;
            String curNum = "";
            for (int j=0; j<line.length(); j++) {
                char c = line.charAt(j);
                if (Character.isDigit(c)) {
                    curNum += c;
                    inNum = true;
                } else {
                    if (inNum) {
                        Boolean adj = false;
                        int length = curNum.length();
                        
                        for (int k=j-length; k<j; k++) {
                            if (isCharacterAdjacentToSymbol(line, lineBefore, lineAfter, k)) {
                                adj = true;
                                break;
                            }
                        }

                        if (adj) {
                            sum += Integer.parseInt(curNum);
                        }
                        
                    }
                    inNum = false;
                    curNum = "";
                }
            }

        }
    }
    
    public static void part2() throws IOException {
        String input = Utils.readFileInput("src/main/java/com/pawnyy/day03/input.txt");
    }
}
