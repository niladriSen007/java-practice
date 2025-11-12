package stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPlaylist {
    public static void main(String[] args) {

        //find the largest word in the sentence
        String sentence = "Hi!! i@ am Niladri";
        System.out.println(Arrays.stream(sentence.toLowerCase()
                        .replaceAll("[^a-z\\s]", "")
                        .split(" ")).
                max(Comparator.comparingInt(String::length)));


        //remove duplicates from string and return in the same order
        // i/p - "dabcadefg"
        //o/p - "dabcefg"
        String random = "dabcadefg";
        //approach 1
        System.out.println(Arrays.stream(random.split(""))
                .distinct()
                .toList()
                .stream()
                .collect(Collectors.joining("")));
        //approach 2
        System.out.println(String.join("", Arrays.stream(random.split(""))
                .distinct()
                .toList()));
        //approach 3
        System.out.println(random.chars().distinct()
                .mapToObj(ch -> (char) ch)
                .map(x -> x.toString())
                .collect(Collectors.joining("")));


        //find the second-longest word in a sentence
        String para = "I am learning java Stream api";
        String[] s1 = para.toLowerCase()
                .replaceAll("[^a-z\\s]", "")
                .split(" ");
        System.out.println(Arrays.stream(s1)
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1).findFirst());

        // find the second-longest word length in a sentence
        System.out.println(Arrays.stream(s1)
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1).findFirst().get().length());


        //find occurance of each word
        String freq = "I am Niladri and I am a great person";
        System.out.println(Arrays.stream(freq.toLowerCase()
                .replaceAll("[^a-z\\s]", "")
                .split(" ")).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        )));


        //find the words containing 2 vowels
        String cont = "I am Niladri and I am a great person";
        System.out.println(String.join(",", Arrays.stream(cont.toLowerCase().split(" ")).filter(
                elem -> elem.replaceAll("[^aeiou]", "").length() == 2
        ).toList()));


        // divide list of integers into two lists even and odd
        int[] arr = {1, 2, 3, 43, 4, 5, 566, 7};
        //o/p - [[2, 4, 566], [1, 3, 43, 5, 7]]
//        List<Integer> arr = Arrays.asList(1, 2, 3, 43, 4, 5, 566, 7);
        System.out.println(Arrays.stream(arr).boxed().
                toList()
                .stream()
                .collect(Collectors
                        .groupingBy(elem -> elem % 2 == 0 ? "Even" : "Odd"))
                .entrySet().stream().map(elem -> elem.getValue()).toList());


        //find occurance of each character in a string
        String text = "mississippi";
        System.out.println(Arrays.stream(text.split("")).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        )));


        //given an array, rearrange the elements to form highest and lowest value
        int[] a = {1, 2, 3, 4, 5};
        Arrays.stream(a).mapToObj(x -> x).sorted().forEach(System.out::print);
        System.out.println();
        Arrays.stream(a).mapToObj(x -> x).sorted(Collections.reverseOrder()).forEach(System.out::print);
        System.out.println();


        //find sum of all the unique elements of an array
        List<Integer> l = Arrays.asList(1, 6, 7, 8, 1, 1, 8, 8, 7);
        System.out.println(l.stream().distinct().reduce(0, (a1, b) -> a1 + b));
        int[] elem = {1, 6, 7, 8, 1, 1, 8, 8, 7};
        System.out.println(Arrays.stream(elem).distinct().sum());

    }
}
