package nio2;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Generate16Digits10MTimes {
    private long smallest = 1000_0000_0000_0000L;
    private long biggest = 9999_9999_9999_9999L;
    private long upTo = 1_000_000L;

    private List<Long> generateRandomLoop(long limit) {
        List<Long> random= new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            random.add(ThreadLocalRandom.current().nextLong(smallest, biggest + 1));
        }
        return random;
    }

    public static void main(String[] args) {

        Generate16Digits10MTimes generate = new Generate16Digits10MTimes();

        ExecutorService service = null;

        long start = System.currentTimeMillis();
        generate.generateRandomLoop(generate.upTo)
                .stream()
                .parallel()
                .sorted()
                .distinct()
                .forEach(System.out::println);
        long end = System.currentTimeMillis()-start;
        double totalTime = end/1000.0;

        System.out.println("It took: " + totalTime + " Seconds to generate "
                + new DecimalFormat("###,###,###,###.00").format(generate.upTo)
                +" Possible Voucher Values");

    }
}
