\connect nojdbc;
DROP SCHEMA IF EXISTS nojdbc_local CASCADE;
CREATE SCHEMA nojdbc_local;
ALTER SCHEMA nojdbc_local OWNER TO nojdbc_user;
ALTER DATABASE nojdbc SET search_path TO nojdbc_local;