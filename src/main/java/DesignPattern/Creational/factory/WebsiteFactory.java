package DesignPattern.Creational.factory;

/**
 * Created By Deepak Bisht on 15/05/21
 */
public class WebsiteFactory {
    public static Website getWebsite(String type) {
        Website website = null;
        switch (type) {
            case "blog":
                website = new Blog();
                break;
            case "shop" :
                website = new Shop();
                break;
        }
        return website;
    }
}
