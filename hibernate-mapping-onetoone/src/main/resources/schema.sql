CREATE TABLE IF NOT EXISTS `testdb`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `customer_details_id` INT NULL,
  PRIMARY KEY (`customer_id`),
  INDEX `customer_details_id_idx` (`customer_details_id` ASC),
  CONSTRAINT `customer_details_id`
    FOREIGN KEY (`customer_details_id`)
    REFERENCES `testdb`.`customer_details` (`customer_details_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `testdb`.`customer_details` (
  `customer_details_id` INT NOT NULL AUTO_INCREMENT,
  `gender` VARCHAR(45) NULL,
  `date_of_birth` DATE NULL,
  `age` INT NULL,
  `father_name` VARCHAR(45) NULL,
  `mother_name` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_details_id`))
ENGINE = InnoDB ;
CREATE TABLE IF NOT EXISTS `testdb`.`student_details` (
  `student_details_id` INT NOT NULL AUTO_INCREMENT,
  `roll_no` INT NULL,
  `class` INT NULL,
  `teacher_name` VARCHAR(45) NULL,
  `major_subject` VARCHAR(45) NULL,
  PRIMARY KEY (`student_details_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `testdb`.`student` (
  `student_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `father_name` VARCHAR(45) NULL,
  `mother_name` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  PRIMARY KEY (`student_id`),
  CONSTRAINT `student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `testdb`.`student_details` (`student_details_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;