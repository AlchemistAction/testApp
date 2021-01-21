package testApp.dto;

import testApp.model.Employee;

import java.util.Objects;

public class UpdateEmployeeDtoRequest {

    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;

    public UpdateEmployeeDtoRequest(int id, String firstName, String lastName, String patronymic) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public UpdateEmployeeDtoRequest(Employee employee) {
        setId(employee.getId());
        setFirstName(employee.getFirstName());
        setLastName(employee.getLastName());
        setPatronymic(employee.getPatronymic());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateEmployeeDtoRequest that = (UpdateEmployeeDtoRequest) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(patronymic, that.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymic);
    }
}
