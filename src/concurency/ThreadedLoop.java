package concurency;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ThreadedLoop {
    private static int counter;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
//        long start1 = System.currentTimeMillis();
       long end2;

//        for (int i=0; i<100000000; i++){
//            counter+=i;
//        }
//
//        System.out.println(counter);
//        long end1 = System.currentTimeMillis();
        //System.out.println("Without Concurrency: "+ (end1-start1));

        long start2 = System.currentTimeMillis();

        try {
            service = Executors.newFixedThreadPool(4);
            Callable<Integer> task = () ->{ for(int i=0; i<100000000; i++) counter +=i;
                return counter;
            };

            Future<Integer> task3 = service.submit(task);
            System.out.println("results: " + task3.get());
            end2 = System.currentTimeMillis();
        }finally {
            if (service !=null) service.shutdown();
        }


        System.out.println("With Concurrency: "+ (end2-start2));
        long end3 = end2-start2;
        //System.out.println("With concurrency: " + (end3-(end1-start1)));

       // System.out.println(LocalDateTime.now());
    }
}
