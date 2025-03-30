--For advisor user and advisor servive and its scheme
CREATE USER advisor_db_admin WITH PASSWORD 'advisor_db_admin';
GRANT CONNECT ON DATABASE public TO advisor_db_admin;
CREATE SCHEMA advisor_schema;

GRANT USAGE ON SCHEMA advisor_schema TO advisor_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA advisor_schema TO advisor_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA advisor_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO advisor_db_admin;


CREATE TABLE advisor_schema.login_audit (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    userId VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    result VARCHAR(32) NOT NULL
);