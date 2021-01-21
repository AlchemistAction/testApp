package testApp.dto;

import testApp.model.Phone;

import java.util.Objects;

public class UpdatePhoneDtoRequest {

    private int id;
    private Phone phone;

    public UpdatePhoneDtoRequest(int id, Phone phone) {
        this.id = id;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdatePhoneDtoRequest that = (UpdatePhoneDtoRequest) o;
        return id == that.id && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone);
    }
}
