package com.pawnyy.day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pawnyy.common.*;

public class Answer {
    static int sum = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // part1();
        part2();
        System.out.println(sum);
    }

    public static void part1() throws FileNotFoundException, IOException {
        Utils.forEachLine("src/main/java/com/pawnyy/day02/input.txt", Answer::part1PerLine);
    }

    public static Void part1PerLine(String line) {
        final Pattern pattern = Pattern.compile("Game (\\d+): (.+)");
        final Matcher matcher = pattern.matcher(line);
        matcher.find();
        int id = Integer.parseInt(matcher.group(1));
        String gameStr = matcher.group(2);

        int valid = 0;
        int games = 0;

        String[] perRoundArr = gameStr.split(";");
        games = perRoundArr.length;
        for (String round : perRoundArr) {
            HashMap<String, Integer> colorsHashMap = new HashMap<String, Integer>();
            String[] perDrawArr = round.split(",");
            
            for (String draw : perDrawArr) {
                draw = draw.trim();
                
                String[] colorCount = draw.split(" ");
                colorsHashMap.put(colorCount[1], Integer.parseInt(colorCount[0]));
                
            }
            int redLimit = 12;
            int greenLimit = 13;
            int blueLimit = 14;
            int redCount = colorsHashMap.getOrDefault("red", 0);
            int greenCount = colorsHashMap.getOrDefault("green", 0);
            int blueCount = colorsHashMap.getOrDefault("blue", 0);
            // System.out.println("Game " + id + " has " + redCount + " red, " + greenCount + " green, " + blueCount + " blue");
            if (redCount > redLimit || greenCount > greenLimit || blueCount > blueLimit) {
                System.out.println("Game " + id + " is invalid");
                // return null;
            } else {
                valid+=1;
            }
        }
        if (valid == games) {
            System.out.println("Game " + id + " is valid");
            sum+=id;
        }

        
        return null;
    }

    public static void part2() throws FileNotFoundException, IOException {
        Utils.forEachLine("src/main/java/com/pawnyy/day02/input.txt", Answer::part2PerLine);
    }

    public static Void part2PerLine(String line) {
        final Pattern pattern = Pattern.compile("Game (\\d+): (.+)");
        final Matcher matcher = pattern.matcher(line);
        matcher.find();
        int id = Integer.parseInt(matcher.group(1));
        String gameStr = matcher.group(2);

        int valid = 0;
        int games = 0;

        String[] perRoundArr = gameStr.split(";");
        games = perRoundArr.length;
        HashMap<String, Integer> colorsHashMap = new HashMap<String, Integer>();
            
        colorsHashMap.put("red", 0);
        colorsHashMap.put("green", 0);
        colorsHashMap.put("blue", 0);

        for (String round : perRoundArr) {
            String[] perDrawArr = round.split(",");
            
            for (String draw : perDrawArr) {
                draw = draw.trim();
                
                String[] colorCount = draw.split(" ");
                if (colorsHashMap.get(colorCount[1]) < Integer.parseInt(colorCount[0])) {
                    colorsHashMap.put(colorCount[1], Integer.parseInt(colorCount[0]));
                }
                
            }
            
            
        }
        int power = colorsHashMap.get("red") * colorsHashMap.get("green") * colorsHashMap.get("blue");
        System.out.println("" + id + " has power " + power);
        sum += power;
        return null;
    }
}
