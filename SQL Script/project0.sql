
CREATE TABLE customers (
	ssn VARCHAR(20) UNIQUE PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	user_name VARCHAR(50) UNIQUE,
	pass_word VARCHAR(50)
);

ALTER TABLE customers ALTER COLUMN pass_word TYPE VARCHAR(255);
ALTER TABLE customers ALTER COLUMN user_name TYPE VARCHAR(255);



INSERT INTO customers (
	ssn, first_name, last_name, user_name, pass_word) VALUES (
	'123456789', 'bob', 'dylan', 'username', 'password'
	);

SELECT * FROM customers;

CREATE TABLE users (
	username VARCHAR(50) REFERENCES customers(user_name)
);

CREATE TABLE requests (
	request_id SERIAL PRIMARY KEY,
	checking BOOLEAN,
	savings BOOLEAN,
	user_ssn VARCHAR(20) REFERENCES customers(ssn)
);

CREATE TABLE checking (
	balance NUMERIC(10, 2) PRIMARY KEY
);

DROP TABLE IF EXISTS savings;

CREATE TABLE savings (
	balance NUMERIC(10, 2) PRIMARY KEY,
	customer_ssn VARCHAR(20) REFERENCES customers(ssn)

);

INSERT INTO requests (checking, savings, user_ssn) VALUES (TRUE, FALSE, '123456789');



CREATE TABLE managers (
	manager_id SERIAL PRIMARY KEY,
	user_name VARCHAR(50),
	user_password VARCHAR(50)
);

CREATE TABLE tellers (
	teller_id SERIAL PRIMARY KEY,
	user_name VARCHAR(50),
	user_password VARCHAR(50)
);

INSERT INTO managers (user_name, user_password) VALUES ('the manager', 'manager password');

INSERT INTO tellers (user_name, user_password) VALUES ('leadteller', 'tellerpassword');

ALTER TABLE checking ADD COLUMN customer_ssn VARCHAR(20) REFERENCES customers(ssn);

ALTER TABLE checking DROP COLUMN amount;

ALTER TABLE savings ADD COLUMN amount NUMERIC(10, 2);

ALTER TABLE requests ADD COLUMN initial_depoist NUMERIC (10, 2);

INSERT INTO checking (balance, customer_ssn) VALUES (125.90, '123456789');

INSERT INTO customers (
	ssn, first_name, last_name, user_name, pass_word) VALUES (
	'000000000', 'john', 'doe', 'jondoe7', 'password'
	);

INSERT INTO customers (
	ssn, first_name, last_name, user_name, pass_word) VALUES (
	'111111111', 'bobby', 'lee', 'mr.bobby', 'password'
	);

INSERT INTO checking (balance, customer_ssn) VALUES (1456.99, '000000000');

INSERT INTO savings (balance, customer_ssn) VALUES (24000.45, '111111111');

-- SEE CUSTOMER CHECKING BALANCE
SELECT * FROM customers INNER JOIN checking ON customers.ssn = checking.customer_ssn;



SELECT customers.first_name, customers.last_name, savings.balance, savings.customer_ssn
	INTO customer_savings
	FROM customers
	INNER JOIN savings ON customers.ssn = savings.customer_ssn;

DELETE FROM savings WHERE customer_ssn = '333333333';

DELETE FROM requests WHERE user_ssn = '333333333';

DELETE FROM customers WHERE ssn = '333333333';

UPDATE customers SET user_name = 'jondoe7', pass_word = 'hjd$' WHERE user_name = 'jondoe7';

UPDATE checking SET balance = balance + 145.32
	WHERE customer_ssn = '111111111';

-- STORED PROCEDURE TO TRANSFER FROM CHECKING TO SAVINGS

create or replace procedure transferToSavings(
   sender VARCHAR(50),
   receiver VARCHAR(50),
   amount NUMERIC(10, 2)
)
language plpgsql
as $$
begin
    -- subtracting the amount from the sender's account
    update checking
    set balance = balance - amount
    where customer_ssn = sender;

    -- adding the amount to the receiver's account
    update savings
    set balance = balance + amount
    where customer_ssn = receiver;

    commit;
end;$$

-- STORED PROCEDURE TO TRANSFER FROM SAVINGS TO CHECKING

create or replace procedure transferToChecking(
   sender VARCHAR(50),
   receiver VARCHAR(50),
   amount NUMERIC(10, 2)
)
language plpgsql
as $$
begin
    -- subtracting the amount from the sender's account
    update savings
    set balance = balance - amount
    where customer_ssn = sender;

    -- adding the amount to the receiver's account
    update checking
    set balance = balance + amount
    where customer_ssn = receiver;

    commit;
end;$$

-- CALLING STORED PROCEDURES

CALL transferToSavings('111111111', '111111111', 40);

CALL transferToChecking('111111111', '111111111', 1000.33);

-- STORED PROCEDURE FOR SAVINGS DEPOSIT
DROP PROCEDURE depositSavings


CREATE OR REPLACE PROCEDURE depositSavings(
	ssn IN VARCHAR(50),
	deposit_amount IN NUMERIC(10, 2)

)
language plpgsql
as $$
BEGIN

	UPDATE savings
	SET balance = balance + deposit_amount
	WHERE savings.customer_ssn = ssn;

	COMMIT;

END;$$

-- CHECKING DEPOSIT STORED PROCEDURE
DROP PROCEDURE depositchecking

CREATE OR REPLACE PROCEDURE depositChecking(
	ssn IN VARCHAR(50),
	deposit_amount IN NUMERIC(10, 2)

)
language plpgsql
as $$
BEGIN

	UPDATE checking
	SET balance = balance + deposit_amount
	WHERE checking.customer_ssn = ssn;

	COMMIT;

END;$$

CALL depositSavings('111111111', 2000);

UPDATE checking SET balance = balance + 100 WHERE customer_ssn = '111111111';


