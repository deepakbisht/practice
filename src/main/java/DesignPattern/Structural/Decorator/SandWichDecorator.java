package DesignPattern.Structural.Decorator;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public abstract class SandWichDecorator implements Sandwich {
    Sandwich sandwich;
    public SandWichDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String make() {
        return sandwich.make();
    }
}
