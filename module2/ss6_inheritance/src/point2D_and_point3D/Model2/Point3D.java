package point2D_and_point3D.Model2;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D(){
        super();
        this.z = 0.0f;
    }

    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ(){
        float[] array = {getX(),getY(),z};
        return array;
    }
    public void setXYZ(float x, float y, float z){
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "x=" + getX()+ " , y=" + getY()+
                " , z=" + getZ() +
                " , xyz"+ Arrays.toString(getXYZ());
    }
}
