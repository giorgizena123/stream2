import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        // ამოცანა 2: სახელები A-ზე
        List<Employee> aEmployees = employeeList.stream()
                .filter(employee -> employee.getFirstName().startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("თანამშრომლები, რომელთა სახელები იწყება A-ზე:");
        aEmployees.forEach(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName()));

        // ამოცანა 3: 2023 წელს დამატებული თანამშრომლები
        List<Employee> year2023Employees = employeeList.stream()
                .filter(employee -> employee.getId().startsWith("2023"))
                .collect(Collectors.toList());

        System.out.println("\n2023 წელს დამატებული თანამშრომლები:");
        year2023Employees.forEach(System.out::println);

        // ამოცანა 4: სორტირება
        employeeList.sort(Comparator.comparing(Employee::getFirstName).thenComparingInt(Employee::getSalary));
        System.out.println("\nდასორტირებული თანამშრომლები:");
        employeeList.forEach(System.out::println);
    }
}
