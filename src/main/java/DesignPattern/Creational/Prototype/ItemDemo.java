package DesignPattern.Creational.Prototype;

/**
 * Created By Deepak Bisht on 15/05/21
 */
public class ItemDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        ItemRegistry itemRegistry = new ItemRegistry();
        System.out.println(itemRegistry.createItem("Movie"));
        System.out.println(itemRegistry.createItem("Movie"));
        System.out.println(itemRegistry.createItem("Movie"));
        System.out.println(itemRegistry.createItem("Movie"));
        System.out.println(itemRegistry.createItem("Book"));
        System.out.println(itemRegistry.createItem("Book"));
        System.out.println(itemRegistry.createItem("Book"));
        System.out.println(itemRegistry.createItem("Book"));

    }
}
