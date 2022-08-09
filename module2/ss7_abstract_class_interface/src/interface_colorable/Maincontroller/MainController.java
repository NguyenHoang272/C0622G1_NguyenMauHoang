package interface_colorable.Maincontroller;

import interface_esizeable.Model.Circle;
import interface_esizeable.Model.Rectangle;
import interface_esizeable.Model.Shape;
import interface_esizeable.Model.Square;

class ColorableController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle("blue",true, 10.0,16.0);
        shapes[1] = new Square("yellow",false,6.0);
        shapes[2] = new Circle("red", true,8.0);

        for (Shape shape : shapes){
            System.out.printf("Diện tích: %.2f", shape.getArea());
            System.out.println();
            System.out.printf("Chu vi: %.2f", shape.getPerimeter());
            System.out.println();
            if (shape instanceof Shape){
                shape.howToColor();
                System.out.println("------------");
            }
        }
    }
}