--For invest user and invest servive and its scheme
CREATE USER invest_db_admin WITH PASSWORD 'invest_db_admin';
GRANT CONNECT ON DATABASE public TO invest_db_admin;
CREATE SCHEMA invest_schema;

GRANT USAGE ON SCHEMA invest_schema TO invest_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA invest_schema TO invest_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA invest_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO invest_db_admin;


CREATE TABLE invest_schema.login_audit (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    userId VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    result VARCHAR(32) NOT NULL
);
