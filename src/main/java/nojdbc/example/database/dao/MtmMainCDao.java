package nojdbc.example.database.dao;

import nojdbc.core.annotation.SqlMapper;
import nojdbc.core.annotation.sql.Insert;

import java.util.UUID;

@SqlMapper
public interface MtmMainCDao {

    @Insert("INSERT INTO mtm_main_c (main_id, c_id) " +
          "VALUES (#{mainId}, #{cId})")
    void create(UUID mainId, UUID cId);

}
