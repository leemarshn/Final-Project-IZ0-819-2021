package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Thursday 16 September 2021 - 6:53 AM
 */
public class SearchFiles {

    public static void main(String[] args) throws IOException {
        String dir = "/home/oracle/Documents/Java/Reading Now/code";
        int depth = 1;

        try (var s = Files.walk(Paths.get(dir), depth)){
            s.
                     filter(f -> !Files.isDirectory(f))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(f -> f.endsWith(".csv"))
                    //.map(f -> Files.lines(f))
                    .forEach(System.out::println);

        }
    }
}
