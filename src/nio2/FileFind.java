package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Wednesday 22 September 2021 - 5:52 AM
 */
public class FileFind {

    private void searchFile(Path path, String name){
        int depth = 5;
        try (var s = Files.find(path, depth, (p, a) -> p.toString().endsWith(name))){
                s.
                         map(Path::getFileName)
                        .sorted()
                        .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Path path = Path.of("/home/oracle/Documents/Java/Reading Now");
        String fileName = ".pdf";
        FileFind  fileFind = new FileFind();
        fileFind.searchFile(path, fileName);

    }

}
