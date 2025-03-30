--For Ai user and AI servive and its scheme
CREATE USER ai_db_admin WITH PASSWORD 'ai_db_admin';
GRANT CONNECT ON DATABASE public TO ai_db_admin;
CREATE SCHEMA ai_schema;

GRANT USAGE ON SCHEMA ai_schema TO ai_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA ai_schema TO ai_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA ai_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO ai_db_admin;
