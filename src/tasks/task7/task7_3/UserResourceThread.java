package tasks.task7.task7_3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Egor on 17.09.2016.
 */
public class UserResourceThread {

    public static BlockingQueue<String> threadQueue = new ArrayBlockingQueue<>(4);

    private static void initThreadQueue() {
        threadQueue.offer("1");
        threadQueue.offer("2");
        threadQueue.offer("3");
        threadQueue.offer("4");
    }

    public static void main(String[] args) throws InterruptedException {

        SharedResource res = new SharedResource();

        initThreadQueue();

        IntegerSetterGetter t1 = new IntegerSetterGetter("1", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", res);
        IntegerSetterGetter t5 = new IntegerSetterGetter("5", res);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.sleep(100);

        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();
        t5.stopThread();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("main");

    }
}
