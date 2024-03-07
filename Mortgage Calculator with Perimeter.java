package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int principle = 0;
        while (true) {
            System.out.print("Principle ($1K - $1M): ");
            principle = input.nextInt();
            if (principle >= 1000 && principle <= 1000000)
                break;
            else
                System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        double annualRate = 0;
        while (true) {
            System.out.print("Annual intrest: ");
            annualRate = input.nextDouble();
            if (annualRate >= 1 && annualRate <= 30)
                break;
            else
                System.out.println("Enter a value greater than 0, and less than or equal to 30");
        }

        int yearlyPeriod = 0;
        while (true) {
            System.out.print("Period (years): ");
            yearlyPeriod = input.nextInt();
            if (yearlyPeriod >= 1 && yearlyPeriod <= 30)
                break;
            else
                System.out.println("Enter a value between 1 and 30");
        }

        double annualIntrest = annualRate / 100;
        double monthlyRate = annualIntrest / 12;
        int monthlyPeriod = yearlyPeriod * 12;
        double top = monthlyRate * Math.pow((monthlyRate + 1), monthlyPeriod);
        double bottom = Math.pow((monthlyRate + 1), monthlyPeriod) - 1;
        double rate = top / bottom;
        double payment = principle * rate;


        System.out.println("Morgage: " + NumberFormat.getCurrencyInstance().format(payment));
    }
}
