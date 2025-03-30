--For Transaction user and Transaction servive and its scheme
CREATE USER transaction_user WITH PASSWORD 'transaction_user';
GRANT CONNECT ON DATABASE public TO transaction_user;
CREATE SCHEMA transaction_schema;

GRANT USAGE ON SCHEMA transaction_schema TO transaction_user;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA transaction_schema TO transaction_user;

ALTER DEFAULT PRIVILEGES IN SCHEMA transaction_schema GRANT SELECT, INSERT, UPDATE ON TABLES TO transaction_user;

CREATE SCHEMA IF NOT EXISTS wealth_portfolio_schema;

CREATE TABLE IF NOT EXISTS wealth_schema.wealth_transactions (
    id SERIAL PRIMARY KEY,
    walletId SERIAL NOT NULL REFERENCES invest_schema.investors_fund(id),  -- Assuming 'investors_fund' table exists with 'id' as PK
    transactionTime TIMESTAMP NOT NULL,
    credit FLOAT4,
    debit FLOAT4,
    planId VARCHAR(256) NOT NULL REFERENCES invest_schema.wealth_plan(id),  -- Assuming 'client' table exists with 'id' as PK
    status VARCHAR(32) NOT NULL,
    balance FLOAT4
);