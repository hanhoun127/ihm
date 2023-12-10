DROP DATABASE IF EXISTS ihm ;
CREATE DATABASE ihm;
use ihm

CREATE TABLE memoire (
    referenceNbr VARCHAR(20) PRIMARY KEY NOT NULL ,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year YEAR NOT NULL,
    supervisor CHAR(25) NOT NULL,
    summary TEXT,
    FOREIGN KEY (supervisor) REFERENCES teacher(name)
    
);

CREATE TABLE teacher (
    name VARCHAR(50) NOT NULL PRIMARY KEY,
    email VARCHAR (255) NOT NULL,
    specialty VARCHAR(100)
);

