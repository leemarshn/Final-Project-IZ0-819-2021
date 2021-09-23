package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithSonnet {

    private static final String WORD_REGEXP = "[- .:,]+";

    List<String> getUniqueWords () throws IOException {
        Path path = Path.of("C:\\Users\\Lenovo\\Documents\\nio2\\folder1\\sonnet.txt");
        try (var s = Files.lines(path)) {
            return s.
                    flatMap(lines -> Stream.of(lines.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    void createFileFromList(Path path, List<String> words) throws IOException {
        PlayWithSonnet pi = new PlayWithSonnet();
        List<String> list= pi.getUniqueWords();
        try (var writer = Files.newBufferedWriter(path)){
            for (String word: list ){
                writer.write(word);
            }

        }
    }


    public static void main(String[] args) throws IOException {
        PlayWithSonnet pi = new PlayWithSonnet();
        Path dest = Path.of("C:\\Users\\Lenovo\\Documents\\nio2\\folder1\\uniqueWords.txt");

        List<String> list =  pi.getUniqueWords();
        pi.createFileFromList(dest, list);

    }

}
