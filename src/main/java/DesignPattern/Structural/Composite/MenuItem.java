package DesignPattern.Structural.Composite;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return print(this);
    }
}
