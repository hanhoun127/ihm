CREATE TABLE Memoire (
    id INT PRIMARY KEY AUTO_INCREMENT,
    referenceNbr VARCHAR(20) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year YEAR NOT NULL,
    summary TEXT
);
CREATE TABLE Teacher (
    id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR (255) NOT NULL,
    specialty VARCHAR(100)
);

CREATE TABLE student(
    id INT PRIMARY KEY AUTO_INCREMENT,
    matricule INT(12) NOT NULL UNIQUE,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL
);