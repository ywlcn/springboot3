
CREATE TABLE city(
    id Int NOT NULL ,
    name VARCHAR(255) NOT NULL ,
    population Int NOT NULL
);

CREATE TABLE district(
    id bigint GENERATED ALWAYS AS IDENTITY ,
    name VARCHAR(255) NOT NULL ,
    cityId Int NOT NULL
);


-- Service Group
CREATE TABLE groups (
  groupId VARCHAR(10) PRIMARY KEY  ,
  groupName VARCHAR(40) NOT NULL
);


-- Team
CREATE TABLE teams (
  teamId VARCHAR(10) PRIMARY KEY  ,
  groupId VARCHAR(10) NOT NULL  ,
  teamName VARCHAR(40) NOT NULL ,
  teamAuthority VARCHAR(40)
);

-- users -> teams -> groups
-- User
CREATE TABLE users (
  userId VARCHAR(10) PRIMARY KEY  ,
  userName VARCHAR(40) NOT NULL,
  age Int NOT NULL ,
  userType VARCHAR(10) NOT NULL  ,
  teamId VARCHAR(10) NOT NULL
);


