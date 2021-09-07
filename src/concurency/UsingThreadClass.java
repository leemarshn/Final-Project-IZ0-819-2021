package concurency;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Tuesday 07 September 2021 - 6:22 AM
 */
public class UsingThreadClass extends Thread  {

    @Override
    public void run() {
        System.out.println("Another way to run a thread");
    }

    public static void main(String[] args) {
        new Thread(()-> System.out.println("Extending thread class")).start();
        new UsingThreadClass().start();
    }




}
