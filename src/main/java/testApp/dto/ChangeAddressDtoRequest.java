package testApp.dto;

import testApp.model.Address;

import java.util.Objects;

public class ChangeAddressDtoRequest {

    private int id;
    private Address address;

    public ChangeAddressDtoRequest(int id, Address address) {
        this.id = id;
        setAddress(address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address.getCountry() == null && address.getCity() == null)
            throw new RuntimeException("Address can't be null");
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeAddressDtoRequest that = (ChangeAddressDtoRequest) o;
        return id == that.id && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }
}
