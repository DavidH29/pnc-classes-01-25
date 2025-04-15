package ocp;

public class Triangle extends Shape implements AreaCalculator {
    public float h;

    public Triangle(float x,float h) {
        this.x = x;
        this.h = h;
    }

    @Override
    public double area() {
        return (x*h)/2;
    }

    @Override
    public float calculateArea() {
        return (float) ((x*h)/2);
    }
}
