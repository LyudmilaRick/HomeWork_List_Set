package pro.sky.java.course2.homework_list_set;

import java.util.Collection;

public interface EmployeeService {
        Collection<Employee> getEmployee();
        Employee addEmployee(String lastName, String firstName);
        Employee findEmployee(String lastName, String firstName);
        Employee removeEmployee(String lastName, String firstName);
}
