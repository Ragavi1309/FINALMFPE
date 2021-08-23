create database mfpe;
use mfpe;
drop database mfpe;

drop table if exists liked_by;
drop table if exists offer;
drop table if exists employee;

create table Employee(
    id int primary key auto_increment,
    name varchar(50) not null,
    department varchar(50),
    gender varchar(6) not null,
    age int not null,
    contact_number Bigint,
    email varchar(100) unique,
    points_gained int default 0,
    check (gender in ('male','female','other')),
    check ( age > 0 )
);

create table Offer(
	id int primary key auto_increment,
    name varchar(50) not null,
    description varchar(100),
    category varchar(50) not null,
    open_date timestamp default now(),
    closed_date timestamp,
    engaged_date timestamp,
    engaged_emp_id int,
    emp_id int not null,
    likes int default 0,
    foreign key(engaged_emp_id) references Employee(id) on delete cascade,
    foreign key(emp_id) references Employee(id) on delete cascade
);

create table liked_by(
	emp_id int,
    offer_id int,
    liked_on timestamp default now(),
    primary key(emp_id,offer_id),
    foreign key(emp_id) references Employee(id) on delete cascade,
    foreign key(offer_id) references Offer(id) on delete cascade
);

insert into Employee(id,name,department,gender,age,contact_number,email) values(1,'Neha','Marketing','female',22,9876543210,'neha@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(2,'Nivedha','Hr','female',22,9876543211,'nivedha@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(3,'Priya','Hr','female',22,9876543212,'priya@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(4,'Ragavi','Hr','female',22,9876543213,'ragavi@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(5,'Abi','Marketing','female',28,9876543214,'abi@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(6,'Kavi','Operations','female',26,9876543215,'kavi@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(7,'Ravi','Finance','male',27,9876543216,'ravi@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(8,'Tanya','Marketing','female',25,9876543217,'tanya@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(9,'Praveen','Operations','male',33,9876543218,'praveen@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(10,'Madhan','Purchase','male',44,9876543219,'madhan@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(11,'Julian','Finance','male',45,9876543220,'julian@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(12,'Justin','Purchase','male',37,9876543221,'justin@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(13,'Kabir','Operations','male',29,9876543223,'kabir@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(14,'Randy','Finance','male',25,9876543224,'randy@gmail.com');
insert into Employee(id,name,department,gender,age,contact_number,email) values(15,'Mahir','Operations','male',24,98765432125,'mahir@gmail.com');

insert into Offer(id,name,description,category,emp_id) values(1,'E1-offer 1' ,'TV','electronics',1);
insert into Offer(id,name,description,category,emp_id) values(2,'E1-offer 2' ,'wooden table','furniture',1);
insert into Offer(id,name,description,category,emp_id) values(3,'E2-offer 1' ,'Car','rental',2);
insert into Offer(id,name,description,category,emp_id) values(4,'E2-offer 2' ,'chair','furniture',2);
insert into Offer(id,name,description,category,emp_id) values(5,'E3-offer 1' ,'Fridge','electronics',3);
insert into Offer(id,name,description,category,emp_id) values(6,'E4-offer 1' ,'sofa','furniture',4);
insert into Offer(id,name,description,category,emp_id) values(7,'E4-offer 2' ,'Bed','furniture',4);
insert into Offer(id,name,description,category,emp_id) values(8,'E5-offer 1' ,'Mens-watch','accessories',5);
insert into Offer(id,name,description,category,emp_id) values(9,'E6-offer 1' ,'Headsets','accessories',6);
insert into Offer(id,name,description,category,emp_id) values(10,'E8-offer 1' ,'Apartment','rental',8);
insert into Offer(id,name,description,category,emp_id) values(11,'E8-offer 2' ,'Smart watch','accessories',8);
insert into Offer(id,name,description,category,emp_id) values(12,'E9-offer 1' ,'plastic-chair','furniture',9);
insert into Offer(id,name,description,category,emp_id) values(13,'E12-offer 1' ,'Travel bag','accessories',12);
insert into Offer(id,name,description,category,emp_id) values(14,'E14-offer 1' ,'computer','electronics',14);
insert into Offer(id,name,description,category,closed_date,emp_id) values(15,'E15-offer 1' ,'Bamboo furniture','furniture','2021-08-11 09:00:00',15);
insert into Offer(id,name,description,category,closed_date,emp_id) values(16,'E15-offer 2' ,'Teak furniture','furniture','2021-08-12',15);

insert into liked_by(emp_id, offer_id) values(1,1);
insert into liked_by(emp_id, offer_id) values(2,1);
insert into liked_by(emp_id, offer_id) values(3,3);
insert into liked_by(emp_id, offer_id) values(3,4);
insert into liked_by(emp_id, offer_id) values(2,2);