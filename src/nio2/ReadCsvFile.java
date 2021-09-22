package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Thursday 16 September 2021 - 6:36 AM
 */
public class ReadCsvFile {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/home/oracle/Documents/Java/Reading Now/code/basicMaths.csv");
        boolean exists = Files.exists(path);
        System.out.println(exists);




    }
}
