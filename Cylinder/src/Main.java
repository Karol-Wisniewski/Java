import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Please enter the number of the option you want to choose:");
        System.out.println("1. Get the volume of the cylinder");
        System.out.println("2. Get the surface area of the cylinder");
        System.out.println("3. Get the base surface area of the cylinder");
        System.out.println("4. Get the side surface area of the cylinder");
        System.out.println("5. Get the radius of the cylinder");
        System.out.println("6. Get the height of the cylinder");
        System.out.println("7. Change the radius of the cylinder");
        System.out.println("8. Change the height of the cylinder");
        System.out.println("9. Exit the program");
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Cylinder program!");
        System.out.println("This application lets you create a cylinder and get its volume and surface area (total, base and side).");
        System.out.println("You can also get the radius and height of the cylinder and change their values.");

        Cylinder cylinder = new Cylinder();

        Scanner scanner = new Scanner(System.in);

        printMenu();

        int option = scanner.nextInt();
        while (option != 9) {
            switch (option) {
                case 1 -> System.out.println("The volume of the cylinder is: " + cylinder.getVolume());
                case 2 -> System.out.println("The surface area of the cylinder is: " + cylinder.getSurfaceArea());
                case 3 ->
                        System.out.println("The base surface area of the cylinder is: " + cylinder.getBaseSurfaceArea());
                case 4 ->
                        System.out.println("The side surface area of the cylinder is: " + cylinder.getSideSurfaceArea());
                case 5 -> System.out.println("The radius of the cylinder is: " + cylinder.getRadius());
                case 6 -> System.out.println("The height of the cylinder is: " + cylinder.getHeight());
                case 7 -> {
                    System.out.println("Please enter the new radius of the cylinder:");
                    cylinder.setRadius(scanner.nextDouble());
                }
                case 8 -> {
                    System.out.println("Please enter the new height of the cylinder:");
                    cylinder.setHeight(scanner.nextDouble());
                }
                default -> System.out.println("Invalid option!");
            }
            printMenu();
            option = scanner.nextInt();
        }
    }
}