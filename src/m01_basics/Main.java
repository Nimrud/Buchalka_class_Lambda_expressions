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
        new Thread(() -> {
            System.out.println("Line 1");
            System.out.println("Line 2");
            System.out.println("Line 3");
        }).start();

        Employee john = new Employee("John", "Kowalsky", 34);
        Employee mary = new Employee("Mary", "Moore", 38);
        Employee jack = new Employee("Jack", "Fruit", 27);
        Employee rudolf = new Employee("Rudolf", "Black", 33);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(rudolf);
        employees.add(mary);
        employees.add(jack);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        for (Employee employee : employees){
            System.out.println(employee.getName());
        }
    }
}
