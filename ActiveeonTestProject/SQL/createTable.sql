SET PASSWORD FOR 'root'@'localhost' = PASSWORD('Password01');

CREATE database fichedb;

CREATE TABLE fichedb.fiche (id INT NOT NULL AUTO_INCREMENT,   Nom VARCHAR(100) NOT NULL,  numeroDeTelephone VARCHAR(40) NOT NULL,   adresse VARCHAR(150) NOT NULL,   PRIMARY KEY ( id));

