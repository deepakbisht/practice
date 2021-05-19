package DesignPattern.Structural.Composite;

/**
 * Created By Deepak Bisht on 18/05/21
 */
public class MenuDemo {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("Main", "/main");
        Menu safetyItem = new Menu("Safety", "/safety");
        mainMenu.add(safetyItem);

        Menu claimsMenu = new Menu("Claims", "/claims");
        mainMenu.add(claimsMenu);

        MenuItem personalClaimsMenu = new MenuItem("Personal claim", "/personalClaims");
        claimsMenu.add(personalClaimsMenu);

        System.out.println(mainMenu.toString());
    }

}
