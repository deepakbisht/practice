package Threading.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created By Deepak Bisht on 09/05/21
 */
public class ThreadPool {
    private BlockingQueue taskQueue = null;
    private List<RunnableThread> runnableThreads = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new ArrayBlockingQueue<>(maxNoOfTasks);
        for(int i=0;i<noOfThreads;i++) {
            RunnableThread runnableThread = new RunnableThread(taskQueue);
            runnableThreads.add(runnableThread);
        }
        for(RunnableThread runnableThread: runnableThreads) {
            new Thread(runnableThread).start();
        }
    }

    public synchronized void execute(Runnable task) {
        if(this.isStopped)
            throw new IllegalArgumentException("");
        this.taskQueue.offer(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for(RunnableThread runnableThread: runnableThreads) {
            runnableThread.doStop();
        }
    }
    public synchronized void waitUntillAllFinished() throws InterruptedException {
        while (this.taskQueue.size() > 0) {
            Thread.sleep(1000);
        }
    }
}

