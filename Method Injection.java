
public class Main {

    public static void main(String[] args) {
       var calculator = new TaxCalculator2018(100_000);
       var report = new TaxReport();
       report.show(calculator);
       report.show(new TaxCalculator2019());
    }
}



public class TaxReport {

    private TaxCalculator calculator;

//    public TaxReport(TaxCalculator calculator) { //Constructor injection
//        this.calculator = calculator;
//    }

    public void show(TaxCalculator calculator) { //Method injection
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

//    public void setCalculator(TaxCalculator calculator) { //setter injection
//        this.calculator = calculator;
//    }
}




public class TaxCalculator2019 implements TaxCalculator{
    @Override
    public double calculateTax() {
        return 0;
    }
}



public class TaxCalculator2018 implements TaxCalculator {
    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
        return taxableIncome * 0.3;
    }
}



public interface TaxCalculator {
    double calculateTax();
}

