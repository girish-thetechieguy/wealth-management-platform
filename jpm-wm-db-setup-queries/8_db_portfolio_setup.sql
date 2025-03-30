--For portfolio user and portfolio servive and its scheme
CREATE USER portfolio_db_admin WITH PASSWORD 'portfolio_db_admin';
GRANT CONNECT ON DATABASE public TO portfolio_db_admin;
CREATE SCHEMA portfolio_schema;

GRANT USAGE ON SCHEMA portfolio_schema TO portfolio_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA portfolio_schema TO portfolio_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA portfolio_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO portfolio_db_admin;


CREATE TABLE portfolio_schema.login_audit (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    userId VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    result VARCHAR(32) NOT NULL
);