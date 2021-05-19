package DesignPattern.Structural.Decorator;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class MeatDecorator extends SandWichDecorator{
    public MeatDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String make() {
        return sandwich.make() + addMeat();
    }

    private String addMeat() {
        return " + turkey";
    }
}
