DROP DATABASE IF EXISTS ihm ;
CREATE DATABASE ihm;
use ihm

CREATE TABLE teacher (
    id INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL ,
    email VARCHAR (255) NOT NULL,
    specialty VARCHAR(100)
);

CREATE TABLE memoire (
    referenceNbr VARCHAR(20) PRIMARY KEY NOT NULL ,
    id_teacher INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    level VARCHAR(11)  NOT NULL,
    year YEAR NOT NULL,
    supervisor CHAR(25) NOT NULL,
    summary TEXT,
    FOREIGN KEY (id_teacher) REFERENCES teacher(id)
    
);


INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Rezoug Abdellah','Abdellah.rezoug@gmail.com','Interaction Homme-Machine');
INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Boulif Menouar','boumen7@gmail.com','Intelligence Artificielle ');
INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Riahla mohamed amine','meda.riahla@gmail.com','Sécurité Informatique');
INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Salmi Cheikh','salmi.cheikh@gmail.com','Base de Données');
INSERT INTO `teacher`( `name`, `email`, `specialty`) VALUES ('Betit rahmoune','r_bitit@esi.dz','Interaction Homme-Machine ,Developpement web/mobile');

INSERT INTO `memoire`(`referenceNbr`, `id_teacher`, `title`, `author`, `level`, `year`, `supervisor`, `summary`) VALUES ('RE450782','1','magic mirror anatomy teaching','Habieb nour el houda,halimi rania','master','2023','rezoug abdellah','magic mirror anatomy teaching');
INSERT INTO `memoire`(`referenceNbr`, `id_teacher`, `title`, `author`, `level`, `year`, `supervisor`, `summary`) VALUES ('RE450780','5','Gestion de presence des etudiants','rial mohamed,hamda imad eddine,boukais anis lotfi','licence','2023','bitit rahmoune','Developpment d une application web/mobile pour la gestion des presence des etudiants par GR code');
INSERT INTO `memoire`(`referenceNbr`, `id_teacher`, `title`, `author`, `level`, `year`, `supervisor`, `summary`) VALUES ('RE450781','4','recommandation d articles scientifiques','rahai mohamed anis','master','2023','salmi cheikh','elaboration d un outil intellignet de recommandation d articles scientifiques');
