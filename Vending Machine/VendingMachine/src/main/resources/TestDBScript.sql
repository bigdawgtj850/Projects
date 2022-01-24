USE vendingmachine;
DROP DATABASE IF EXISTS vendingmachine;
CREATE DATABASE vendingmachine;
USE vendingmachine;

CREATE TABLE inventory (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    price DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    stocklevel INT NOT NULL DEFAULT 0
);

CREATE TABLE `change` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    `quarter` INT NOT NULL DEFAULT 0,
    dime INT NOT NULL DEFAULT 0,
    nickel INT NOT NULL DEFAULT 0,
    penny INT NOT NULL DEFAULT 0
);

INSERT INTO `change`(`quarter`, nickel, dime, penny)
	VALUES (10,10,10,10);
    
INSERT INTO inventory(`name`, price, stocklevel)
	VALUES  ('Soda Pop', 1.25, 3),
			('Juice', 3.00, 3),
            ('Soup', 1.15, 3);
            
SELECT * FROM `change` where ID = 1;
SELECT * FROM inventory;