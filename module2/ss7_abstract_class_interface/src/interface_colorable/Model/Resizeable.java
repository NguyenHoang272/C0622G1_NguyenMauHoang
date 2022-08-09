package interface_colorable.Model;

class Rectangle extends Shape implements Colorable{
    private double width = 6.0;
    private double height = 8.0;

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

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}' + super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("Cách tô màu: Rectangle");
    }
}
