package shapes;

public class Circle extends Shape {

    public Circle(double height) {
        super(height, height);
    }

    public double getArea() {
        return 3.14 * Math.pow((super.getHeight() / 2), 2);
    }
}
