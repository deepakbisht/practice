package DesignPattern.Structural.Bridge.Shape;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class ShapeColorBridgeDemo {
    public static void main(String[] args) {
        Color green = new Green();
        Color yellow = new Yellow();
        Shape square = new Square(green);
        square.applyColor();
        Shape circle = new Circle(yellow);
        circle.applyColor();
    }
}
