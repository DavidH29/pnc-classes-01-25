package isp;

public class Cube implements AreaCalculator, VolumeCalculator {
    public Double l;


    @Override
    public Double calculateArea(double l) {
        return Math.pow(l,2)*6;
    }

    @Override
    public Double calculateVolume(double l, double h) {
        return Math.pow(l, 2)*h;
    }
}
