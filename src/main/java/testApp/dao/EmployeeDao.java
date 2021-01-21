package testApp.dao;

import testApp.model.Employee;

import java.sql.SQLException;

public interface EmployeeDao {

    Employee getById(int id);

    Employee insert(Employee employee);

    Employee updateName(Employee employee);

    Employee changeAddress(Employee employee);

    void delete(int id);

    Employee addStatus(Employee employee);

    Employee addPhone(Employee employee);
    
    Employee removePhone(Employee employee);

    void clearDataBase();
}
