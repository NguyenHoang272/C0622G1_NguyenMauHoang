package point2D_and_point3D.Model2;

import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;

    public  Point2D(){
        this.x = 0.1f;
        this.y = 0.1f;
    }

    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY(){
        float[] array= {x,y};
        return array;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return  "x=" + getX() +
                ", y=" + getY() +
                " , xy="+ Arrays.toString(getXY());
    }
}

