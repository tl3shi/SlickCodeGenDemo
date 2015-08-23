CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    hashed_password CHAR(128) NOT NULL,
    salt CHAR(32) NOT NULL,
    created TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE INDEX (name)
  );

CREATE TABLE SqlQueryTask(
	id INT NOT NULL AUTO_INCREMENT,
	sqlQuery text NOT NULL,
	description VARCHAR(128),
	cronDesc VARCHAR(64),
	status VARCHAR(20),
	createdTime DATETIME,
	mailTo VARCHAR(256),
	extInfo text,
	createdUserId int, 
	PRIMARY KEY (id),
	FOREIGN KEY (createdUserId) REFERENCES user(id)
);