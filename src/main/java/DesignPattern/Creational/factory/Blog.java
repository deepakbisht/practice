package DesignPattern.Creational.factory;

/**
 * Created By Deepak Bisht on 15/05/21
 */
public class Blog extends Website {
    @Override
    public void createWebsite() {
        pages.add(new PostPage());
        pages.add(new ContactUsPage());
        pages.add(new AboutUsPage());
    }
}
