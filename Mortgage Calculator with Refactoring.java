package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principle = (int) readNumber("Principle: ", 1000, 1_000_000);
        float annualRate = (float) readNumber("Annual interest: ", 1, 30);
        byte year = (byte) readNumber("Period (years): ", 1, 30);

        double mortgage = calculateMortgage(principle, annualRate, year);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }


    public static double readNumber(String prompt, double min, double max) {
        Scanner input = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = input.nextFloat();
            if (value >= min && value  <= max)
                break;
            System.out.println("Enter a value between " + min + "and" + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principle, float annualRate, byte year) {

        final byte months = 12;
        final byte percent = 100;

        float monthlyRate = annualRate / percent / months;
        short monthlyPeriod = (short)(year * months);

        double mortgage = principle * (monthlyRate * Math.pow(monthlyRate + 1, monthlyPeriod) / (Math.pow(monthlyRate + 1, monthlyPeriod) - 1));

        return mortgage;
    }
}
