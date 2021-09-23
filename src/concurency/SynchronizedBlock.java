package concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedBlock {
    private  Integer count =0;

    public void incrementAndReport(){
        synchronized (SynchronizedBlock.class) {
            System.out.print(count++);
        }
    }
    public void printDaysWork() {
        synchronized (SynchronizedBlock.class) {
            System.out.print("Finished work");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SynchronizedBlock sb = new SynchronizedBlock();
            for (int i = 0; i < 10; i++) {
              service.submit(sb::incrementAndReport);
              service.submit(sb::printDaysWork);
            }
        }finally {
            if (service !=null) service.shutdown();
        }
    }
}
