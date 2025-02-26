package com.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nScientific Calculator Menu:");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Logarithm (ln)");
            System.out.println("4. Power Function");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Result: " + Calculator.squareRoot(num1));
                    break;
//                case 2:
//                    System.out.print("Enter an integer: ");
//                    int num2 = scanner.nextInt();
//                    System.out.println("Result: " + Calculator.factorial(num2));
//                    break;
//                case 3:
//                    System.out.print("Enter number: ");
//                    double num3 = scanner.nextDouble();
//                    System.out.println("Result: " + Calculator.naturalLog(num3));
//                    break;
//                case 4:
//                    System.out.print("Enter base: ");
//                    double base = scanner.nextDouble();
//                    System.out.print("Enter exponent: ");
//                    double exponent = scanner.nextDouble();
//                    System.out.println("Result: " + Calculator.power(base, exponent));
//                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
