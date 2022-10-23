DROP DATABASE IF EXISTS USER_DB;

CREATE DATABASE USER_DB;

USE USER_DB;

CREATE TABLE USER(
id INT AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
email VARCHAR(50),
date_of_birth DATE,

CONSTRAINT USER_ID_PK PRIMARY KEY (id)

);

INSERT INTO USER (id, first_name, last_name, email, date_of_birth) VALUES (1, "Augusto", "Ibarrola", "augusto@email.com", sysdate()- interval 9000 day);
COMMIT;

SELECT * FROM USER;