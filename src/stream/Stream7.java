package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream7 {
    public static void main(String[] args) throws IOException {
        //Load a file from path
        // lazy evaluation,
        // is memory-efficient,
        // integrates naturally with the Stream API,
        // and is ideal for processing large files
        Path path = Paths.get("src/stream/files/paragraph.txt");
        try (Stream<String> stream = Files.lines(path)) {
            List<String> list = stream.flatMap(line -> Arrays.stream(line.toLowerCase().split("\\W+")))
//                    .filter(word -> word.equals(
//                            new StringBuilder(word).reverse().toString()
//                    )).toList();
                    .filter(word -> word.contentEquals(
                            new StringBuilder(word).reverse()
                    )).toList();
            System.out.println(list);
        }

        List<String> words = Files.lines(Paths.get("src/stream/files/paragraph.txt")).toList();
        List<String> stringStream = words.stream().flatMap(line ->
                Arrays.stream(line.toLowerCase().split("\\W+"))).toList();
        System.out.println(stringStream.stream().filter(word -> word.contentEquals(new StringBuilder(word).reverse())).toList());
        System.out.println(stringStream.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        ));

    }
}
