-- create database albaoneDB;

use albaoneDB;

create table QRtable
(
    id varchar(10) primary key,
    today date, -- 날짜
    intime varchar(20), -- 출근 시간
    quittime varchar(20) -- 퇴근시간
);

insert into QRtable values ('asfd','2022-11-22','asfd','asfd');

select * from QRtable;
select * from QRtable where id = "알바생1";

-- 테이블을 잘못 만들었을 시 삭제용
drop table QRtable;