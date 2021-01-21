package testApp.model;

import testApp.dto.AddEmployeeDtoRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Address address;
    private List<Phone> phones;
    private List<Status> statuses;
    private LocalDate creationDate;
    private LocalDate changeDate;

    public Employee(AddEmployeeDtoRequest employeeDto) {
        setId(0);
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.patronymic = employeeDto.getPatronymic();
        this.address = employeeDto.getAddress();
        this.phones = employeeDto.getPhones();
        this.statuses = employeeDto.getStatuses();
        setCreationDate(LocalDate.now());
        setChangeDate(LocalDate.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName) && Objects.equals(patronymic, employee.patronymic)
                && Objects.equals(address, employee.address) && Objects.equals(phones, employee.phones)
                && Objects.equals(statuses, employee.statuses) && Objects.equals(creationDate, employee.creationDate)
                && Objects.equals(changeDate, employee.changeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymic, address, phones, statuses, creationDate, changeDate);
    }
}
