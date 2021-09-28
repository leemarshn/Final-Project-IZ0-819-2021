package concurency;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Tuesday 28 September 2021 - 6:50 AM
 */
public class ParallelReduce {
    public static void main(String[] args) {

     Optional sum =   List.of(1,2,3,4,5,6,7,8,9)
                .stream()
             .parallel()
                .reduce( (s1, s2) -> s1 +s2);

        System.out.println(sum);

        String str = List.of('w', 'o', 'l', 'f')
                .stream()
                .parallel()
                .reduce("8", (s1, c) -> s1 + c, (s2, s3) -> s2 + s3);

        System.out.println(str);

        System.out.println(List.of(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0,	(a,b)	->	(a	-	b)));		//	PROBLEMATIC	ACCUMULATOR

    }
}
