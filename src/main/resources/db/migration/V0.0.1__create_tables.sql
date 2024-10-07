CREATE TABLE main
(
    id                 UUID             NOT NULL PRIMARY KEY,
    boolean_field      BOOLEAN          NOT NULL,
    int_field          INT              NOT NULL,
    long_field         BIGINT           NOT NULL,
    float_field        DOUBLE PRECISION NOT NULL,
    double_field       DOUBLE PRECISION NOT NULL,
    string_field       VARCHAR,
    enum_field         VARCHAR(128)     NOT NULL,
    timestamp_field    TIMESTAMPTZ      NOT NULL,
    nullable_int_field INT
);

ALTER TABLE main
    OWNER TO nojdbc_user;

CREATE TABLE a
(
    id       UUID                      NOT NULL PRIMARY KEY,
    value    VARCHAR,
    oto_main UUID REFERENCES main (id) NOT NULL
);

ALTER TABLE a
    OWNER TO nojdbc_user;

CREATE TABLE b
(
    id       UUID                      NOT NULL PRIMARY KEY,
    value    VARCHAR,
    otm_main UUID REFERENCES main (id) NOT NULL
);

ALTER TABLE b
    OWNER TO nojdbc_user;

CREATE TABLE c
(
    id    UUID NOT NULL PRIMARY KEY,
    value VARCHAR
);

ALTER TABLE c
    OWNER TO nojdbc_user;

CREATE TABLE mtm_main_c
(
    main_id UUID REFERENCES main (id) ON DELETE CASCADE,
    c_id    UUID REFERENCES c (id) ON DELETE CASCADE,
    PRIMARY KEY (main_id, c_id)
);

ALTER TABLE mtm_main_c
    OWNER TO nojdbc_user;