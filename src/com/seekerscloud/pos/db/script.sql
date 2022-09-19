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