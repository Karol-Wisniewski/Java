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

        // Information about the program
        System.out.println("Welcome to the Cylinder program!");
        System.out.println("This application lets you create a cylinder and get its volume and surface area (total, base and side).");
        System.out.println("You can also get the radius and height of the cylinder and change their values.");
        System.out.println("----------------------------------------");

        // Get the radius and height from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the radius of the cylinder:");
        double radius = scanner.nextDouble();
        System.out.println("Please enter the height of the cylinder:");
        double height = scanner.nextDouble();

        // Create a new cylinder with the given radius and height
        Cylinder cylinder = new Cylinder(radius, height);

        //Create reference to the cylinder
        Cylinder cylinderReference = cylinder;

        // Give user options to operate with the cylinder
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
                    cylinderReference.setRadius(scanner.nextDouble());
                }
                case 8 -> {
                    System.out.println("Please enter the new height of the cylinder:");
                    cylinderReference.setHeight(scanner.nextDouble());
                }
                default -> System.out.println("Invalid option!");
            }
            printMenu();
            option = scanner.nextInt();
        }
    }
}