--For Transaction user and Transaction servive and its scheme
CREATE USER transaction_user WITH PASSWORD 'transaction_user';
GRANT CONNECT ON DATABASE public TO transaction_user;
CREATE SCHEMA transaction_schema;

GRANT USAGE ON SCHEMA transaction_schema TO transaction_user;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA transaction_schema TO transaction_user;

ALTER DEFAULT PRIVILEGES IN SCHEMA transaction_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO transaction_user;


CREATE TABLE transaction_schema.login_audit (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    userId VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    logintime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    result VARCHAR(32) NOT NULL
);