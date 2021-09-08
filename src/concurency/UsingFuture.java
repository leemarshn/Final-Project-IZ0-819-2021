package concurency;

import java.util.concurrent.*;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Wednesday 08 September 2021 - 5:49 AM
 */
public class UsingFuture {
    private static int counter = 0;

    public static void main(String[] args) throws Exception {
//       new Thread(() ->{ for (int i=0; i<500; i++){
//            UsingFuture.counter++;
//        }}).start();
//        while (UsingFuture.counter<100) {
//            System.out.println("Not reached yet");
//            Thread.sleep(1000);
//        }
//        System.out.println(counter);

        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            Runnable task = () -> { for (int i=0; i<50000000000L; i++) UsingFuture.counter++; };
            Future<?> future = service.submit(task);
            future.get(10, TimeUnit.SECONDS);
            System.out.println("Reached");
        }catch (TimeoutException e){
            System.out.println("Not Reached yet");
        }finally {
            if (service != null) service.shutdown();
        }

    }

}
