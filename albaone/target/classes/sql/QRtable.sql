-- create database albaoneDB;

use albaoneDB;

CREATE TABLE QRtable
(
    -- QR의 url을 저장하기 위한 변수
    QRurl varchar(200) NOT NULL,
    id varchar(10) PRIMARY KEY,
    todaytime varchar(20) NOT NULL
);


select * from QRtable;
select * from QRtable where id = "알바생1";

-- 테이블을 잘못 만들었을 시 삭제용
drop table QRtable;