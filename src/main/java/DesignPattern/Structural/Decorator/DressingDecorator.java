package DesignPattern.Structural.Decorator;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class DressingDecorator extends SandWichDecorator{

    public DressingDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String make() {
        return sandwich.make()+ addDressing();
    }

    private String addDressing() {
        return "+ mustard";
    }
}
