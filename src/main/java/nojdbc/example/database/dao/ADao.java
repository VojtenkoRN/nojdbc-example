package nojdbc.example.database.dao;

import nojdbc.core.annotation.SqlMapper;
import nojdbc.core.annotation.result.One;
import nojdbc.core.annotation.result.Result;
import nojdbc.core.annotation.result.Results;
import nojdbc.core.annotation.sql.Delete;
import nojdbc.core.annotation.sql.Insert;
import nojdbc.core.annotation.sql.Select;
import nojdbc.core.annotation.sql.Update;
import nojdbc.example.database.entity.A;
import nojdbc.example.database.entity.Main;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@SqlMapper
@Results(value = {
      @Result(field = "otoMain", column = "oto_main",
            one = @One(clazz = "nojdbc.example.database.dao.MainDao", method = "getById"))
})
public interface ADao {

    @Select(value = "SELECT id, value, oto_main " +
          "FROM a " +
          "WHERE id = #{id}",
          fieldFiller = true)
    Optional<A> getById(UUID id);

    @Select(value = "SELECT id, value, oto_main " +
          "FROM a " +
          "WHERE oto_main = #{mainId}",
          fieldFiller = true)
    Optional<A> getByMainId(UUID mainId);

    @Insert("INSERT INTO a (id, value, oto_main) " +
          "VALUES (#{id}, #{value}, #{otoMainId})")
    void create(UUID id, String value, UUID otoMainId);

    @Update("UPDATE a " +
          "SET value = #{value}, oto_main = #{main.getId()} " +
          "WHERE id = #{id} ")
    void update(UUID id, String value, Main main);

    @Delete("DELETE FROM a WHERE id = ANY(#{aIds})")
    void deleteByIdIn(Collection<UUID> aIds);

}
