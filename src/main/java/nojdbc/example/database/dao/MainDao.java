package nojdbc.example.database.dao;

import nojdbc.core.annotation.SqlMapper;
import nojdbc.core.annotation.result.Many;
import nojdbc.core.annotation.result.One;
import nojdbc.core.annotation.result.Result;
import nojdbc.core.annotation.result.Results;
import nojdbc.core.annotation.sql.Delete;
import nojdbc.core.annotation.sql.Insert;
import nojdbc.core.annotation.sql.Select;
import nojdbc.core.annotation.sql.Update;
import nojdbc.example.database.entity.Main;
import nojdbc.example.enums.EnumFieldType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SqlMapper
@Results({
      @Result(field = "otoA", column = "id",
            one = @One(clazz = "nojdbc.example.database.dao.ADao", method = "getByMainId")),
      @Result(field = "otmB", column = "id",
            many = @Many(clazz = "nojdbc.example.database.dao.BDao", method = "getByMainId")),
      @Result(field = "mtmC", column = "id",
            many = @Many(clazz = "nojdbc.example.database.dao.CDao", method = "getByMainId"))
})
public interface MainDao {

    @Select(value = "SELECT id, boolean_field, int_field, long_field, float_field, double_field, string_field, enum_field, timestamp_field, nullable_int_field " +
          "FROM main " +
          "WHERE id = #{id}",
          fieldFiller = true)
    Optional<Main> getById(UUID id);

    @Select(value = "SELECT m.id, m.boolean_field, m.int_field, m.long_field, m.float_field, m.double_field, m.string_field, m.enum_field, m.timestamp_field, m.nullable_int_field " +
          "FROM main m " +
          "LEFT JOIN mtm_main_c mtm ON m.id = mtm.main_id " +
          "WHERE mtm.c_id = #{cId}",
          fieldFiller = true)
    Set<Main> getByCId(UUID cId);

    @Select(value = "SELECT id, boolean_field, int_field, long_field, float_field, double_field, string_field, enum_field, timestamp_field, nullable_int_field " +
          "FROM main")
    Set<Main> getAll();

    @Insert("INSERT INTO main (id, boolean_field, int_field, long_field, float_field, double_field, string_field, enum_field, timestamp_field, nullable_int_field) " +
          "VALUES (#{id}, #{booleanField}, #{intField}, #{longField}, #{floatField}, #{doubleField}, #{stringField}, #{enumField}, #{timestampField}, #{nullableIntField})")
    void create(UUID id, boolean booleanField, int intField, long longField, float floatField, double doubleField, String stringField, EnumFieldType enumField, OffsetDateTime timestampField, Integer nullableIntField);

    @Update("UPDATE main " +
          "SET boolean_field = #{booleanField}, int_field = #{intField}, long_field = #{longField}, float_field = #{floatField}, double_field = #{doubleField}, string_field = #{stringField}, enum_field = #{enumField}, timestamp_field = #{timestampField}, nullable_int_field = #{nullableIntField} " +
          "WHERE id = #{id} ")
    void update(UUID id, boolean booleanField, int intField, long longField, float floatField, double doubleField, String stringField, EnumFieldType enumField, OffsetDateTime timestampField, Integer nullableIntField);

    @Delete("DELETE FROM main WHERE id = ANY(#{mainIds})")
    void deleteByIdIn(Collection<UUID> mainIds);

}
