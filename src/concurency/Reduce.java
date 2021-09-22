package concurency;

import java.util.List;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Tuesday 14 September 2021 - 6:37 AM
 */
public class Reduce {
    public static void main(String[] args) {
        System.out.println(List.of('w',	'o',	'l',	'f')
                .parallelStream()
                .reduce("-",
                        (s1,c)	->	s1	+	c,
                        (s2,s3)	->	s2	+	s3));		//	wolf

        System.out.println(List.of(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0,	(a,b)	->	(a	-	b)));
    }
}
