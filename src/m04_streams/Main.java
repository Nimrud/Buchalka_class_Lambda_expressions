package m04_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B52",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I29", "I44",
                "O15");

//        List<String> gNumbers = new ArrayList<>();
//
//        bingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
//        gNumbers.forEach(s -> System.out.println(s));

        bingoNumbers
                .stream()
                .map(String::toUpperCase)   // method reference
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
        // Stream: zestaw odwołań do obiektu
        // obiekt wejściowy nie zostaje w żaden sposób zmieniony przez stream!

    }
}
