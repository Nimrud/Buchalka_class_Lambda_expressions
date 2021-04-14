package m03_functional_interfaces;

import m01_basics.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

        printEmployeesByAge(employees, "Employees over age of 30",
                employee -> employee.getAge() > 30);
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
