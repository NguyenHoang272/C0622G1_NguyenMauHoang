package access_modifier;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        System.out.print("Radius:"+ circle1.getRadius());
        System.out.print("Area:" +circle1.getArea());
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea());
    }
}
