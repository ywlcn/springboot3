
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
  groupId VARCHAR(10) PRIMARY KEY COMMENT 'グループID',
  groupName VARCHAR(40) NOT NULL COMMENT 'グループ名'
);


-- Team
CREATE TABLE teams (
  teamId VARCHAR(10) PRIMARY KEY COMMENT 'チームID',
  groupId VARCHAR(10) NOT NULL COMMENT '所属グループグID',
  teamName VARCHAR(40) NOT NULL COMMENT 'チーム名',
  teamAuthority VARCHAR(40) COMMENT 'チーム権限',
  FOREIGN KEY (groupId) REFERENCES groups (groupId)
);

-- users -> teams -> groups
-- User
CREATE TABLE users (
  userId VARCHAR(10) PRIMARY KEY COMMENT 'アカウントID',
  userName VARCHAR(40) NOT NULL COMMENT 'ユーザ名',
  age Int NOT NULL COMMENT '年齢',
  userType VARCHAR(10) NOT NULL COMMENT 'アカウント分類',
  teamId VARCHAR(10) NOT NULL COMMENT '所属チームID',
  FOREIGN KEY (teamId) REFERENCES teams (teamId)
);


