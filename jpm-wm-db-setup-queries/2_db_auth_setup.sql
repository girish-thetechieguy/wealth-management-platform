
--For auth user and auth servive and its scheme

CREATE USER auth_db_admin WITH PASSWORD 'auth_db_admin';
GRANT CONNECT ON DATABASE public TO auth_db_admin;
CREATE SCHEMA auth_schema;

GRANT USAGE ON SCHEMA auth_schema TO auth_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA auth_schema TO auth_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA auth_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO auth_db_admin;


CREATE TABLE auth_schema.login_audit (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    userId VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(32) NOT NULL
);
