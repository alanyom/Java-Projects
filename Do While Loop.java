package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = "";
        while (!input.equals("quit")) {
            System.out.print("Input: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }

        do {
            System.out.print("Input: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.next().toLowerCase();
            System.out.println(input);
        } while (!input.equals("quit"));
    }
}
