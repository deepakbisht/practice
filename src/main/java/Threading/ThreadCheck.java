package Threading;

/**
 * Created By Deepak Bisht on 14/05/21
 */
public class ThreadCheck {

    static volatile int count=1;

    static volatile int counter=10;
    public static void main(String [] args) throws InterruptedException {

        Runnable r1=()->{
            while(count%3==1){
                System.out.println("a");
                count++;
            }
        };
        Runnable r2=()->{

            while(count%3==2 ){
                System.out.println("b");
                count++;
            }
        };
        Runnable r3=()->{
            while(count%3==0){
                System.out.println("c");
                count++;
            }
        };
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        Thread t3=new Thread(r3);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        //  System.out.println("MAin ended");

    }
}
