
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
CREATE TABLE service_group (
  service_group_id VARCHAR(10) PRIMARY KEY COMMENT 'サービスグループID',
  service_group_name VARCHAR(40) NOT NULL COMMENT 'サービスグループ名'
);


-- Team
CREATE TABLE team (
  team_id VARCHAR(10) PRIMARY KEY COMMENT 'チームID',
  belonging_service_group_id VARCHAR(10) NOT NULL COMMENT '所属サービスグループグID',
  team_name VARCHAR(40) NOT NULL COMMENT 'チーム名',
  team_authority VARCHAR(40) COMMENT 'チーム権限',
  FOREIGN KEY (belonging_service_group_id) REFERENCES service_group (service_group_id)
);
-- Account Table
CREATE TABLE account (
  account_id VARCHAR(10) PRIMARY KEY COMMENT 'アカウントID',
  user_name VARCHAR(40) NOT NULL COMMENT 'ユーザ名',
  age Int NOT NULL COMMENT '年齢',
  account_type VARCHAR(10) NOT NULL COMMENT 'アカウント分類',
  belonging_service_group_id VARCHAR(10) NOT NULL COMMENT '所属サービスグループID',
  belonging_team_id VARCHAR(10) NOT NULL COMMENT '所属チームID',
  FOREIGN KEY (belonging_service_group_id) REFERENCES service_group (service_group_id),
  FOREIGN KEY (belonging_team_id) REFERENCES team (team_id)
);


