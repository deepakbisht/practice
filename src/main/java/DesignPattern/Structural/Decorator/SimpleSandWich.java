package DesignPattern.Structural.Decorator;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class SimpleSandWich implements Sandwich{
    @Override
    public String make() {
        return "Bread";
    }
}
