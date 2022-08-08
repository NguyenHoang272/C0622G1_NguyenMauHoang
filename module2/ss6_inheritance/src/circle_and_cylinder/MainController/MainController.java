package circle_and_cylinder.MainController;

import circle_and_cylinder.Model.Circle;
import circle_and_cylinder.Model.Cylinder;

public class MainController {

    public static void main(String[] args) {
        Circle circle = new Circle(2.0,"black");
        Cylinder cylinder = new Cylinder(3.0,"blue",7.0);

        System.out.println("Diện tích:"+ circle.toString() );
        System.out.println("Thể tích:"+ cylinder.toString());
    }
}
