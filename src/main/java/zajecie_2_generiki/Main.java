package zajecie_2_generiki;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println(DataCollections.getSurnames()
                .stream()
                .filter(s -> s.length() <= 4)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));

        System.out.println(DataCollections.getSurnames()
                .stream()
                .filter(s -> s.startsWith("B"))
                .collect(Collectors.toList()));

        DataCollections.getSurnames()
                .stream()
                .map(s -> s.substring(0, 3).toLowerCase())
                .distinct()
                .forEach(System.out::print);

        DataCollections.getSurnames()
                .stream()
                .sorted(Comparator.comparing(String::length)
                        .reversed())
                .limit(10)
                .forEach(System.out::println);

        System.out.println(DataCollections.getSurnames()
                .stream()
                .sorted(Comparator.comparing(String::length))
                .limit(20)
                .sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
                .collect(Collectors.toList()));

        System.out.println(DataCollections.getSurnames()
                .stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .filter(s -> s.substring(0, 3)
                        .toLowerCase()
                        .contains("a")).collect(Collectors.toList()));

        System.out.println(DataCollections.getNumbers(10000).stream()
                .filter(number -> number % 2 == 0)
                .count());

        System.out.println(DataCollections.getNumbers(10000).stream()
                .filter(number -> number >= 10000 && number <= 99999)
                .count());

        System.out.println(DataCollections.getNumbers(10000).stream()
        .mapToInt(Integer::intValue)
        .summaryStatistics());

//        System.out.println(DataCollections.getNumbers()
//        .stream()
//        .sorted()
//        .limit());
    }
}
