public class Box {
    private double length;
    private double width;
    private double height;
    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    };

    public Box() {};

    public void printDimensions() {
        System.out.print("Length: " + this.length + " Width: " + this.width + " Height: " + this.height);
    }

    public static void main(String[] args) {
        Box box = new Box(5.0, 10.0, 15.0);

        box.printDimensions();
    }
}
