CREATE TABLE memoire (
    id INT PRIMARY KEY AUTO_INCREMENT,
    referenceNbr VARCHAR(20) NOT NULL UNIQUE,
    code VARCHAR(20) NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year YEAR NOT NULL,
    supervisor CHAR(25) NOT NULL,
    summary TEXT
);
INSERT INTO `memoire`(`referenceNbr`, `title`, `author`, `year`, `supervisor`, `summary`) VALUES ('REF123', 'Sample Title', 'John Doe', 2023, 'Supervisor A', 'summary 1');
INSERT INTO `memoire`(`referenceNbr`, `title`, `author`, `year`, `supervisor`, `summary`) VALUES ('REF456', 'Another Title', 'Jane Doe', 2023, 'Supervisor B', 'summary 2');
INSERT INTO `memoire`(`referenceNbr`, `title`, `author`, `year`, `supervisor`, `summary`) VALUES ('REF789', 'Third Title', 'Alice Smith', 2023, 'Supervisor C', 'summary 3');


CREATE TABLE teacher (
    id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR (255) NOT NULL,
    specialty VARCHAR(100)
);
INSERT INTO `teacher`( `last_name`, `first_name`, `email`, `specialty`) VALUES ('Smith', 'Alice', 'alice.smith@example.com', 'Computer Science');
INSERT INTO `teacher`( `last_name`, `first_name`, `email`, `specialty`) VALUES ('Johnson', 'Bob', 'bob.johnson@example.com', 'Mathematics');
INSERT INTO `teacher`( `last_name`, `first_name`, `email`, `specialty`) VALUES ('Davis', 'Charlie', 'charlie.davis@example.com', 'Physics');


