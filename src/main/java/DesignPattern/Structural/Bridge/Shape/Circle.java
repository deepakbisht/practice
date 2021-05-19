package DesignPattern.Structural.Bridge.Shape;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        color.applyColor();
    }
}
