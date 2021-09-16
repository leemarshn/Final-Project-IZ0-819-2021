package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Thursday 16 September 2021 - 6:18 AM
 */
public class ListDirectoryContents {
    public Set<String> listFilesUsingFileWalk(String dir, int depth) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    //.filter(file -> file.endsWith("csv"))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }



    public static void main(String[] args) throws IOException {
        String p = "/home/oracle/Documents/Java/Reading Now/code";
        int depth = 1;

        ListDirectoryContents ls = new ListDirectoryContents();
        for (String ss: ls.listFilesUsingFileWalk(p,depth)){
            System.out.println(ss);
        }
    }
}
