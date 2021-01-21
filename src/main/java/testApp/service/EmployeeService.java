package testApp.service;

import testApp.dao.EmployeeDao;
import testApp.dto.*;
import testApp.model.Employee;
import testApp.model.Phone;
import testApp.model.Status;

import java.time.LocalDate;
import java.util.List;

public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public ReturnEmployeeDtoResponse addEmployee(AddEmployeeDtoRequest employeeDto) {
        System.out.println("Service: Adding new Employee " + employeeDto.getFirstName() + " " + employeeDto.getLastName());
        Employee employee = new Employee(employeeDto);
        try {
            employee = employeeDao.insert(employee);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Service: Employee added with id: " + employee.getId());
        return new ReturnEmployeeDtoResponse(employee);
    }

    public void deleteEmployee(int id) {
        System.out.println("Service: Deleting Employee with id: " + id);
        employeeDao.delete(id);
        System.out.println("Service: Deleted Employee with id: " + id);
    }

    public ReturnEmployeeDtoResponse addStatus(AddStatusDtoRequest addStatusDtoRequest) {
        System.out.println("Service: Adding new status to Employee with id " + addStatusDtoRequest.getId());
        Employee employee = employeeDao.getById(addStatusDtoRequest.getId());

        List<Status> list = employee.getStatuses();
        list.add(addStatusDtoRequest.getStatus());
        employee.setStatuses(list);

        employee.setChangeDate(LocalDate.now());

        employee = employeeDao.addStatus(employee);
        System.out.println("Service: New status added to Employee with id: " + employee.getId());
        return new ReturnEmployeeDtoResponse(employee);
    }

    public ReturnEmployeeDtoResponse updateEmployee(UpdateEmployeeDtoRequest updateEmployeeDtoRequest) {
        System.out.println("Service: Updating Employee with id " + updateEmployeeDtoRequest.getId());
        Employee employee = employeeDao.getById(updateEmployeeDtoRequest.getId());

        if (updateEmployeeDtoRequest.getFirstName() != null) {
            employee.setFirstName(updateEmployeeDtoRequest.getFirstName());
        }
        if (updateEmployeeDtoRequest.getLastName() != null) {
            employee.setLastName(updateEmployeeDtoRequest.getLastName());
        }
        if (updateEmployeeDtoRequest.getPatronymic() != null) {
            employee.setPatronymic(updateEmployeeDtoRequest.getPatronymic());
        }

        employee.setChangeDate(LocalDate.now());

        employee = employeeDao.updateName(employee);
        System.out.println("Service: Updated name of Employee with id: " + employee.getId());
        return new ReturnEmployeeDtoResponse(employee);
    }

    public ReturnEmployeeDtoResponse changeAddress(ChangeAddressDtoRequest changeAddressDtoRequest) {
        System.out.println("Service: Changing address of Employee with id " + changeAddressDtoRequest.getId());
        Employee employee = employeeDao.getById(changeAddressDtoRequest.getId());

        employee.setAddress(changeAddressDtoRequest.getAddress());
        employee.setChangeDate(LocalDate.now());

        employee = employeeDao.changeAddress(employee);
        System.out.println("Service: Address changed of Employee with id: " + employee.getId());
        return new ReturnEmployeeDtoResponse(employee);
    }

    public ReturnEmployeeDtoResponse addPhone(UpdatePhoneDtoRequest updatePhoneDtoRequest) {
        System.out.println("Service: Adding phone to Employee with id " + updatePhoneDtoRequest.getId());
        Employee employee = employeeDao.getById(updatePhoneDtoRequest.getId());

        List<Phone> list = employee.getPhones();
        list.add(updatePhoneDtoRequest.getPhone());
        employee.setPhones(list);

        employee.setChangeDate(LocalDate.now());

        employee = employeeDao.addPhone(employee);
        System.out.println("Service: Phone added to Employee with id: " + employee.getId());
        return new ReturnEmployeeDtoResponse(employee);
    }

    public ReturnEmployeeDtoResponse deletePhone(UpdatePhoneDtoRequest updatePhoneDtoRequest) {
        System.out.println("Service: Deleting phone from Employee with id " + updatePhoneDtoRequest.getId());
        Employee employee = employeeDao.getById(updatePhoneDtoRequest.getId());

        List<Phone> list = employee.getPhones();
        if (list.size() == 1) {
            throw new RuntimeException("can't delete last phone");
        }
        list.remove(updatePhoneDtoRequest.getPhone());
        employee.setPhones(list);

        employee.setChangeDate(LocalDate.now());

        employee = employeeDao.removePhone(employee);
        System.out.println("Service: Phone deleted from Employee with id: " + employee.getId());
        return new ReturnEmployeeDtoResponse(employee);
    }

    public void clearDataBase() {
        employeeDao.clearDataBase();
    }
}
