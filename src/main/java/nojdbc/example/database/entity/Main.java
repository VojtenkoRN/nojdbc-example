package nojdbc.example.database.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import nojdbc.example.enums.EnumFieldType;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@RegisterForReflection
public class Main {

    private UUID id;
    private boolean booleanField;
    private int intField;
    private long longField;
    private float floatField;
    private double doubleField;
    private String stringField;
    private EnumFieldType enumField;
    private OffsetDateTime timestampField;
    private Integer nullableIntField;
    private A otoA;
    private Set<B> otmB;
    private Set<C> mtmC;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isBooleanField() {
        return booleanField;
    }

    public void setBooleanField(boolean booleanField) {
        this.booleanField = booleanField;
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    public long getLongField() {
        return longField;
    }

    public void setLongField(long longField) {
        this.longField = longField;
    }

    public float getFloatField() {
        return floatField;
    }

    public void setFloatField(float floatField) {
        this.floatField = floatField;
    }

    public double getDoubleField() {
        return doubleField;
    }

    public void setDoubleField(double doubleField) {
        this.doubleField = doubleField;
    }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public EnumFieldType getEnumField() {
        return enumField;
    }

    public void setEnumField(EnumFieldType enumField) {
        this.enumField = enumField;
    }

    public OffsetDateTime getTimestampField() {
        return timestampField;
    }

    public void setTimestampField(OffsetDateTime timestampField) {
        this.timestampField = timestampField;
    }

    public Integer getNullableIntField() {
        return nullableIntField;
    }

    public void setNullableIntField(Integer nullableIntField) {
        this.nullableIntField = nullableIntField;
    }

    public A getOtoA() {
        return otoA;
    }

    public void setOtoA(A otoA) {
        this.otoA = otoA;
    }

    public Set<B> getOtmB() {
        return otmB;
    }

    public void setOtmB(Set<B> otmB) {
        this.otmB = otmB;
    }

    public Set<C> getMtmC() {
        return mtmC;
    }

    public void setMtmC(Set<C> mtmC) {
        this.mtmC = mtmC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return Objects.equals(id, main.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Main{" +
              "id=" + id +
              ", booleanField=" + booleanField +
              ", intField=" + intField +
              ", longField=" + longField +
              ", floatField=" + floatField +
              ", doubleField=" + doubleField +
              ", stringField='" + stringField + '\'' +
              ", enumField=" + enumField +
              ", timestampField=" + timestampField +
              ", nullableIntField=" + nullableIntField +
              ", otoA=" + otoA +
              ", otmB=" + otmB +
              ", mtmC=" + mtmC +
              '}';
    }

}
