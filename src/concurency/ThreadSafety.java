package concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Friday 10 September 2021 - 6:38 AM
 */
public class ThreadSafety {
    private AtomicInteger sheepCount	=	new AtomicInteger(0);
    private	void	incrementAndReport()	{
        System.out.print((sheepCount.incrementAndGet())+"	");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        ThreadSafety safety = new ThreadSafety();

        try {
            service = Executors.newFixedThreadPool(4);
            for (int i = 0; i < 10; i++) {
                service.submit(safety::incrementAndReport);
            }
        }finally {
            if (service !=null) service.shutdown();
        }
    }
}
