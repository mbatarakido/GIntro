-- creating stored procedure
DELIMITER //
CREATE PROCEDURE GetAllEmployees()
BEGIN
	SELECT * FROM employees;
END //
DELIMITER ;

CALL GetAllProducts();
CALL GetAllEmployees();
CALL GetAllPayments();

-- creating stored procedure with IN parameter that finds all offices located in the country passed 
DELIMITER //
CREATE PROCEDURE GetOfficeByCountry(IN countryName VARCHAR(255))
BEGIN
	SELECT * FROM offices WHERE country = countryName;
END //
DELIMITER ;

CALL GetOfficeByCountry('USA');

-- stored procedure with OUT parameter
DELIMITER &&
CREATE PROCEDURE GetOrderCountByStatus(IN orderStatus VARCHAR(25), OUT total INT)
BEGIN
	SELECT COUNT(orderNumber)
    INTO total
    FROM orders WHERE status = orderStatus;
END&&
DELIMITER ;

CALL GetOrderCountByStatus('Shipped', @total);
SELECT @total;
CALL GetOrderCountByStatus('in process', @total);
SELECT @total AS total_in_process;

-- stored procedure using INOUT parameter
DELIMITER //
CREATE PROCEDURE SetCounter(INOUT counter INT, IN inc INT)
BEGIN
	SET counter = counter + inc;
END //
DELIMITER ;

SET @counter = 1;
CALL SetCounter(@counter, 1); -- 2
CALL SetCounter(@counter, 2); -- 4
CALL SetCounter(@counter, 5); -- 9
SELECT @counter AS counter;  -- 9

-- listing procedures
SHOW PROCEDURE STATUS;
SHOW PROCEDURE STATUS WHERE db='classicmodels';
SHOW PROCEDURE STATUS LIKE '%Order%';

-- to show procedures of a particular db
SELECT routine_name FROM information_schema.routines
	WHERE routine_type = 'PROCEDURE'
    AND routine_schema = 'classicmodels';
    
-- creating view
CREATE VIEW customerPayments
AS
SELECT
	customerName,
	checkNumber,
    paymentDate,
    amount
FROM
	customers
INNER JOIN
	payments USING (customerNumber);
    
SELECT * FROM customerPayments;

CREATE VIEW daysofweek(day) AS
	SELECT 'Mon'
    UNION
    SELECT 'Tue'
    UNION
    SELECT 'Wed'
    UNION
    SELECT 'Thu'
    UNION
    SELECT 'Fri'
    UNION
    SELECT 'Sat'
    UNION
    SELECT 'Sun';
    
SELECT * FROM daysofweek;

-- IF statements
DELIMITER &&
CREATE PROCEDURE GetCustomerLevel(
	IN input INT,
    OUT output VARCHAR(20))
BEGIN
	DECLARE credit INT DEFAULT 0;
    SELECT creditLimit INTO credit FROM customers WHERE customerNumber = input;
    IF credit > 50000 THEN
		SET output = 'PLATINUM';
	ELSEIF credit < 50000 AND credit > 10000 THEN
		SET output = 'GOLD';
	ELSE
		SET output = 'SILVER';
	END IF;
END &&
DELIMITER ;

SELECT customerNumber,creditLimit FROM customers WHERE creditLimit > 50000;
CALL GetCustomerLevel(447, @cusLevel);
SELECT @cusLevel AS customerLevel;

select * from customers;
-- CASE statements
DELIMITER &&
CREATE PROCEDURE GetCustomerShipping(
	IN pCustomerNumber INT,
    OUT pShipping VARCHAR(50))
BEGIN
	DECLARE customerCountry VARCHAR(100);
    SELECT country INTO customerCountry FROM customers WHERE customerNumber = pCustomerNumber;
    CASE customerCountry
		WHEN 'USA' THEN
			SET pShipping = '2-days Shipping';
		WHEN 'Canada' THEN
			SET pShipping = '3-day Shipping';
		ELSE
			SET pShipping = '5-day Shiping';
	END CASE;
END &&
DELIMITER ;

CALL GetCustomerShipping(112, @shipping);
SELECT @shipping;

-- searched CASE statement
DELIMITER &&
CREATE PROCEDURE GetDeliveryStatus(
	IN pOrderNumber INT,
    OUT pDeliveryStatus VARCHAR(100))
