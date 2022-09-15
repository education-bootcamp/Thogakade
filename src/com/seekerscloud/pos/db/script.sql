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
#===================