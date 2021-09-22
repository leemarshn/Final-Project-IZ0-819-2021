package nio2;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Generate16Digits10MTimes {
    public static void main(String[] args) {

        ExecutorService service = null;

        long smallest = 1000_0000_0000_0000L;
        long biggest =  9999_9999_9999_9999L;


        long start = System.currentTimeMillis();
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                long random = ThreadLocalRandom.current().nextLong(smallest, biggest + 1);
                System.out.println(random);
            }
        };

        try {
            service = Executors.newFixedThreadPool(4);
            service.execute(task);
        }finally {
            if (service !=null) service.shutdown();
        }
        long end = System.currentTimeMillis()-start;
        double totalTime = end/1000.0;

        System.out.println("It took: " + totalTime + " Seconds to generate 10M Random Numbers");

    }
}
