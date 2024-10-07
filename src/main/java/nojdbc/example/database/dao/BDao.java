package nojdbc.example.database.dao;

import nojdbc.core.annotation.SqlMapper;
import nojdbc.core.annotation.result.One;
import nojdbc.core.annotation.result.Result;
import nojdbc.core.annotation.result.Results;
import nojdbc.core.annotation.sql.Delete;
import nojdbc.core.annotation.sql.Insert;
import nojdbc.core.annotation.sql.Select;
import nojdbc.core.annotation.sql.Update;
import nojdbc.example.database.entity.B;
import nojdbc.example.database.entity.Main;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SqlMapper
@Results(value = {
      @Result(field = "otoMain", column = "otm_main",
            one = @One(clazz = "nojdbc.example.database.dao.MainDao", method = "getById"))
})
public interface BDao {

    @Select(value = "SELECT id, value, otm_main " +
          "FROM b " +
          "WHERE id = #{id}",
          fieldFiller = true)
    Optional<B> getById(UUID id);

    @Select(value = "SELECT id, value, otm_main " +
          "FROM b " +
          "WHERE otm_main = #{mainId}",
          fieldFiller = true)
    Set<B> getByMainId(UUID mainId);

    @Insert("INSERT INTO b (id, value, otm_main) " +
          "VALUES (#{id}, #{value}, #{otmMainId})")
    void create(UUID id, String value, UUID otmMainId);

    @Update("UPDATE b " +
          "SET value = #{value}, otm_main = #{main.getId()} " +
          "WHERE id = #{id} ")
    void update(UUID id, String value, Main main);

    @Delete("DELETE FROM b WHERE id = ANY(#{bIds})")
    void deleteByIdIn(Collection<UUID> bIds);

}
