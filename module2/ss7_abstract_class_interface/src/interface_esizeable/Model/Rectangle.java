package interface_esizeable.Model;

public class Rectangle extends Shape{
    private double width = 1.0;
    private double height = 1.0;

    public Rectangle() {
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter(){
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color:" + getColor() +
                ", filled:" + isFilled() +
                ", width:" + width +
                ", height:" + height +
                '}' ;
    }

    @Override
    public void resize(double percent) {
        setWidth(getWidth() + getWidth() * percent/100);
        setHeight(getHeight() + getHeight() * percent/100);
    }
}