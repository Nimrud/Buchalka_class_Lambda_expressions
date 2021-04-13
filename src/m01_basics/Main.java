package m01_basics;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // lambda - używana w przypadku interfejsów z 1 metodą
        new Thread(() -> System.out.println("Printing message")).start();
        // wyrażenie lambda ma 3 części:
        // 1) lista argumentów (powyżej: pusta)
        // 2) strzałka
        // 3) ciało funkcji

//        new Thread(() -> {
//            System.out.println("Line 1");
//            System.out.println("Line 2");
//            System.out.println("Line 3");
//        }).start();

        Employee john = new Employee("John", "Kowalsky", 34);
        Employee mary = new Employee("Mary", "Moore", 38);
        Employee jack = new Employee("Jack", "Fruit", 27);
        Employee rudolf = new Employee("Rudolf", "Black", 33);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(rudolf);
        employees.add(mary);
        employees.add(jack);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));
        // lambda powyżej jest drugim parametrem metody sort()

        // 2 METODY ITERACJI:
        // enhanced for loop:
        for (Employee employee : employees){
            System.out.println(employee.getName());
        }

        // foreach():
        employees.forEach(employee -> {
            System.out.println(employee.getLastName() + ": " + employee.getAge());
        });

//        String namesString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println("2 names String: " + namesString);

        UpperConcat upperConcat = ((s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
        String namesString = doStringStuff(upperConcat, employees.get(0).getName(),
                employees.get(1).getName());
        System.out.println("2 names String: " + namesString);

        // lambdy mogą być bardziej rozbudowane, wtedy trzeba użyć return:
        UpperConcat lc = (s1, s2) -> {
            String result = s1.toLowerCase() + s2.toLowerCase();
            return result;
        };
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}