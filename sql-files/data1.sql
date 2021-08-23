create Table user(
	empid int primary key auto_increment,
	emp_username varchar(50) not null,
	emp_password varchar(50) not null
	);
    
create Table points(
	pointsid int primary Key auto_increment,
    	empid int not null,
    	points int,
    	offerid int not null
);


insert into user(empid,emp_username,emp_password) values (1,'Neha','1234');
insert into user(empid,emp_username,emp_password) values (2,'Nivedha','1234');
insert into user(empid,emp_username,emp_password) values (3,'Priya','1234');
insert into user(empid,emp_username,emp_password) values (4,'Ragavi','1234');
insert into user(empid,emp_username,emp_password) values (5,'Abi','1234');
insert into user(empid,emp_username,emp_password) values (6,'Kavi','1234');
insert into user(empid,emp_username,emp_password) values (7,'Ravi','1234');
insert into user(empid,emp_username,emp_password) values (8,'Tanya','1234');
insert into user(empid,emp_username,emp_password) values (9,'Praveen','1234');
insert into user(empid,emp_username,emp_password) values (10,'Madhan','1234');
insert into user(empid,emp_username,emp_password) values (11,'Julian','1234');
insert into user(empid,emp_username,emp_password) values (12,'Justin','1234');
insert into user(empid,emp_username,emp_password) values (13,'Kabir','1234');
insert into user(empid,emp_username,emp_password) values (14,'Randy','1234');
insert into user(empid,emp_username,emp_password) values (15,'Mahir','1234');
