--For wealth user and wealth mgmt servive and its scheme
CREATE USER wealth_db_admin WITH PASSWORD 'wealth_db_admin';
GRANT CONNECT ON DATABASE public TO wealth_db_admin;
CREATE SCHEMA wealth_schema;

GRANT USAGE ON SCHEMA wealth_schema TO wealth_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA wealth_schema TO wealth_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA wealth_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO wealth_db_admin;



