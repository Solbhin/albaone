-- 사용자 테이블
create table user
(
	id varchar(10) primary key,
    password varchar(20) not null,
    name varchar(10) not null,
    phone char(13),
    email varchar(20),
    businessNumber varchar(20) UNIQUE
);

select * from User;
select id, pw from user;
drop table user;