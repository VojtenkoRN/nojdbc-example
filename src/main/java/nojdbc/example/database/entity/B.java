package nojdbc.example.database.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;
import java.util.UUID;

@RegisterForReflection
public class B {

    private UUID id;
    private String value;
    private Main otmMain;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Main getOtmMain() {
        return otmMain;
    }

    public void setOtmMain(Main otmMain) {
        this.otmMain = otmMain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B b = (B) o;
        return Objects.equals(id, b.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "B{" +
              "id=" + id +
              ", value='" + value + '\'' +
              '}';
    }

}
