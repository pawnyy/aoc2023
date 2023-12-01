package com.pawnyy.day01;

import java.util.ArrayList;

import com.pawnyy.common.*;

public class Answer {
    int sum = 0;
    public static void main(String[] args) {
        part1();
    }

    public static void part1() {

    }

    public static void part1PerLine(String line) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                nums.add(Character.getNumericValue(c));
            }
        }
        sum += (nums.get(0) + nums.get(nums))
    }
}
