package DesignPattern.Structural.Decorator;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandWich()));
        System.out.println(sandwich.make());
    }

}
