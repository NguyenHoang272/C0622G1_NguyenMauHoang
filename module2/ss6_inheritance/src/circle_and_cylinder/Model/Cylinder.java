package circle_and_cylinder.Model;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){
        super();
        this.height = 5.0;
    }
    public Cylinder(double radius, String color, double height){
    super(radius, color);
    this.height =height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double volumeCylinder(){
        return Math.PI * (this.getRadius()*this.getRadius())* this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                "Thể tích=" +volumeCylinder()+
                '}';
    }
}
