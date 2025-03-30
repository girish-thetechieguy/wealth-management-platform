--For client user and investment servive and its scheme
CREATE USER client_db_admin WITH PASSWORD 'client_db_admin';
GRANT CONNECT ON DATABASE public TO client_db_admin;
CREATE SCHEMA client_schema;

GRANT USAGE ON SCHEMA client_schema TO client_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA client_schema TO client_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA client_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO client_db_admin;


CREATE TABLE client_schema.login_audit (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    userId VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    result VARCHAR(32) NOT NULL
);