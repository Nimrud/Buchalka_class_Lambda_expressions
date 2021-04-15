package m03_functional_interfaces;

import m01_basics.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Employee john = new Employee("John", "Kowalsky", 34);
        Employee mary = new Employee("Mary", "Moore", 30);
        Employee jack = new Employee("Jack", "Fruit", 27);
        Employee anna = new Employee("Anna", "Goodwill", 37);
        Employee rudolf = new Employee("Rudolf", "Black", 33);
        Employee chris = new Employee("Chris", "Potato", 29);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(anna);
        employees.add(rudolf);
        employees.add(mary);
        employees.add(chris);
        employees.add(jack);

//        System.out.println("Employees over 30:");
//        for (Employee employee : employees){
//            if (employee.getAge() > 30){
//                System.out.println(employee.getLastName() + ": " + employee.getAge());
//            }
//        }
//        employees.forEach(employee -> {
//            if (employee.getAge() > 30){
//                System.out.println(employee.getLastName() + ": " + employee.getAge());
//            }
//        });

        printEmployeesByAge(employees, "Employees over age of 30:",
                employee -> employee.getAge() > 30);

        // Predykaty mogą być tworzone nie tylko jako lambdy, ale też klasy anonimowe:
        printEmployeesByAge(employees, "Employees younger than 30:", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 30;
            }
        });

        // są też bardziej specyficzne typy Predykatów (int, long, double):
        IntPredicate greaterThan15 = i -> i > 15;
        System.out.println(greaterThan15.test(10));  // sprawdzamy, czy 10 > 15

        // predykaty można łączyć (chaining):
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.and(lessThan100).test(36));
        // oprócz "and", interfejs Predicate zawiera też metody "or", negate", "is equal"

        // Kolejnym interfejsem jest Supplier - on zwraca jakąś wartość
        // Przykład - 5 losowych liczb trzycyfrowych:
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 5; i++){
            System.out.println(randomSupplier.get());
        }

        // Interfejs Function:
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getLastName();
        };

        String lastName = getLastName.apply(employees.get(2));  // zwraca nazwisko trzeciego pracownika
        System.out.println(lastName);

    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition){
        System.out.println(ageText);
        for (Employee employee : employees){
            if (ageCondition.test(employee)){
                System.out.println(employee.getLastName() + ": " + employee.getAge());
            }
        }
    }
}
