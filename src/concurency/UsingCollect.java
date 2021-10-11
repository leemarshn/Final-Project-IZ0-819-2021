package concurency;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingCollect {

    public static void main(String[] args) {
        StringBuilder stream = Stream.of("W", "O", "L", "F")
                .parallel()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

        System.out.println(stream);

        int sum = Stream.of(1,2,3,4,5)
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println(sum);
    }
}
