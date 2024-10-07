package nojdbc.example.database.dao;

import nojdbc.core.annotation.SqlMapper;
import nojdbc.core.annotation.result.Many;
import nojdbc.core.annotation.result.Result;
import nojdbc.core.annotation.result.Results;
import nojdbc.core.annotation.sql.Delete;
import nojdbc.core.annotation.sql.Insert;
import nojdbc.core.annotation.sql.Select;
import nojdbc.core.annotation.sql.Update;
import nojdbc.example.database.entity.C;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SqlMapper
@Results({
      @Result(field = "mtmMain", column = "id",
            many = @Many(clazz = "nojdbc.example.database.dao.MainDao", method = "getByCId"))
})
public interface CDao {

    @Select(value = "SELECT id, value " +
          "FROM c " +
          "WHERE id = #{id}",
          fieldFiller = true)
    Optional<C> getById(UUID id);

    @Select(value = "SELECT c.id, c.value " +
          "FROM c c " +
          "LEFT JOIN mtm_main_c mtm ON c.id = mtm.c_id " +
          "WHERE mtm.main_id = #{mainId}",
          fieldFiller = true)
    Set<C> getByMainId(UUID mainId);

    @Insert("INSERT INTO c (id, value) " +
          "VALUES (#{id}, #{value})")
    void create(UUID id, String value);

    @Update("UPDATE c " +
          "SET value = #{value} " +
          "WHERE id = #{id} ")
    void update(UUID id, String value);

    @Delete("DELETE FROM c WHERE id = ANY(#{cIds})")
    void deleteByIdIn(Collection<UUID> cIds);

}
