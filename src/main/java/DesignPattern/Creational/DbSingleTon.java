package DesignPattern.Creational;

/**
 * Created By Deepak Bisht on 15/05/21
 */
public class DbSingleTon {
 private static  DbSingleTon instance = new DbSingleTon();
 public static DbSingleTon getInstance() {
     return  instance;
 }

 private DbSingleTon() {

 }
    public static void main(String[] args) {
        DbSingleTon dbSingleTon = getInstance();
        DbSingleTon dbSingleTon1 = getInstance();
        System.out.println(dbSingleTon1 == dbSingleTon);
    }
}