BEGIN 
	DECLARE waitingDays INT DEFAULT 0;
    SELECT
		DATEDIFF(requiredDate, shippedDate)
	INTO waitingDays
    FROM orders
    WHERE orderNumber = pOrderNumber;
	CASE
		WHEN waitingDays = 0 THEN
			SET pDeliveryStatus = 'On Time';
		WHEN waitingDays >= 1 AND waitingDays < 5 THEN
			SET pDeliveryStatus = 'Late';
		WHEN waitingDays >= 5 THEN
			SET pDeliveryStatus = 'Very Late';
		ELSE
			SET pDeliveryStatus = 'No Information';
	END CASE;
END &&
DELIMITER ;

SELECT * FROM orders;
CALL GetDeliveryStatus(10127, @deliveryStatus);
SELECT @deliveryStatus;

-- LOOPS
-- stored procedure using a loop to print even numbers
DROP PROCEDURE LoopDemo;
DELIMITER &&
CREATE PROCEDURE LoopDemo()
BEGIN
	DECLARE x INT;
    DECLARE str VARCHAR(255);
	SET x = 1;
    SET str = '';
    
    loop_label: LOOP
		IF x > 10 THEN
			LEAVE loop_label;
		END IF;
        
        SET x = x+1;
        IF (x mod 2) THEN
			ITERATE loop_label; -- ITERATE is equivalent to continue in C/C++
		ELSE
			SET str = CONCAT(str, x, ',');
		END IF;
	END LOOP;
    SELECT str;
END &&
DELIMITER ;
        
CALL LoopDemo();

-- WHILE loop demo
CREATE TABLE calendars(
	id INT AUTO_INCREMENT,
    fulldate DATE UNIQUE,
    day TINYINT NOT NULL,
    month TINYINT NOT NULL,
    quarter TINYINT NOT NULL,
    year INT NOT NULL,
    PRIMARY KEY(id)
);
 
 -- stored procedure to insert date into the calenders table
 DELIMITER &&
 CREATE PROCEDURE InsertCalendar(dt DATE)
 BEGIN
	INSERT INTO calendars(fulldate, day, month, quarter, year)
    VALUES(
		dt,
        EXTRACT(DAY FROM dt),
        EXTRACT(MONTH FROM dt),
        EXTRACT(QUARTER FROM dt),
        EXTRACT(YEAR FROM dt)
	);
END &&
DELIMITER ;

-- create procedure that loads a number of days starting from a start date int the calendars tablle.ALTER
DELIMITER &&
CREATE PROCEDURE LoadCalendars(startDate DATE, day Int)
BEGIN
	DECLARE counter INT DEFAULT 1;
    DECLARE dt DATE DEFAULT startDate;
    
    WHILE counter <= day DO
		CALL InsertCalendar(dt);
        SET counter = counter + 1;
        SET dt = DATE_ADD(dt, INTERVAL 1 day);
	END WHILE;
END &&
DELIMITER ;

CALL LoadCalendars('2020-01-01', 15);
SELECT * FROM calendars;

-- the REPEAT statement procedure, equivalent to DO-WHILE loop in C/C++
DELIMITER $$
CREATE PROCEDURE RepeatDemo()
BEGIN
    DECLARE counter INT DEFAULT 1;
    DECLARE result VARCHAR(100) DEFAULT '';
    
    REPEAT
        SET result = CONCAT(result,counter,',');
        SET counter = counter + 1;
    UNTIL counter >= 10
    END REPEAT;
    
    -- display result
    SELECT result;
END$$
DELIMITER ;

CALL RepeatDemo();

-- using LEAVE statement to break out of a loop
-- the procedure below generates a string of integers from 1 to a randrom number btn 4 and 10.
DELIMITER $$
CREATE PROCEDURE LeaveDemo(OUT result VARCHAR(100))
BEGIN
    DECLARE counter INT DEFAULT 1;
    DECLARE times INT;
    -- generate a random integer between 4 and 10
    SET times  = FLOOR(RAND()*(10-4+1)+4);
    SET result = '';
    disp: LOOP
        -- concatenate counters into the result
        SET result = concat(result,counter,',');
        
        -- exit the loop if counter equals times
        IF counter = times THEN
            LEAVE disp; 
        END IF;
        SET counter = counter + 1;
    END LOOP;
END$$
DELIMITER ;

CALL LeaveDemo(@result);