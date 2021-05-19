package Threading.ThreadPool;

import java.util.concurrent.BlockingQueue;

/**
 * Created By Deepak Bisht on 09/05/21
 */
public class RunnableThread implements Runnable {
    private Thread thread = null;
    private BlockingQueue<Runnable> blockingQueue = null;
    private boolean isStopped = false;


    public RunnableThread(BlockingQueue<Runnable> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped) {
            try {
                Runnable runnable = blockingQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.thread.interrupt();
    }
    public synchronized boolean isStopped() {
        return  isStopped;
    }
}
