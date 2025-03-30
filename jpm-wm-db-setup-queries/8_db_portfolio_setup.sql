--For portfolio user and portfolio servive and its scheme
CREATE USER portfolio_db_admin WITH PASSWORD 'portfolio_db_admin';
GRANT CONNECT ON DATABASE public TO portfolio_db_admin;
CREATE SCHEMA portfolio_schema;

GRANT USAGE ON SCHEMA portfolio_schema TO portfolio_db_admin;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA portfolio_schema TO portfolio_db_admin;

ALTER DEFAULT PRIVILEGES IN SCHEMA portfolio_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO portfolio_db_admin;

CREATE TABLE IF NOT EXISTS wealth_portfolio_schema.portfolios (
    id SERIAL PRIMARY KEY,
    username VARCHAR(256) NOT NULL REFERENCES auth_schema.client(username),  -- Assuming 'client' table exists with 'id' as PK
    name VARCHAR(64) NOT NULL,
    type VARCHAR(64) NOT NULL,
    hasAdvisor BOOLEAN,
    planId VARCHAR(256) NOT NULL REFERENCES invest_schema.wealth_plan(id),  -- Assuming 'client' table exists with 'id' as PK
    bprice FLOAT4 NOT NULL,
    cprice FLOAT4 NOT NULL,
    advisorId VARCHAR(256) NOT NULL REFERENCES advisor_schema.advisor(id),  -- Assuming 'client' table exists with 'id' as PK
);