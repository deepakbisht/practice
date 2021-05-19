package DesignPattern.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public abstract class MenuComponent {
    String name;
    String url;
    List<MenuComponent> menuComponents = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public abstract String toString();

    String print(MenuComponent menuComponent) {
        StringBuilder stringBuilder = new StringBuilder(name);
       return stringBuilder.append(" ").append(url).append("\n").toString();
    }
}
