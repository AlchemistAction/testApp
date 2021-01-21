package testApp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testApp.dao.EmployeeDaoImpl;
import testApp.dto.*;
import testApp.model.Address;
import testApp.model.Employee;
import testApp.model.Phone;
import testApp.model.Status;

import java.util.ArrayList;
import java.util.List;

class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService(new EmployeeDaoImpl());

    @BeforeEach
    public void setUp() {
        employeeService.clearDataBase();
    }

    @Test
    void testAddEmployee() {
        AddEmployeeDtoRequest addEmployeeDtoRequest = createEmployeeDto();

        ReturnEmployeeDtoResponse response = employeeService.addEmployee(addEmployeeDtoRequest);

        Employee employee = new Employee(addEmployeeDtoRequest);
        employee.setId(0);

        checkFields(employee, response);
    }

    @Test
    void testAddEmployeeFail() {
        AddEmployeeDtoRequest addEmployeeDtoRequest = createEmployeeDto();
        try {
            addEmployeeDtoRequest.setFirstName(null);
        } catch (RuntimeException e) {
            Assertions.assertEquals("First name can't be null", e.getMessage());
        }
    }

    @Test
    void testDeleteEmployee() {
        AddEmployeeDtoRequest addEmployeeDtoRequest = createEmployeeDto();

        employeeService.addEmployee(addEmployeeDtoRequest);

        Employee employee = new Employee(addEmployeeDtoRequest);
        employee.setId(0);

        employeeService.deleteEmployee(employee.getId());
    }

    @Test
    void testAddStatus() {
        AddEmployeeDtoRequest addEmployeeDtoRequest = createEmployeeDto();

        employeeService.addEmployee(addEmployeeDtoRequest);

        Employee employee = new Employee(addEmployeeDtoRequest);
        employee.setId(0);
        employee.getStatuses().add(Status.IN_ARCHIVE);

        AddStatusDtoRequest addStatusDtoRequest = new AddStatusDtoRequest(0, Status.IN_ARCHIVE);

        ReturnEmployeeDtoResponse response = employeeService.addStatus(addStatusDtoRequest);
        checkFields(employee, response);
    }

    @Test
    void testUpdateEmployee() {
        AddEmployeeDtoRequest addEmployeeDtoRequest = createEmployeeDto();

        employeeService.addEmployee(addEmployeeDtoRequest);

        Employee employee = new Employee(addEmployeeDtoRequest);
        employee.setId(0);
        employee.setLastName("newLastName");

        UpdateEmployeeDtoRequest updateEmployeeDtoRequest = new UpdateEmployeeDtoRequest(employee);
        ReturnEmployeeDtoResponse response = employeeService.updateEmployee(updateEmployeeDtoRequest);
        checkFields(employee, response);
    }

    @Test
    void testChangeAddress() {
        AddEmployeeDtoRequest addEmployeeDtoRequest = createEmployeeDto();

        employeeService.addEmployee(addEmployeeDtoRequest);

        Employee employee = new Employee(addEmployeeDtoRequest);
        employee.setId(0);
        employee.setAddress(new Address("newCountry", "region", "city", "street", 3));

        ChangeAddressDtoRequest changeAddressDtoRequest = new ChangeAddressDtoRequest(employee.getId(), employee.getAddress());
        ReturnEmployeeDtoResponse response = employeeService.changeAddress(changeAddressDtoRequest);
        checkFields(employee, response);
    }

    @Test
    void testAddPhone() {
        AddEmployeeDtoRequest addEmployeeDtoRequest = createEmployeeDto();

        employeeService.addEmployee(addEmployeeDtoRequest);

        Employee employee = new Employee(addEmployeeDtoRequest);
        employee.setId(0);
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(1, 1, 1));
        phones.add(new Phone(2, 2, 2));
        employee.setPhones(phones);

        UpdatePhoneDtoRequest updatePhoneDtoRequest = new UpdatePhoneDtoRequest(employee.getId(),
                employee.getPhones().get(1));
        ReturnEmployeeDtoResponse response = employeeService.addPhone(updatePhoneDtoRequest);
        checkFields(employee, response);
    }

    @Test
    void testDeletePhone() {
        AddEmployeeDtoRequest addEmployeeDtoRequest = createEmployeeDto();

        employeeService.addEmployee(addEmployeeDtoRequest);

        Employee employee = new Employee(addEmployeeDtoRequest);
        employee.setId(0);
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(1, 1, 1));
        phones.add(new Phone(2, 2, 2));
        employee.setPhones(phones);

        UpdatePhoneDtoRequest updatePhoneDtoRequest = new UpdatePhoneDtoRequest(employee.getId(),
                employee.getPhones().get(1));
        employeeService.addPhone(updatePhoneDtoRequest);

        employee.getPhones().remove(phones.get(1));

        ReturnEmployeeDtoResponse response = employeeService.deletePhone(updatePhoneDtoRequest);
        checkFields(employee, response);
    }

    private void checkFields(Employee employee, ReturnEmployeeDtoResponse response) {
        Assertions.assertEquals(employee.getId(), response.getId());
        Assertions.assertEquals(employee.getFirstName(), response.getFirstName());
        Assertions.assertEquals(employee.getLastName(), response.getLastName());
        Assertions.assertEquals(employee.getPatronymic(), response.getPatronymic());
        Assertions.assertEquals(employee.getAddress(), response.getAddress());
        Assertions.assertEquals(employee.getPhones(), response.getPhones());
        Assertions.assertEquals(employee.getStatuses(), response.getStatuses());
        Assertions.assertEquals(employee.getCreationDate(), response.getCreationDate());
        Assertions.assertEquals(employee.getChangeDate(), response.getChangeDate());
    }

    private AddEmployeeDtoRequest createEmployeeDto() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(1, 1, 1));
        List<Status> statuses = new ArrayList<>();
        statuses.add(Status.ACTIVE);

        return new AddEmployeeDtoRequest("firstName",
                "lastName", "patronymic",
                new Address("country", "region", "city", "street", 3),
                phones, statuses);
    }
}