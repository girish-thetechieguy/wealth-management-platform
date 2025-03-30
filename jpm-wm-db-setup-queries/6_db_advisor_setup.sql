--For advisor user and advisor servive and its scheme
CREATE USER advisor_db_admin WITH PASSWORD 'advisor_db_admin';
GRANT CONNECT ON DATABASE public TO advisor_db_admin;
CREATE SCHEMA advisor_schema;

GRANT USAGE ON SCHEMA advisor_schema TO advisor_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA advisor_schema TO advisor_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA advisor_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO advisor_db_admin;

CREATE SCHEMA IF NOT EXISTS advisor_schema;

CREATE TABLE IF NOT EXISTS advisor_schema.advisor (
    id SERIAL PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    position VARCHAR(128) NOT NULL,
    tagline VARCHAR(256),
    address VARCHAR(512) NOT NULL,
    phoneNo VARCHAR(32) NOT NULL,
    profileURL VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS advisor_schema.advisor_team (
    id SERIAL PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    address VARCHAR(256) NOT NULL,
    phone VARCHAR(32) NOT NULL,
    teamURL VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS advisor_schema.advisor_office (
    id SERIAL PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    phoneNo VARCHAR(32) NOT NULL,
    url VARCHAR(128),
    googleMap VARCHAR(128)
);