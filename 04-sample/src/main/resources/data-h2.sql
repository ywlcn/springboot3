INSERT INTO city(id, name, population) VALUES(1,'Bratislava', 432000);
INSERT INTO city(id, name, population) VALUES(2,'Budapest', 1759000);
INSERT INTO city(id, name, population) VALUES(3,'Prague', 1280000);
INSERT INTO city(id, name, population) VALUES(4,'Warsaw', 1748000);
INSERT INTO city(id, name, population) VALUES(5,'Los Angeles', 3971000);
INSERT INTO city(id, name, population) VALUES(6,'New York', 8550000);
INSERT INTO city(id, name, population) VALUES(7,'Edinburgh', 464000);
INSERT INTO city(id, name, population) VALUES(8,'Suzhou', 4327066);
INSERT INTO city(id, name, population) VALUES(9,'Zhengzhou', 4122087);
INSERT INTO city(id, name, population) VALUES(10,'Berlin', 3671000);

INSERT INTO district(name, cityId) VALUES('district001', 1);
INSERT INTO district(name, cityId) VALUES('district002', 1);
INSERT INTO district(name, cityId) VALUES('district003', 1);
INSERT INTO district(name, cityId) VALUES('district004', 1);

INSERT INTO district(name, cityId) VALUES('district201', 2);
INSERT INTO district(name, cityId) VALUES('district202', 2);
INSERT INTO district(name, cityId) VALUES('district203', 2);
INSERT INTO district(name, cityId) VALUES('district204', 2);

INSERT INTO district(name, cityId) VALUES('district301', 3);
INSERT INTO district(name, cityId) VALUES('district302', 3);
INSERT INTO district(name, cityId) VALUES('district303', 3);
INSERT INTO district(name, cityId) VALUES('district304', 3);

INSERT INTO service_group(service_group_id, service_group_name) VALUES('001', 'Service101');
INSERT INTO service_group(service_group_id, service_group_name) VALUES('002', 'Service102');

INSERT INTO team(team_id, belonging_service_group_id, team_name, team_authority) VALUES('001', '001'  , 'Team001' , 'team_authority001'  );
INSERT INTO team(team_id, belonging_service_group_id, team_name, team_authority) VALUES('002', '001'  , 'Team002' , 'team_authority002'  );
INSERT INTO team(team_id, belonging_service_group_id, team_name, team_authority) VALUES('003', '001'  , 'Team003' , 'team_authority003'  );
INSERT INTO team(team_id, belonging_service_group_id, team_name, team_authority) VALUES('101', '002'  , 'Team101' , 'team_authority101'  );
INSERT INTO team(team_id, belonging_service_group_id, team_name, team_authority) VALUES('102', '002'  , 'Team102' , 'team_authority102'  );
INSERT INTO team(team_id, belonging_service_group_id, team_name, team_authority) VALUES('103', '002'  , 'Team103' , 'team_authority103'  );

INSERT INTO account(account_id, user_name, age, account_type , belonging_service_group_id , belonging_team_id) VALUES('001', 'Name001' , 101 , 'ADMIN' , '001'  , '001');
INSERT INTO account(account_id, user_name, age, account_type , belonging_service_group_id , belonging_team_id) VALUES('002', 'Name002' , 102 , 'ADMIN' , '002'  , '101');
