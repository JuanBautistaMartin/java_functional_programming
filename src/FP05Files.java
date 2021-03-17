import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Print a list of numbers
 */
public class FP05Files {

    public static void main(String[] args) throws IOException {

        Files.lines(Paths.get("file.txt"))
                .forEach(System.out::println);

        System.out.println("==========================================");

        // Get unique words present in the file
        Files.lines(Paths.get("file.txt"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("==========================================");

        // Get all the files
        Files.list(Paths.get("."))
                .forEach(System.out::println);

        System.out.println("==========================================");

        // Get only the directories
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }

}
