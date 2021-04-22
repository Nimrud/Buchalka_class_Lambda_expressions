package m07_challenge3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // CHALLENGE 3a
        // write the code to print the list in sorted order
        // and with the first letter in each name upper-cased ('harry' should be printed as 'Harry')
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        // rozwiązanie:
        topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        // rozwiązanie Buchalki:
        System.out.println("** Rozwiązanie Buchalki **");
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        firstUpperCaseList.forEach(s -> System.out.println(s));

        // CHALLENGE 3b
        // instead of printing out sorted names, print out how many names begin with letter "A"
        System.out.println("----------");
        String startingLetter = "A";
        long namesStartingWith = topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .filter(s -> s.startsWith(startingLetter))
                .count();
        System.out.println("Number of names beginning with " + startingLetter + ": " + namesStartingWith);
    }
}
