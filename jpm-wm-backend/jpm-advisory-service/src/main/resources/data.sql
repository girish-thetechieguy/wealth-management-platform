INSERT INTO advisors (first_name, last_name, email, phone, status, created_at, updated_at)
VALUES
('John', 'Smith', 'john.smith@jpmorgan.com', '+1-212-555-1001', 'ACTIVE', NOW(), NOW()),
('Sarah', 'Johnson', 'sarah.johnson@jpmorgan.com', '+1-212-555-1002', 'ACTIVE', NOW(), NOW()),
('Michael', 'Williams', 'michael.williams@jpmorgan.com', '+1-212-555-1003', 'ON_LEAVE', NOW(), NOW());

INSERT INTO advisor_specializations (advisor_id, specialization)
VALUES
(1, 'Retirement Planning'),
(1, 'Tax Strategies'),
(2, 'Estate Planning'),
(2, 'Wealth Transfer'),
(3, 'Investment Management'),
(3, 'Risk Management');