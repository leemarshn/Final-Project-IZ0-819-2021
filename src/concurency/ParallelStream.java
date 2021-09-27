package concurency;

import nio2.VoucherNumbers;

import java.util.Iterator;
import java.util.List;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Monday 27 September 2021 - 5:47 AM
 */
public class ParallelStream extends VoucherNumbers {

    private static Long doWork(List<Long>input){

        Iterator<Long> iterator = input.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()*2);
            return iterator.next() *2;

        }
        return 0L;
    }



    public static void main(String[] args) {
        long	start	=	System.currentTimeMillis();
        VoucherNumbers n = new VoucherNumbers();
//       List.of(n.generateRandomNumbers(5000000))
//                .stream()
//                .mapToLong(ParallelStream::doWork)
//                .forEach(s	->	System.out.println(s	+	"	"));
//
//        System.out.println();
        var	timeTaken	=	(System.currentTimeMillis()-start)/1000;
        System.out.println("Time:	"+timeTaken+"	seconds");

    //    System.out.println(doWork(n.generateRandomNumbers(100)));


        List<Long> list = n.generateRandomNumbers(100);
        Iterator<Long> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
//
//    private static int doWork(List<Long> longs) {
//    }
}
