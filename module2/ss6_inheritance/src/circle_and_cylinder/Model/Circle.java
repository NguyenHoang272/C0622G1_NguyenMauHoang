package circle_and_cylinder.Model;

public class Circle {
    private  double radius;
    private  String color;

    public Circle(){
        this.color = "red";
        this.radius = 1.0;

    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;

    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double areaCircle(){
        return Math.PI *(this.radius*this.radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                "Diện tích="+ areaCircle()+"}";
    }
}
