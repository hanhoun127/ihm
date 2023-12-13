DROP DATABASE IF EXISTS ihm ;
CREATE DATABASE ihm;
use ihm

CREATE TABLE teacher (
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR (255) NOT NULL,
    specialty VARCHAR(100)
);

CREATE TABLE memoire (
    referenceNbr VARCHAR(20) PRIMARY KEY NOT NULL ,
    id_teacher INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year YEAR NOT NULL,
    supervisor CHAR(25) NOT NULL,
    summary TEXT,
    FOREIGN KEY (id_teacher) REFERENCES teacher(id)
    
);


