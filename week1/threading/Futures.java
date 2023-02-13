package week1.threading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Futures {
    private static List<Integer> firstService() {
        long startTime = System.nanoTime();
        System.out.println("Starting first service...");
        ArrayList<Integer> list = new ArrayList<>();
        try{
            list.add(1);
            System.out.println("Added 1 to firstService...");
            Thread.sleep(1000);
            list.add(2);
            System.out.println("Added 2 to firstService...");
            Thread.sleep(5000);
            list.add(3);
            System.out.println("Added 3 to firstService...");
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.print("First service done! Time spent in first service: ");
        System.out.println(System.nanoTime() - startTime);
        return list;
    }

    private static List<Integer> secondService() {
        long startTime = System.nanoTime();
        System.out.println("Starting second service...");
        ArrayList<Integer> list = new ArrayList<>();
        try{
            list.add(4);
            System.out.println("Added 4 to secondService...");
            Thread.sleep(2000);
            list.add(5);
            System.out.println("Added 5 to secondService...");
            Thread.sleep(1000);
            list.add(6);
            System.out.println("Added 6 to secondService...");
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.print("Second service done! Time spent in second service: ");
        System.out.println(System.nanoTime() - startTime);
        return list;
    }

    private static CompletableFuture<List<Integer>> startFirstService(ExecutorService es){
        return CompletableFuture.supplyAsync(Futures::firstService, es);
    }

    private static CompletableFuture<List<Integer>> startSecondService(ExecutorService es){
        return CompletableFuture.supplyAsync(Futures::secondService, es);
    }

    public static void main(String[] args) {
        // Create ExecutorService (es) to have tasks run on threads in that thread pool by passing es into
        // CompletableFuture::supplyAsync. If we don't pass an executor, then the task would have been completed
        // in ForkJoinPool.commonPool(), which is a lazily created static threadpool. commonPool is useful for when you
        // don't care about what thread the task is running on & don't need to block the task.
        // https://dzone.com/articles/be-aware-of-forkjoinpoolcommonpool
        ExecutorService es = Executors.newFixedThreadPool(2);
        // Used Stream here over List::addAll so that I get a returned list, rather than modifying the initial list
        // and returning it myself
        // CompletableFuture::join used to wait until the CompletableFuture is completed, otherwise println would print
        // an incomplete future.
        List<Integer> result = startFirstService(es).thenCombine(startSecondService(es),
                (firstServiceResult, secondServiceResult)
                        -> Stream.concat(firstServiceResult.stream(), secondServiceResult.stream())
                        .collect(Collectors.toList())).join();
        System.out.println(result);

        // Kept getting sleep interrupted error when I had this as shutdownNow method...oops...this function ran before
        // my thread was able to finish the job
        es.shutdown();
    }
}