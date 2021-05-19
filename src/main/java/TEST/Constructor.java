package TEST;

/**
 * Created By Deepak Bisht on 08/10/20
 */
public class Constructor {

    static String str;
    public void Constructor() {
        System.out.println("In constructor");
        str = "Hello world";
    }
    public static void main(String... args) {
       Constructor c = new Constructor();
       System.out.println(str);
    }

}
