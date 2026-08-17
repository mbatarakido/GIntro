
CREATE TABLE `pracs`.`tt` (
	  `id` INT NOT NULL AUTO_INCREMENT,
	  `name` VARCHAR(255) NOT NULL,
	  `start_at` TIME NULL,
	  `end_at` TIME NULL,
		PRIMARY KEY (`id`)
);

CREATE TABLE test_timestamp (
    t1  TIMESTAMP
);

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM tt;

INSERT INTO tt(name,start_at,end_at) VALUES('Test 1', '08:00:00','10:00:00'); -- HH:MM:SS 
INSERT INTO tt(name,start_at,end_at) VALUES('Test 2','083000','101500'); -- HHMMSS
INSERT INTO tt(name,start_at,end_at) VALUES('Test 3',082000,102000);
INSERT INTO tt(name,start_at,end_at) VALUES('Test 4','9:5:0',100500);
INSERT INTO tt(name,start_at,end_at) VALUES('Test 5',current_time(),current_time());

SELECT 
    CURRENT_TIME() AS string_now,
    CURRENT_TIME() + 0 AS numeric_now;

SELECT 
    CURRENT_TIME(),
    ADDTIME(CURRENT_TIME(), 023000),	
    SUBTIME(CURRENT_TIME(), 023000);

SELECT 
    TIMEDIFF(end_at, start_at)
FROM
    tt;
   
-- %h means two-digit hours from 0 to 12.
-- %i means two-digit minutes from 0 to 60.
-- %p means AM or PM.
SELECT 
    name,
    TIME_FORMAT(start_at, '%h:%i %p') start_at,
    TIME_FORMAT(end_at, '%h:%i %p') end_at
FROM
    tt;    
   
-- to get the UTC time value
SELECT 
   CURRENT_TIME(), 
   UTC_TIME();
    
-- timestamp
-- setting th session time zone
SET time_zone='+00:00';    
   
INSERT INTO test_timestamp(t1) VALUES('2008-01-01 00:00:01');

SELECT t1 FROM test_timestamp;

SET time_zone ='+03:00';
    
INSERT INTO categories(name) VALUES ('A');

SELECT * FROM categories;
SELECT * FROM categories WHERE id=2;

ALTER TABLE categories
ADD COLUMN updated_at 
  TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
  ON UPDATE CURRENT_TIMESTAMP;

INSERT INTO categories(name) VALUES('B');

UPDATE categories SET name = 'B+' WHERE id = 2;




