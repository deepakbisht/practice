package DesignPattern.Creational;

/**
 * Created By Deepak Bisht on 15/05/21
 */
public class DbSingleTonLazilyLoaded {
    private static volatile   DbSingleTonLazilyLoaded instance;
    public static DbSingleTonLazilyLoaded getInstance() throws InterruptedException {
        if(instance==null) {
            Thread.sleep (3000);
            synchronized (DbSingleTonLazilyLoaded.class) {
                instance = new DbSingleTonLazilyLoaded();
            }
        }
        return instance;
    }

    private DbSingleTonLazilyLoaded() {
        if(instance != null) {
            throw  new UnsupportedOperationException("Use getInstance() method");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () ->{
            DbSingleTonLazilyLoaded dbSingleTonLazilyLoaded = null;
            try {
                dbSingleTonLazilyLoaded = DbSingleTonLazilyLoaded.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(dbSingleTonLazilyLoaded);
        };
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        thread.start();;
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
