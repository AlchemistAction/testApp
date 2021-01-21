package testApp.dao;

import testApp.dataBase.DataBase;
import testApp.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Employee getById(int id) {
        System.out.println("DAO: Getting Employee by id: " + id);
        DataBase db = DataBase.getInstance();
        return db.getById(id);
    }

    @Override
    public Employee insert(Employee employee) {
        System.out.println("DAO: Inserting Employee into dataBase: " + employee.toString());
        DataBase db = DataBase.getInstance();
        return db.insert(employee);
    }

    @Override
    public Employee updateName(Employee employee) {
        System.out.println("DAO: Updating Employee " + employee.toString());
        DataBase db = DataBase.getInstance();
        return db.updateEmployee(employee);
    }

    @Override
    public Employee changeAddress(Employee employee) {
        System.out.println("DAO: Changing address of Employee " + employee.toString());
        DataBase db = DataBase.getInstance();
        return db.updateEmployee(employee);
    }

    @Override
    public void delete(int id) {
        System.out.println("DAO: Deleting Employee with id: " + id);
        DataBase db = DataBase.getInstance();
        db.delete(id);
    }

    @Override
    public Employee addStatus(Employee employee) {
        System.out.println("DAO: Adding new status to Employee " + employee.toString());
        DataBase db = DataBase.getInstance();
        return db.updateEmployee(employee);
    }

    @Override
    public Employee addPhone(Employee employee) {
        System.out.println("DAO: Adding phone to Employee " + employee.toString());
        DataBase db = DataBase.getInstance();
        return db.updateEmployee(employee);
    }

    @Override
    public Employee removePhone(Employee employee) {
        System.out.println("DAO: Removing phone to Employee " + employee.toString());
        DataBase db = DataBase.getInstance();
        return db.updateEmployee(employee);
    }

    @Override
    public void clearDataBase() {
        System.out.println("DAO: Clearing dataBase");
        DataBase db = DataBase.getInstance();
        db.clearDataBase();
    }
}
