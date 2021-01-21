package testApp.dto;

import testApp.model.Address;
import testApp.model.Employee;
import testApp.model.Phone;
import testApp.model.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ReturnEmployeeDtoResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Address address;
    private List<Phone> phones;
    private List<Status> statuses;
    private LocalDate creationDate;
    private LocalDate changeDate;

    public ReturnEmployeeDtoResponse(Employee employee) {
        setId(employee.getId());
        setFirstName(employee.getFirstName());
        setLastName(employee.getLastName());
        setPatronymic(employee.getPatronymic());
        setAddress(employee.getAddress());
        setPhones(employee.getPhones());
        setStatuses(employee.getStatuses());
        setCreationDate(employee.getCreationDate());
        setChangeDate(employee.getChangeDate());
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnEmployeeDtoResponse that = (ReturnEmployeeDtoResponse) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(patronymic, that.patronymic) && Objects.equals(address, that.address) && Objects.equals(phones, that.phones) && Objects.equals(statuses, that.statuses) && Objects.equals(creationDate, that.creationDate) && Objects.equals(changeDate, that.changeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymic, address, phones, statuses, creationDate, changeDate);
    }
}
