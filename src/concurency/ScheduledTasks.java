package concurency;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduledTasks {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = null;
        Runnable sayHello = () -> System.out.println("Hello LeeN " + LocalDateTime.now());

        try {
            service = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<?> task = service.scheduleAtFixedRate(sayHello, 10, 1, TimeUnit.MILLISECONDS);
            //task.get();

        }finally {
            if (service !=null) service.shutdown();
        }

        System.out.println(Runtime.getRuntime().totalMemory());

    }
}
