package ocp;

public class Circle extends Shape {
    public Circle(double x) {
        this.x = x;
    }

    @Override
    public double area() {
        return Math.pow(this.x, 2)*Math.PI;
    }
}
