package ocp;

public class Square extends Shape{
    public Square(double x) {
        this.x = x;
    }

    @Override
    public double area() {
        return Math.pow(x, 2);
    }
}
