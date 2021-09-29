package concurency;

import java.util.List;
import java.util.Optional;

public class FindAny {
    public static void main(String[] args) {
        Integer num = List.of(1,2,3,4,5,6,7)
                .stream()
                .parallel()
                .unordered()
                .skip(2)
                .findFirst()
                .get();


        System.out.println(num);

    }
}
