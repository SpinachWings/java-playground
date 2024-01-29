package graphics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

import java.util.Scanner;

public class ShapeRenderer extends Application
{
    Shape shape;

    @Override
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to create a circle or 2 to create a rectangle");
        int actionNumber = sc.nextInt();
        this.shape = determineCircleOrRectangle(actionNumber, sc);
    }

    @Override
    public void start(Stage stage) {
        Group root;
        if (shape instanceof Circle) {
            double radius = shape.getHeight() / 2;
            javafx.scene.shape.Circle definedShape = new javafx.scene.shape.Circle(125, 125, radius);
            definedShape.setFill(Color.RED);
            definedShape.setStroke(Color.BLUE);
            root = new Group(definedShape);
        } else if (shape instanceof Rectangle) {
            javafx.scene.shape.Rectangle definedShape = new javafx.scene.shape.Rectangle(25, 25, shape.getWidth(), shape.getHeight());
            definedShape.setFill(Color.RED);
            definedShape.setStroke(Color.BLUE);
            root = new Group(definedShape);
        } else {
            root = new Group();
        }

        Scene scene = new Scene(root, 250, 250, Color.YELLOW);
        stage.setScene(scene);
        stage.show();

        System.out.println("Shape created with area of: " + shape.getArea());
    }
    public static void main(String[] args)
    {
        launch(args);
    }

    private static Shape determineCircleOrRectangle(int circleOrSquare, Scanner sc) {
        Shape shape;
        switch(circleOrSquare) {
            case 1:
                System.out.println("Creating circle");
                shape = defineCircle(sc);
                break;
            case 2:
                System.out.println("Creating rectangle");
                shape = defineRectangle(sc);
                break;
            default:
                System.out.println("Invalid integer entered, defaulting to circle");
                shape = defineCircle(sc);
        }
        return shape;
    }

    private static shapes.Circle defineCircle(Scanner sc) {
        int height = setShapeHeight(sc);
        return new Circle(height);
    }

    private static shapes.Rectangle defineRectangle(Scanner sc) {
        int height = setShapeHeight(sc);
        int width = setShapeWidth(sc);
        return new Rectangle(height, width);
    }

    private static int setShapeHeight(Scanner sc) {
        return setDimension(sc, "height");
    }

    private static int setShapeWidth(Scanner sc) {
        return setDimension(sc, "width");
    }

    private static int setDimension(Scanner sc, String dimension) {
        System.out.println("Enter a " + dimension + " for the shape: min 10, max 200");
        int value = sc.nextInt();
        int finalValue;

        if (value < 10) {
            System.out.println("Number too small, setting to 10");
            finalValue = 10;
        } else if (value > 200) {
            System.out.println("Number too large, setting to 200");
            finalValue = 200;
        } else {
            finalValue = value;
        }

        return finalValue;
    }
}