package com.pawnyy.day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.pawnyy.common.*;

public class Answer {
    static int sum = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        part1();
        System.out.println(sum);
    }

    public static void part1() throws FileNotFoundException, IOException {
        Utils.forEachLine("src/main/java/com/pawnyy/day01/input.txt", Answer::part1PerLine);
    }

    public static Void part1PerLine(String line) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                nums.add(Character.getNumericValue(c));
            }
        }
        sum += ((nums.get(0)*10) + nums.get(nums.size() - 1));
        return null;
    }
}
