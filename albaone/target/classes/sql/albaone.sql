CREATE database albaoneDB;
create table user(
	id varchar(10) primary key,
    pw varchar(20) not null,
    name varchar(10) not null,
    phone char(13),
    eamil varchar(20),
    businessNumber varchar(20)
    );
select * from User;
select id, pw from user;