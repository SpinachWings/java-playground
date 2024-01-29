package shapes;

public class Rectangle extends Shape {

    public Rectangle(double height, double width) {
        super(height, width);
    }

    public double getArea() {
        return super.getHeight() * super.getWidth();
    }
}