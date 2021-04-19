package m04_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .forEach(System.out::println);   // forEach() musi być ostatnią metodą, bo ona nic nie zwraca
                                                 // nazywa się to 'terminal operation'
        // Stream: zestaw odwołań do obiektu
        // obiekt wejściowy nie zostaje w żaden sposób zmieniony przez stream!
        // stream musi być utworzony z obiektów tego samego typu (np. String lub int)

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("------");
        System.out.println(concatStream
                .distinct()                  // distinct() - pomija duplikaty
                .peek(System.out::println)   // peek() pozwala wypisać elementy streamu bez jego przerywania (jak w forEach)
                .count());

        // FLAT MAP
        System.out.println("*** Flat Map ***");
        Employee mary = new Employee("Mary Jane", 37);
        Employee john = new Employee("John Popeye", 52);
        Employee chris = new Employee("Chris Burak", 27);
        Employee adam = new Employee("Adam Potok", 31);

        Department depHR = new Department("Departament HR");
        depHR.addEmployee(mary);
        depHR.addEmployee(john);
        depHR.addEmployee(chris);

        Department depAccounting = new Department("Księgowość");
        depAccounting.addEmployee(adam);

        List<Department> companyDepartments = new ArrayList<>();
        companyDepartments.add(depHR);
        companyDepartments.add(depAccounting);

        companyDepartments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
        // FlatMap() oczekuje funkcji, która zwraca stream
        // w przykładzie powyżej: department.getEmployees() zwraca listę,
        // na której wywołujemy metodę stream()
        // w ten sposób możemy zwrócić obiekty w zagnieżdżonych listach
        // FlatMap - możliwość operacji na listach, ale gdzie te listy nie są bezp. źródłem

        // COLLECT:
        System.out.println("--- Collect method ---");
        // Metoda collect() - zbiera elementy w stream, przekształca w inny rodzaj wyniku (np. w listę)
        List<String> sortedGNumbers = bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());
        // wynikiem powyższego jest stworzenie listy, z którą możemy pracować dalej

        for (String s : sortedGNumbers){
            System.out.println(s);
        }
    }
}
