package Threading.ThreadPool;

/**
 * Created By Deepak Bisht on 09/05/21
 */
public class ThreadPoolService {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(3, 10);
        for( int i=0;i<10;i++) {
            int taskNo = i;
            threadPool.execute(()->{
                String message = Thread.currentThread().getName() + " executing:" + taskNo;
                System.out.println(message);
            });
        }
        threadPool.waitUntillAllFinished();
        threadPool.stop();
    }
}
