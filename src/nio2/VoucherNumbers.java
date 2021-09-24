package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VoucherNumbers {
    private final long upTo = 1_000_000L;

    private List<Long> generateRandomNumbers(long limit) {
        List<Long> random= new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            long smallest = 1000_0000_0000_0000L;
            long biggest = 9999_9999_9999_9999L;
            random.add(ThreadLocalRandom.current().nextLong(smallest, biggest + 1));
        }
        return random;
    }

    void writeToFile(List<Long> data, Path path) throws IOException {
        try(var writer = Files.newBufferedWriter(path)){
            for(var line : data) {
                writer.write(line.toString());
                writer.newLine();
            }
        }
    }

    void readFile(Path path) throws IOException {
        try (var read = Files.lines(path)){
            read.sorted()
                    .forEach(System.out::println);

        }
    }


    public static void main(String[] args) throws IOException {

        VoucherNumbers vn = new VoucherNumbers();
        Path path = Path.of("C:\\Users\\Lenovo\\Documents\\nio2\\folder1\\voucher-numbers.csv");

        long start = System.currentTimeMillis();
        vn.generateRandomNumbers(vn.upTo)
                .stream()
                .parallel()
                .sorted()
                .distinct()
                .forEach(System.out::println);
        long end = System.currentTimeMillis()-start;
        double totalTime = end/1000.0;

        System.out.println("It took: " + totalTime + " Seconds to generate "
                + new DecimalFormat("###,###,###,###.00").format(vn.upTo)
                +" Possible Voucher Values");

        vn.writeToFile(vn.generateRandomNumbers(vn.upTo), path);
        vn.readFile(path);


    }
}
