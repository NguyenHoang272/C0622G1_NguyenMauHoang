package point_and_moveablePoint.MainController3;

import point_and_moveablePoint.Model3.MoveablePoint;
import point_and_moveablePoint.Model3.Point;

public class MainController {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        System.out.println(point);
        MoveablePoint moveablePoint = new MoveablePoint(2, 3, 2.1f, 4.3f);
        moveablePoint.move();
        System.out.println(moveablePoint);

    }
}
