DROP TABLE IF EXISTS TBL_OWNERS;
DROP TABLE IF EXISTS TBL_APPOINTMENTS;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE users (
    username varchar(128) not null primary  key,
    password varchar (512) not null,
    enabled boolean not null
);

CREATE TABLE authorities(
    username varchar (128) not null,
    authority varchar(128) not null
);

create unique index idx_auth_username on authorities(username,authority);
 
CREATE TABLE TBL_OWNERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  phone_number VARCHAR(15) DEFAULT NULL
);

CREATE TABLE TBL_APPOINTMENTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  date DATE ,
  time TIMESTAMP ,
  description VARCHAR(250) DEFAULT NULL,
  priority VARCHAR(15) DEFAULT NULL,
  animal_name VARCHAR(15) DEFAULT NULL,
  animal_type VARCHAR(15) DEFAULT NULL
);