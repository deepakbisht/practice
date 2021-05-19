package DesignPattern.Structural.Bridge.Shape;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        color.applyColor();
    }
}
