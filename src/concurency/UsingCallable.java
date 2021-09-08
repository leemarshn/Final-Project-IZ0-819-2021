package concurency;

import java.util.concurrent.*;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Wednesday 08 September 2021 - 6:33 AM
 */
public class UsingCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            Callable<Integer> task = () -> 10*3;
            Future<Integer> future = service.submit(task);
            System.out.println(future.get());;
        }finally {
            if (service != null) service.shutdown();
        }
        if(service	!=	null) {
            service.awaitTermination(10, TimeUnit.SECONDS);

            //	Check	whether	all	tasks	are	finished
            if (service.isTerminated()) System.out.println("Finished!");
            else System.out.println("At	least	one	task	is	still	running");
        }
    }
}
