package DesignPattern.Structural.Bridge.Shape;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public abstract class Shape {
    Color color;
    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}
