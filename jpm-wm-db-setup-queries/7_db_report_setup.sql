--For report user and report servive and its scheme
CREATE USER report_db_admin WITH PASSWORD 'report_db_admin';
GRANT CONNECT ON DATABASE public TO report_db_admin;
CREATE SCHEMA report_schema;

GRANT USAGE ON SCHEMA report_schema TO report_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA report_schema TO report_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA report_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO report_db_admin;


CREATE TABLE report_schema.login_audit (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    userId VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    result VARCHAR(32) NOT NULL
);