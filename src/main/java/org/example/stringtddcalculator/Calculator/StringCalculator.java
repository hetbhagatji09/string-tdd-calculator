package org.example.stringtddcalculator.Calculator;

public class StringCalculator {
    public int add(String input) {
        if(input.equals("")){
            return 0;
        }
        if(input.contains(",")){
            String parts[] = input.split(",");
            int sum = 0;
            for(String part : parts){
                sum += Integer.parseInt(part);
            }
            return sum;
        }
        return Integer.parseInt(input);
    }
}
