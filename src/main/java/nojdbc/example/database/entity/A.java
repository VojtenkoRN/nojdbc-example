package nojdbc.example.database.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;
import java.util.UUID;

@RegisterForReflection
public class A {

    private UUID id;
    private String value;
    private Main otoMain;

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

    public Main getOtoMain() {
        return otoMain;
    }

    public void setOtoMain(Main otoMain) {
        this.otoMain = otoMain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(id, a.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "A{" +
              "id=" + id +
              ", value='" + value + '\'' +
              '}';
    }

}
