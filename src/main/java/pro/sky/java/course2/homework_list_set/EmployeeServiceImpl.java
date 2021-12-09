package pro.sky.java.course2.homework_list_set;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * имплементация
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    // Массив, выполняющий роль хранилища для записей о сотрудниках.
    /**
     * Converts the whole ArrayList to a single string
     */
    private final ArrayList<Employee> employees = new ArrayList<>();

    public String printEmployee() {
        return employees.toString();
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

        int index = searchRecord(employee);
        if (index == -1) {
            throw new EmployeeNotFoundException("Employee not found...today");
        } else {
            return employee;
        }
    }

    /**
     * @param fullName сотрудник
     * @return индекс в массиве
     * @throws EmployeeNotFoundException если такой сотрудник отсутствует
     */
    private int searchRecord(Employee fullName) throws EmployeeNotFoundException {
        //поиск индекса
        // Метод возвращает индекс первого вхождения элемента в списке. Если элемента не существует в списке, метод вернет -1
        return employees.indexOf(fullName);
    }

    /**
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться объект, которого удалили
     * @throws EmployeeNotFoundException если такой сотрудник отсутствует
     */
    public Employee removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        int index = searchRecord(employee);
        if (index == -1) {
            throw new EmployeeNotFoundException("Employee not found for deleting");
        } else {
            employees.remove(index); //удаление по индексу
            return employee;
        }
    }
}