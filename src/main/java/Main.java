import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Put your weight in kg");
        int weight = scanner.nextInt();
        System.out.println("Put your height in cm");
        int height = scanner.nextInt();

        BMIcalculator bmi = new BMIcalculator(weight, height);
        bmi.calculate();
        System.out.println(bmi.interpret());


    }
}
