public class Main {
    public static void main(String[] args) {
        int principle = (int) Scan.readNumber("Principle: ", 1000, 1_000_000);
        float annualRate = (float) Scan.readNumber("Annual interest: ", 1, 30);
        byte year = (byte) Scan.readNumber("Period (years): ", 1, 30);

        var calculator = new Console(principle, annualRate, year);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}

public class MortgageReport {

    private final NumberFormat currencyInstance;
    private Console calculator;

    public MortgageReport(Console calculator) {
        this.calculator = calculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currencyInstance.format(balance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String newline = System.lineSeparator();
        String formatMortgage = currencyInstance.format(mortgage);
        System.out.println("____________" + newline + "Monthly Payment: " + formatMortgage + newline + "Payment Schedule" +                 newline + "_____________");
    }
}

public class Console {
    private final static byte months = 12;
    private final static byte percent = 100;


    private byte year;
    private int principle;
    private float annualRate;

    public Console(int principle, float annualRate, byte year) {
        this.principle = principle;
        this.annualRate = annualRate;
        this.year = year;
    }

    public double calculateBalance(short payment) {

        float monthlyRate = getMonthlyRate();
        float monthlyPeriod = getMonthlyPeriod();

        double balance = principle
                * (Math.pow(1 + monthlyRate, monthlyPeriod) - Math.pow(1 + monthlyRate, payment))
                / (Math.pow(1 + monthlyRate, monthlyPeriod) - 1);

        return balance;
    }

    public double calculateMortgage() {

        float monthlyRate = getMonthlyRate();
        short monthlyPeriod = (short)(getMonthlyPeriod());

        double mortgage = principle
                * (monthlyRate * Math.pow(monthlyRate + 1, monthlyPeriod)
                / (Math.pow(monthlyRate + 1, monthlyPeriod) - 1));

        return mortgage;
    }

    public double[] getRemainingBalances() {
        var balances = new double[(int) getMonthlyRate()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    private float getMonthlyRate() {
        return annualRate / percent / months;
    }

    private int getMonthlyPeriod() {
        return year * months;
    }
}

import java.util.Scanner;

public class Scan {
    static double readNumber(String prompt, double min, double max) {
        Scanner input = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = input.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + "and" + max);
        }
        return value;
    }
}
