package org.example.stringtddcalculator.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        if(input.equals("")){
            return 0;
        }
        String delimiter="[,\n]";
        String numbers=input;
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            String delimiterPart = input.substring(2, delimiterEndIndex);
            delimiter = Pattern.quote(delimiterPart);
            numbers = input.substring(delimiterEndIndex + 1);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (!part.isEmpty()) {
                int num = Integer.parseInt(part);
                if (num < 0) {
                    negatives.add(num);
                }
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " + negatives.toString().replaceAll("[\\[\\] ]", ""));
        }
        return  sum;
    }
}
