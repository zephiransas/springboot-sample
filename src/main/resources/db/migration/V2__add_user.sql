CREATE TABLE users (username VARCHAR(100) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255));

INSERT INTO users (username, encoded_password) VALUES('user1', '$2a$10$ELBVVL7Bw5hh3EACP9QbJOpJYGRtIEBiTPTWMNAm6/xPbUJ0nvq36');
INSERT INTO users (username, encoded_password) VALUES('user2', '$2a$10$ELBVVL7Bw5hh3EACP9QbJOpJYGRtIEBiTPTWMNAm6/xPbUJ0nvq36');

ALTER TABLE customers ADD username VARCHAR(100) NOT NULL DEFAULT 'user1';