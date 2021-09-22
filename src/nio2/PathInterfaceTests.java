package nio2;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Wednesday 15 September 2021 - 6:38 AM
 */
public class PathInterfaceTests {
    public static void main(String[] args) {
        Path path2	=	FileSystems.getDefault()
                .getPath("./data/images/leen.jpg");
        boolean exist = Files.exists(path2);

        System.out.println(exist);
    }
}
