package pro.sky.java.course2.homework_list_set;

public interface IEmployeeService {
        String   printEmployee();
        Employee addEmployee(String lastName, String firstName);
        Employee findEmployee(String lastName, String firstName);
        Employee removeEmployee(String lastName, String firstName);
}
