package com.company;

public class Main {

    public static void main(String[] args) {
        int temp = 23;
        if (temp > 30) {
            System.out.println("Its a hot day");
            System.out.println("Drink plenty of water");
        } 
        else if (temp > 20 && temp <= 30)
            System.out.println("Its a beautiful day");
        else
            System.out.println("Its a cold day");
    }
}
