package com.develogical;


import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        if (query.toLowerCase().contains("name")) {
            return "Sarah D";
        }
        if (query.toLowerCase().contains("number")) {
            String numbers = query.substring(query.lastIndexOf(":") + 1);
            int[] numbersAsInt = parseLineToIntArray(numbers);
            int max = Arrays.stream(numbersAsInt).max().getAsInt();
            return String.valueOf(max).trim();
        }
        if (query.toLowerCase().contains("plus")) {
            String firstNumber = query.substring(query.lastIndexOf("plus") + 1).replaceAll("[^\\d.]", "");;
            String lastNumber = query.split("plus")[0].replaceAll("[^\\d.]", "");
            return String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(lastNumber));
        }
        return "";
    }

    private int[] toIntArray(String[] arr) {
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = Integer.parseInt(arr[i].trim());
        }
        return ints;
    }

    private int[] parseLineToIntArray(String line) {
        return toIntArray(line.split(","));
    }
}
