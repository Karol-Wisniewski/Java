import java.util.Scanner;

public class Main {
    private static void printMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add grade");
        System.out.println("2. Get average");
        System.out.println("3. Get lowest");
        System.out.println("4. Get highest");
        System.out.println("5. Exit");
    }

    private static void checkResult(double value) {
        if (value == 0) {
            System.out.println("Grade list is empty!");
        } else {
            System.out.println("Result: " + value);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to grades program!");
        System.out.println("It allows you to add grades to a list, get the average, lowest and highest grade.");
        GradesList gradesList = new GradesList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Please enter the grade:");
                    double grade = scanner.nextDouble();
                    gradesList.addGrade(grade);
                }
                case 2 -> checkResult(gradesList.getAverage());
                case 3 -> checkResult(gradesList.getLowest());
                case 4 -> checkResult(gradesList.getHighest());
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}