package Factorial;
import java.util.Objects;
import java.util.Scanner;

public class Factorial {
    public static int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int twoToTheNth(int n) {
        int power = 1;
        for (int i = 1; i <= n; i++) {
            power *= 2;
        }
        return power;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        String askAgain = "y";
        while (!Objects.equals(askAgain, "n")) {
            System.out.println("Enter a number: ");
            int number = input.nextInt();
            System.out.println("Factorial of " + number + " is " + factorial(number));
            System.out.println("Do you wish to compute another factorial? (y/n)");
            askAgain = inputString.nextLine();
        }
    }
}