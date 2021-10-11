package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class VoucherNumbers {
    private static final long limit = 1_0L;
    private  static final VoucherNumbers vn = new VoucherNumbers();

    public List<Long> generateRandomNumbers() {
        List<Long> random= new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            long smallest = 1000_0000_0000_0000L;
            long biggest = 9999_9999_9999_9999L;
            random.add(ThreadLocalRandom.current().nextLong(smallest, biggest));
        }
        return random;
    }

    private Path getPath(){
        Path path = Path.of("C:\\Users\\Lenovo\\Documents\\nio2\\folder1\\voucher_numbers.csv");
        if (Files.exists(path))
            path =  Path.of("C:\\Users\\Lenovo\\Documents\\nio2\\folder1\\voucher_numbers2.csv");

        return path;

    }

    private Path writeToFile(){
        Path path = Path.of("C:\\Users\\Lenovo\\Documents\\nio2\\folder1\\voucher_numbers.csv");
        if (Files.exists(path))
            path =  Path.of("C:\\Users\\Lenovo\\Documents\\nio2\\folder1\\voucher_numbers2.csv");
        List<Long> data = vn.generateRandomNumbers();
        try(var writer = Files.newBufferedWriter(path)){
            for(var line : data) {
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    private void readFile(Path path){
        try (var read = Files.lines(path)){
            read.sorted()
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void performTasks(CyclicBarrier c1){

        //vn.writeToFile(vn.generateRandomNumbers());
    }


    public static void main(String[] args) throws IOException {

        vn.writeToFile();
        vn.readFile(vn.writeToFile());

//        System.out.println(path.getFileName());

    }
}
