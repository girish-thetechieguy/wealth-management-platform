--For Notification user and Transaction servive and its scheme
CREATE USER notification_db_admin WITH PASSWORD 'notification_db_admin';
GRANT CONNECT ON DATABASE public TO notification_db_admin;
CREATE SCHEMA notification_schema;

GRANT USAGE ON SCHEMA notification_schema TO notification_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA notification_schema TO notification_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA notification_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO notification_db_admin;


CREATE TABLE notification_schema.login_audit (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    userId VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    result VARCHAR(32) NOT NULL
);