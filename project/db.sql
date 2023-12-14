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
    id INT  NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL ,
    email VARCHAR (255) NOT NULL,
    specialty VARCHAR(100)
);

INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Rezoug Abdellah','Abdellah.rezoug@gmail.com','Interaction Homme-Machine');
INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Boulif Menouar','boumen7@gmail.com','Intelligence Artificielle ');
INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Riahla','meda.riahla@gmail.com','Sécurité Informatique');
INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Salmi Cheikh','salmi.cheikh@gmail.com','Base de Données');