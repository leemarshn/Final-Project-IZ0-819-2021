package concurency;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Thursday 02 September 2021 - 6:30 AM
 */
public class Concurrency implements Runnable{



    @Override
    public void run() {
        System.out.println("First Concurrent thread");
    }

    public static void main(String[] args) {

        Runnable	sloth	=	()	->	System.out.println("Hello	World");
        (new Thread(sloth)).start();
       // (new Thread(new Concurrency())).start();


    }
}
