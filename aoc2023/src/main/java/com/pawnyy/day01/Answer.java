package com.pawnyy.day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.pawnyy.common.*;

public class Answer implements AnswerInterface {
    static int sum = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        part2();
        System.out.println(sum);
    }

    public static void part1() throws FileNotFoundException, IOException {
        Utils.forEachLine("src/main/java/com/pawnyy/day01/input.txt", Answer::part1PerLine);
    }

    public static void part2() throws FileNotFoundException, IOException {
        Utils.forEachLine("src/main/java/com/pawnyy/day01/input.txt", Answer::part2PerLine);
    }

    public static Void part1PerLine(String line) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                nums.add(Character.getNumericValue(c));
            }
        }
        int num = ((nums.get(0)*10) + nums.get(nums.size() - 1));
        
        sum += num;
        System.out.println(num);
        return null;
    }

    public static Void part2PerLine(String line) {

        HashMap<String, Integer> key = new HashMap<String, Integer>();
        key.put("one", 1);
        key.put("two", 2);
        key.put("three", 3);
        key.put("four", 4);
        key.put("five", 5);
        key.put("six", 6);
        key.put("seven", 7);
        key.put("eight", 8);
        key.put("nine", 9);

        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < line.length(); i++) {
            String substr = line.substring(i, line.length());
            for (String k : key.keySet()) {
                if (substr.startsWith(k)) {
                    nums.add(key.get(k));
                }

                char c = substr.charAt(0);
                if (Character.isDigit(c)) {
                    nums.add(Character.getNumericValue(c));
                }
            }
        }

        System.out.println(line);
        sum += (nums.get(0) * 10) + nums.get(nums.size() - 1);

        return null;
    }
}
