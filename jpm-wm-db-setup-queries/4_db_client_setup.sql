--For client user and client servive and its scheme
CREATE USER client_db_admin WITH PASSWORD 'client_db_admin';
GRANT CONNECT ON DATABASE postgres TO client_db_admin;
CREATE SCHEMA client_schema;

GRANT USAGE ON SCHEMA client_schema TO client_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA client_schema TO client_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA client_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO client_db_admin;

CREATE TABLE client_schema.client (
    id SERIAL,
    firstName VARCHAR(128) NOT NULL,
    lastName VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    city VARCHAR(128),
    country VARCHAR(64) NOT NULL,
    phone VARCHAR(16) NOT NULL,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL,
    company VARCHAR(64),
    isVarified BOOLEAN,
    requestRetirement BOOLEAN,
    grantRetirementAccess BOOLEAN,
    requestEducation BOOLEAN,
    grantEducationAccess BOOLEAN,
    requestWealthMgmt BOOLEAN,
    grantWealthMgmt BOOLEAN,
    wealthInverstType VARCHAR(16),
    createdAt date,
    createdBy VARCHAR(128) NOT NULL,
    updatedAt date,
    updatedBy VARCHAR(128) NOT NULL,
    PRIMARY KEY (id, username)  -- Composite primary key
);


CREATE INDEX idx_email ON client (email);
CREATE INDEX idx_firstName ON client (first_name);
CREATE INDEX idx_lastName ON client (last_name);