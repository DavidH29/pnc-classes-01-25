package isp;

public class Square implements AreaCalculator {
    public Double l;


    @Override
    public Double calculateArea(double l) {
        return Math.pow(l, 2);
    }

}
