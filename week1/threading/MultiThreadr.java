package week1.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class evenStevenThread extends Thread {
    // implements Runnable seems to be favorable to extends Thread because Thread has a task to do, and generally we
    // just want to have a task for Thread to do. By extending Thread, we are creating a special type of Thread to do
    // our task.
    // https://www.quora.com/In-Java-threading-what-is-the-difference-between-implements-Runnable-and-extends-Thread
    // https://manikandanmv.wordpress.com/tag/extends-thread-vs-implements-runnable/
    @Override
    public void run() {
        IntStream.range(0, 50).forEach(num -> {
            if (num % 2 == 0) {
                System.out.println(num);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

class oddlyBackwardsThread extends Thread{
    @Override
    public void run() {
        for (int i = 49; i > 0; i -= 2) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class MultiThreadr {
    public static void main(String[] args) {
        // Code below to run threads sequentially
//        Runnable evenSteven = new evenStevenThread();
//        Runnable oddlyBackwards = new oddlyBackwardsThread();
//        evenSteven.run();
//        oddlyBackwards.run();

        // Code below to run both threads simultaneously
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new evenStevenThread());
        es.submit(new oddlyBackwardsThread());
        es.shutdown();
    }
}