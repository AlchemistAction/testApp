package testApp.dto;

import testApp.model.Address;
import testApp.model.Phone;
import testApp.model.Status;

import java.util.List;
import java.util.Objects;

public class AddEmployeeDtoRequest {

    private String firstName;
    private String lastName;
    private String patronymic;
    private Address address;
    private List<Phone> phones;
    private List<Status> statuses;

    public AddEmployeeDtoRequest(String firstName, String lastName, String patronymic, Address address,
                                 List<Phone> phones, List<Status> statuses) {
        setFirstName(firstName);
        setLastName(lastName);
        setPatronymic(patronymic);
        setAddress(address);
        setPhones(phones);
        setStatuses(statuses);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null)
            throw new RuntimeException("First name can't be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null)
            throw new RuntimeException("Last name can't be null");
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
        if (address.getCountry() == null && address.getCity() == null)
            throw new RuntimeException("Address can't be null");
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        if (phones.size() == 0)
            throw new RuntimeException("At least one telephone expected");
        this.phones = phones;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddEmployeeDtoRequest that = (AddEmployeeDtoRequest) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(patronymic, that.patronymic) && Objects.equals(address, that.address) && Objects.equals(phones, that.phones) && Objects.equals(statuses, that.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, address, phones, statuses);
    }
}
