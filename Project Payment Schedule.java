package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte months = 12;
    final static byte percent = 100;

    public static void main(String[] args) {
        int principle = (int) readNumber("Principle: ", 1000, 1_000_000);
        float annualRate = (float) readNumber("Annual interest: ", 1, 30);
        byte year = (byte) readNumber("Period (years): ", 1, 30);
        double mortgage = calculateMortgage(principle, annualRate, year);

        String newline = System.lineSeparator();
        String formatMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("____________" + newline + "Monthly Payment: " + formatMortgage + newline + "Payment Schedule" +                 newline + "_____________");

        for (short month = 1; month <= year * months; month++) {
            double balance = calculateBalance(principle, annualRate, year, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
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

    public static double calculateBalance(
            int principle, float annualRate, byte year, short payment) {

        float monthlyRate = annualRate / percent / months;
        float monthlyPeriod = year * months;

        double balance = principle
                * (Math.pow(1 + monthlyRate, monthlyPeriod) - Math.pow(1 + monthlyRate, payment))
                / (Math.pow(1 + monthlyRate, monthlyPeriod) - 1);

        return balance;
    }

    public static double calculateMortgage(
            int principle, float annualRate, byte year) {

        float monthlyRate = annualRate / percent / months;
        short monthlyPeriod = (short)(year * months);

        double mortgage = principle
                * (monthlyRate * Math.pow(monthlyRate + 1, monthlyPeriod)
                / (Math.pow(monthlyRate + 1, monthlyPeriod) - 1));

        return mortgage;
    }
}
