package pro.sky.java.course2.homework_list_set;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * имплементация
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    // Массив, выполняющий роль хранилища для записей о сотрудниках.
    /**
     * Converts the whole ArrayList to a single string
     */
    private final List<Employee> employees = new ArrayList<>();

    public Collection<Employee> getEmployee() {
        return  employees;
    }

    /**
     * метод добавления сотрудника
     *
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться добавленный объект
     */
    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employees.add(employee);
        return employee;
    }

    /**
     * поиск сотрудника по имени и фвмилии
     *
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться объект !!! ( согласно ДЗ )
     * @throws EmployeeNotFoundException не найден сотрудник
     */
    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        int index = employees.indexOf(employee);
        if (index == -1) {
            throw new EmployeeNotFoundException("Employee not found...today");
        } else {
            return employee;
        }
    }

    /**
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться объект, которого удалили
     * @throws EmployeeNotFoundException если такой сотрудник отсутствует
     */
    public Employee removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        int index = employees.indexOf(employee);
        if (index == -1) {
            throw new EmployeeNotFoundException("Employee not found for deleting");
        }
        return employee;
    }
}