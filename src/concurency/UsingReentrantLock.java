package concurency;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsingReentrantLock {
    private int balance =0;

    public int topUpBalance(int amount){
        return balance+=amount;
    }
    public int withdraw(int amount){
        return balance-=amount;
    }
    public void checkBalance(){
        System.out.println(balance);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UsingReentrantLock account = new UsingReentrantLock();
        ExecutorService service = null;

        Lock lock = new ReentrantLock();
            try {
                service = Executors.newFixedThreadPool(20);

                service.submit(() -> { lock.lock(); account.topUpBalance(5000);});
            } finally {
                lock.unlock();
                if (service != null) service.shutdown();
            }





    }
}
