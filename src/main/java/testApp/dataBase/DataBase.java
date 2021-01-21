package testApp.dataBase;

import testApp.model.Employee;

import java.util.HashSet;
import java.util.Set;

public class DataBase {

    private static DataBase instance;
    private final Set<Employee> set;
    private static int id = 0;

    private DataBase() {
        this.set = new HashSet<>();
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public Employee getById(int id) {
        return set.stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("There is no Employee with id " + id));
    }

    public Employee insert(Employee employee) {
        employee.setId(id);
        id++;
        set.add(employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        set.removeIf(e -> e.getId() == employee.getId());
        set.add(employee);
        return employee;
    }

    public void delete(int id) {
        set.removeIf(e -> e.getId() == id);
    }

    public void clearDataBase() {
        set.clear();
        id = 0;
    }
}
