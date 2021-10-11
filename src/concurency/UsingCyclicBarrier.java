package concurency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Monday 13 September 2021 - 6:10 AM
 */
public class UsingCyclicBarrier {
    public void cleanZoo(){
        System.out.println("Cleaning zoo");
    }
    public void addingLions(){
        System.out.println("Adding Lions");
    }
    public void removingLions(){
        System.out.println("Removing Lions");
    }
    public void performTasks(CyclicBarrier c1){

       try {
            cleanZoo();
            c1.await();
            addingLions();
            c1.await();
            removingLions();
       } catch (Exception e){
           System.out.println( e);
       }
    }

    public static void main(String[] args) {
        ExecutorService service  = null;
        UsingCyclicBarrier zoo = new UsingCyclicBarrier();

        try {
            service = Executors.newFixedThreadPool(10);
            var c1 = new  CyclicBarrier(10);
            var c2 = new CyclicBarrier(10,()-> System.out.println("finished cleaning zoo"));
            for (int i=0; i<10; i++)
            service.submit(()-> zoo.performTasks(c1) );
        }finally {
            if (service != null) service.shutdown();
        }
    }

}
