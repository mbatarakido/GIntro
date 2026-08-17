
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema schooldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schooldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schooldb` DEFAULT CHARACTER SET utf8 ;
USE `schooldb` ;

-- -----------------------------------------------------
-- Table `schooldb`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`teachers` (
  `tchr_id` INT NOT NULL AUTO_INCREMENT,
  `tchr_firstname` VARCHAR(45) NOT NULL,
  `tchr_lastname` VARCHAR(45) NOT NULL,
  `tchr_dob` DATE NOT NULL,
  `tchr_sex` VARCHAR(1) NOT NULL,
  `password` VARCHAR(100) NULL DEFAULT '111111',
  `email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`tchr_id`),
  UNIQUE INDEX `teacher_id_UNIQUE` (`tchr_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 106
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schooldb`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`class` (
  `class_id` INT NOT NULL AUTO_INCREMENT,
  `class_name` VARCHAR(50) NULL DEFAULT NULL,
  `class_start_time` DATETIME NULL DEFAULT NULL,
  `class_end_time` DATETIME NULL DEFAULT NULL,
  `longitude` VARCHAR(20) NULL DEFAULT NULL,
  `latitude` VARCHAR(20) NULL DEFAULT NULL,
  `tchr_id` INT NOT NULL,
  PRIMARY KEY (`class_id`, `tchr_id`),
  UNIQUE INDEX `class_id_UNIQUE` (`class_id` ASC) VISIBLE,
  INDEX `fk_class_teachers1_idx` (`tchr_id` ASC) VISIBLE,
  CONSTRAINT `class_ibfk_1`
    FOREIGN KEY (`tchr_id`)
    REFERENCES `schooldb`.`teachers` (`tchr_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schooldb`.`attendance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`attendance` (
  `att_id` INT NOT NULL AUTO_INCREMENT,
  `stu_id` INT NULL DEFAULT NULL,
  `class_id` INT NULL DEFAULT NULL,
  `longitude` VARCHAR(20) NULL DEFAULT NULL,
  `latitude` VARCHAR(20) NULL DEFAULT NULL,
  `att_marked_time` VARCHAR(100) NULL DEFAULT NULL,
  `att_status` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`att_id`),
  INDEX `fk_attendance_students1_idx` (`stu_id` ASC, `class_id` ASC) VISIBLE,
  INDEX `class_id` (`class_id` ASC) VISIBLE,
  CONSTRAINT `attendance_ibfk_1`
    FOREIGN KEY (`class_id`)
    REFERENCES `schooldb`.`class` (`class_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schooldb`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`students` (
  `stu_id` INT NOT NULL AUTO_INCREMENT,
  `stu_firstname` VARCHAR(45) NOT NULL,
  `stu_lastname` VARCHAR(45) NOT NULL,
  `stu_dob` DATE NOT NULL,
  `stu_sex` VARCHAR(1) NOT NULL,
  `tchr_id` INT NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT '000000',
  `email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  UNIQUE INDEX `stu_id_UNIQUE` (`stu_id` ASC) VISIBLE,
  INDEX `students_ibfk_1` (`tchr_id` ASC) VISIBLE,
  CONSTRAINT `students_ibfk_1`
    FOREIGN KEY (`tchr_id`)
    REFERENCES `schooldb`.`teachers` (`tchr_id`)
    ON DELETE SET NULL)
ENGINE = InnoDB
AUTO_INCREMENT = 1011
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schooldb`.`permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stu_id` INT NOT NULL,
  `request` VARCHAR(200) NULL DEFAULT NULL,
  `reply` VARCHAR(200) NULL DEFAULT NULL,
  `tchr_id` INT NOT NULL,
  PRIMARY KEY (`id`, `stu_id`, `tchr_id`),
  INDEX `stu_id` (`stu_id` ASC) VISIBLE,
  CONSTRAINT `permission_ibfk_2`
    FOREIGN KEY (`tchr_id`)
    REFERENCES `schooldb`.`teachers` (`tchr_id`),
  CONSTRAINT `permission_ibfk_3`
    FOREIGN KEY (`stu_id`)
    REFERENCES `schooldb`.`students` (`stu_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schooldb`.`class_has_students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schooldb`.`class_has_students` (
  `class_class_id` INT NOT NULL,
  `class_tchr_id` INT NOT NULL,
  `students_stu_id` INT NOT NULL,
  PRIMARY KEY (`class_class_id`, `class_tchr_id`, `students_stu_id`),
  INDEX `fk_class_has_students_students1_idx` (`students_stu_id` ASC) VISIBLE,
  INDEX `fk_class_has_students_class1_idx` (`class_class_id` ASC, `class_tchr_id` ASC) VISIBLE,
  CONSTRAINT `fk_class_has_students_class1`
    FOREIGN KEY (`class_class_id` , `class_tchr_id`)
    REFERENCES `schooldb`.`class` (`class_id` , `tchr_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_class_has_students_students1`
    FOREIGN KEY (`students_stu_id`)
    REFERENCES `schooldb`.`students` (`stu_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- inserting into students table
insert into students values(1001, "Maria", "Smith", '2000-04-04', "F");
insert into students(stu_firstname, stu_lastname, stu_dob, stu_sex) values("Kevin", "Green", '1998-05-23', "M");
insert into students(stu_firstname, stu_lastname, stu_dob, stu_sex) values("Lucy", "Small", '2001-10-14', "F");
insert into students(stu_firstname, stu_lastname, stu_dob, stu_sex) values("Mark", "Jones", '1999-06-08', "M");
insert into students(stu_firstname, stu_lastname, stu_dob, stu_sex) values("John", "Paul", '1998-11-11', "M");

-- inserting into teachers table
insert into teachers values(101, "Guo", "Laoshi", '1987-07-26', "M");
insert into teachers(tchr_firstname, tchr_lastname, tchr_dob, tchr_sex) values("Zhang", "Dong", '1978-05-01', "M");
insert into teachers(tchr_firstname, tchr_lastname, tchr_dob, tchr_sex) values("Li", "Wen", '1981-10-12', "F");
insert into teachers(tchr_firstname, tchr_lastname, tchr_dob, tchr_sex) values("Robert", "Brown", '1975-06-08', "M");
insert into teachers(tchr_firstname, tchr_lastname, tchr_dob, tchr_sex) values("Lin", "Lin", '1988-01-11', "M");

-- inserting into class table
insert into class values(3, "Chinese Language", "2020-06-01 09:00:00", "2020-06-01 11:00:00", 41.09, 34.87, 103);
insert into class(class_name, class_start_time, class_end_time, longitude, latitude, tchr_id) values("OS Fundamentals", "2020-06-01 09:00:00", "2020-06-01 11:00:00", null, null, 102);
insert into class(class_name, class_start_time, class_end_time, longitude, latitude, tchr_id) values("Software Engineering", "2020-06-01 09:00:00", "2020-06-01 11:00:00", null, null, 103);
insert into class(class_name, class_start_time, class_end_time, longitude, latitude, tchr_id) values("Data Structures", "2020-06-01 09:00:00", "2020-06-01 11:00:00", null, null, 104);
insert into class(class_name, class_start_time, class_end_time, longitude, latitude, tchr_id) values("Discrete Mathematics", "2020-06-01 09:00:00", "2020-06-01 11:00:00", null, null, 105);

-- inserting into attendance table
insert into attendance values(1001, 4, 12.00, 37.00, '2020-05-01 11:00:00', 'Y'); 
insert into attendance values(1001, 1, 54.00, 32.00, '2020-05-01 11:00:00', 'N'); 
insert into attendance values(1001, 2, 12.00, 67.00, '2020-05-01 11:00:00', 'Y'); 
insert into attendance values(1004, 5, 41.00, 34.00, '2020-05-01 11:00:00', 'N'); 
insert into attendance(stu_id, class_id, longitude, latitude, att_marked_time, att_status) values(1010, 2, -75.00, 25.00, '2020-06-02 09:59:00', 'Y'); 

-- Extra Queries

DESCRIBE teachers;
Describe students;
describe class;
describe attendance;

select * from students;
select * from teachers;
select * from class;
select * from attendance;

SELECT attendance.att_id, 
attendance.class_id, 
attendance.stu_id, 
attendance.longitude, 
attendance.latitude, 
attendance.att_marked_time, 
att_status, 
class.class_name 
FROM attendance,class 
WHERE stu_id=1010 AND attendance.class_id=class.class_id;

update class set class_name='Android Dev' where class_id=2;
SELECT COUNT(att_status) FROM attendance WHERE att_status='N';
delete from class where class_id=3;
alter table class modify column class_id int auto_increment;
alter table students drop column password;
alter table students add column password varchar(100) default '000000';
ALTER TABLE students ADD FOREIGN KEY (tchr_id) REFERENCES teachers(tchr_id) ON DELETE SET NULL;

ALTER TABLE attendance ADD att_id INT;

UPDATE students SET password=MD5("jackpass") WHERE student_id=1;
UPDATE class SET longitude=41.09, latitude=34.87 WHERE class_id=6;

UPDATE students SET stu_firstname= 'Chris', stu_lastname='Ross', stu_dob='1999-03-14', stu_sex='M',tchr_id=102, email='ross@gmail.com' WHERE stu_id=1008; 

SELECT students.stu_id, students.password FROM students;

create table details(username varchar(20), password varchar(100));
insert into details values('Jack', '000000');
select * from details where username='Jack' and password='000000';


