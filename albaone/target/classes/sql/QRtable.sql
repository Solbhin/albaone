-- create database albaoneDB;

use albaoneDB;

create table QRtable
(
    id varchar(10) primary key,
    todaytime varchar(20) not null
);


select * from QRtable;
select * from QRtable where id = "알바생1";

-- 테이블을 잘못 만들었을 시 삭제용
drop table QRtable;