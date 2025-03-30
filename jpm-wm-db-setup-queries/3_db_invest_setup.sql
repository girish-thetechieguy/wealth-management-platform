--For invest user and invest servive and its scheme
CREATE USER invest_db_admin WITH PASSWORD 'invest_db_admin';
GRANT CONNECT ON DATABASE public TO invest_db_admin;
CREATE SCHEMA invest_schema;

GRANT USAGE ON SCHEMA invest_schema TO invest_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA invest_schema TO invest_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA invest_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO invest_db_admin;


CREATE SCHEMA IF NOT EXISTS invest_schema;

CREATE TABLE IF NOT EXISTS invest_schema.investors_fund (
    id SERIAL PRIMARY KEY,
    username VARCHAR(256) NOT NULL REFERENCES auth_schema.client(username),  -- Assuming 'client' table exists with 'id' as PK
    balance FLOAT4
);


CREATE TABLE IF NOT EXISTS invest_schema.wealth_plan (
    id SERIAL PRIMARY KEY,
    type VARCHAR(64) NOT NULL,
    category VARCHAR(32) NOT NULL,
    riskLevel SMALLINT NOT NULL,
    name VARCHAR(128) NOT NULL,
    description VARCHAR(512),
    star CHAR(1) NOT NULL,
    Return1m FLOAT4,
    Return1y FLOAT4,
    Return3y FLOAT4,
    Return5y FLOAT4,
    expRatio FLOAT4,
    lockInPeriod SMALLINT,
    isLumpSum BOOLEAN,
    isSIP BOOLEAN,
    portfolioManager VARCHAR(128) NOT NULL,
    minInvest BIGINT NOT NULL,
    maxInvest BIGINT NOT NULL
);

