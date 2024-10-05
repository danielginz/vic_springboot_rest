CREATE DATABASE  vic_db;
USE vic_db;



CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  firstname varchar(15),
  lastname varchar(25),
  requestcountone int UNSIGNED,
  requestcounttwo int UNSIGNED,
  PRIMARY KEY (id)
);


INSERT INTO vic_db.users (id, firstname, lastname, requestcountone, requestcounttwo)
VALUES
	(1, 'Avi', 'Levi', 0, 0),
	(2, 'Moshe', 'Cohen', 0 , 0),
	(3, 'Shirli', 'Avraham', 0, 0);

