package com.company;

public class Main {

    public static void main(String[] args) {
        boolean hasHighIncome = true;
        boolean hasGoodCredit = false;
        boolean hasCriminalRecord = true;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        System.out.println(isEligible);
    }
}
