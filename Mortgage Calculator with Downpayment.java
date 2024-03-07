package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Principle: ");
        double principle = input.nextDouble();
        
        System.out.print("Down Payment: ");
        double downPay = input.nextDouble();
        double downPer = (principle / 100) * downPay;

        System.out.print("Annual intrest: ");
        double annualRate = input.nextDouble();
        double annualIntrest = annualRate / 100;
        double monthlyRate = annualIntrest / 12;

        System.out.print("Period (years): ");
        int monthlyPeriod = input.nextInt() * 12;

        double top = monthlyRate * Math.pow((monthlyRate + 1), monthlyPeriod);

        double bottom = Math.pow((monthlyRate + 1), monthlyPeriod) - 1;

        double rate = top / bottom;
        double payment = principle * rate;


        System.out.println("Morgage: " + NumberFormat.getCurrencyInstance().format(payment));
        System.out.println("Downpayment: " + NumberFormat.getCurrencyInstance().format(downPer));
    }
}
