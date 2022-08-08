package point2D_and_point3D.MainController2;

import point2D_and_point3D.Model2.Point2D;
import point2D_and_point3D.Model2.Point3D;

public class MainController {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(0.5f, 0.6f);
        Point3D point3D = new Point3D(0.2f,0.3f,0.4f);

        System.out.println(point2D);
        System.out.println(point3D);
    }
}
