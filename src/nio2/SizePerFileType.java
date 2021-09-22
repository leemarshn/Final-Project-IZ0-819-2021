package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Wednesday 22 September 2021 - 7:02 AM
 */
public class SizePerFileType {

    private long getSize(Path p) {
        try {
            return Files.size(p);
        } catch (IOException e) {
            //	Handle	exception
        }
        return 0L;
    }

    private double getSizePerFile(Path path, String fileName) throws IOException {
        try (var s = Files.walk(path)) {
            return
                    s.parallel()
                            .filter(p -> !Files.isDirectory(p))
                            .filter(p -> p.toString().endsWith(fileName))
                            .mapToLong(this::getSize)
                            .sum() / 1000000.0;

        }
    }


    public static void main(String[] args) throws IOException {

        SizePerFileType sizePerFileType = new SizePerFileType();
        Path p = Path.of("/home/oracle/Downloads");
        String[] files = new String[]{"pdf", "txt", "zip", "png", "jpg", "csv", "doc", "html", "xlsx", "mp4", "sql", "json", "xls", "docx"};

        for (String file : files) {
            System.out.format("The size of " + file +
                    " files is: %.2f MB %n ", (sizePerFileType.getSizePerFile(p, file)));
        }
    }
}
