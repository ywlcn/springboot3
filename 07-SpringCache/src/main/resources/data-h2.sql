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



INSERT INTO groups(groupId, groupName) VALUES('001', 'GroupName001');
INSERT INTO groups(groupId, groupName) VALUES('002', 'GroupName002');

INSERT INTO teams(teamId, groupId, teamName, teamAuthority) VALUES('001', '001'  , 'Team001' , 'teamAuthority001'  );
INSERT INTO teams(teamId, groupId, teamName, teamAuthority) VALUES('002', '001'  , 'Team002' , 'teamAuthority002'  );
INSERT INTO teams(teamId, groupId, teamName, teamAuthority) VALUES('003', '001'  , 'Team003' , 'teamAuthority003'  );
INSERT INTO teams(teamId, groupId, teamName, teamAuthority) VALUES('101', '002'  , 'Team101' , 'teamAuthority101'  );
INSERT INTO teams(teamId, groupId, teamName, teamAuthority) VALUES('102', '002'  , 'Team102' , 'teamAuthority102'  );
INSERT INTO teams(teamId, groupId, teamName, teamAuthority) VALUES('103', '002'  , 'Team103' , 'teamAuthority103'  );

INSERT INTO users(userId, userName, age, userType , teamId) VALUES('001', 'Name001' , 101 , 'ADMIN' , '001');
INSERT INTO users(userId, userName, age, userType , teamId) VALUES('002', 'Name002' , 102 , 'ADMIN' , '101');
