SHOW DATABASES;
DROP DATABASE IF EXISTS Thogakade;
CREATE DATABASE IF NOT EXISTS Thogakade;
SHOW DATABASES;
USE Thogakade;
#=============
CREATE TABLE IF NOT EXISTS Customer(
    id VARCHAR(45),
    name VARCHAR(45),
    address TEXT,
    salary DOUBLE,
    CONSTRAINT PRIMARY KEY(id)
);
CREATE TABLE IF NOT EXISTS Item(
    code VARCHAR(45),
    description VARCHAR(45),
    unitPrice DOUBLE,
    qtyOnHand INT,
    CONSTRAINT PRIMARY KEY (code)
);
#===================
CREATE TABLE IF NOT EXISTS `Order`(
    orderId VARCHAR(45),
    date VARCHAR(250),
    totalCost DOUBLE,
    customer VARCHAR(45),
    CONSTRAINT PRIMARY KEY (orderId),
    CONSTRAINT FOREIGN KEY (customer) REFERENCES Customer(id)
    ON DELETE CASCADE ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS `Order Details`(
    itemCode VARCHAR(45),
    orderId VARCHAR(45),
    unitPrice DOUBLE,
    qty INT,
    CONSTRAINT PRIMARY KEY (itemCode, orderId),
    CONSTRAINT FOREIGN KEY (itemCode) REFERENCES Item(code) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT FOREIGN KEY (orderId) REFERENCES `Order`(orderId) ON DELETE CASCADE ON UPDATE CASCADE
    );