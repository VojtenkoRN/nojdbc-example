package nojdbc.example.database.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@RegisterForReflection
public class C {

    private UUID id;
    private String value;
    private Set<Main> mtmMain;

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

    public Set<Main> getMtmMain() {
        return mtmMain;
    }

    public void setMtmMain(Set<Main> mtmMain) {
        this.mtmMain = mtmMain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C c = (C) o;
        return Objects.equals(id, c.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "C{" +
              "id=" + id +
              ", value='" + value + '\'' +
              '}';
    }

}
