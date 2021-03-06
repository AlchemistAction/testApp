package testApp.dto;

import testApp.model.Status;

import java.util.Objects;

public class AddStatusDtoRequest {

    private int id;
    private Status status;

    public AddStatusDtoRequest(int id, Status status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddStatusDtoRequest that = (AddStatusDtoRequest) o;
        return id == that.id && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
