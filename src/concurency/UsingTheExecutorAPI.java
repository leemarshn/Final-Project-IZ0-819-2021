package concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Tuesday 07 September 2021 - 6:55 AM
 */
public class UsingTheExecutorAPI {

    public static void main(String[] args) {
        ExecutorService service = null;

        Runnable task1 = () -> {
            System.out.println("Task 1 running");
        };

        Runnable task2 = () -> { for (int i=0; i<100; i++)
            System.out.println("Printing i: " + i);};

        try {
            service = Executors.newSingleThreadExecutor();
            service.execute(task1);
            service.execute(task2);
            service.execute(task1);
            System.out.println("end");
        }finally {
            if (service != null) service.shutdown();
        }
    }

}
