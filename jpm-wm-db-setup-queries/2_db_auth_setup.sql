
--For auth user and auth servive and its scheme

CREATE USER auth_db_admin WITH PASSWORD 'auth_db_admin';
GRANT CONNECT ON DATABASE public TO auth_db_admin;
CREATE SCHEMA auth_schema;

GRANT USAGE ON SCHEMA auth_schema TO auth_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA auth_schema TO auth_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA auth_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO auth_db_admin;


CREATE SCHEMA IF NOT EXISTS auth_schema;

CREATE TABLE IF NOT EXISTS auth_schema.login_audit (
    id SERIAL PRIMARY KEY,
    username VARCHAR(256) NOT NULL REFERENCES auth_schema.client(username),  -- Assuming 'client' table exists with 'id' as PK
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL,
    status VARCHAR(32) NOT NULL
);
