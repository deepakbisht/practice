package DesignPattern.Creational.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Deepak Bisht on 15/05/21
 */
public abstract class Website {
    protected List<Page> pages = new ArrayList<>();

    public Website() {
        this.createWebsite();
    }

    public List<Page> getPages() {
        return pages;
    }

    public abstract void createWebsite();
}
