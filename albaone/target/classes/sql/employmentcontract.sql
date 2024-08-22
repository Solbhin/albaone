-- 계약서 테이블
create table employmentcontract
(
	num int auto_increment primary key, -- 조회 순번, dto에 필요 없음
    ownername varchar(10) not null, -- 사업주명 
    parttimename varchar(5), -- 알바생명
    period_start date not null, -- 계약기간-근무시작
    period_end date not null, -- 계약기간-근무종료
    place varchar(10), -- 근로장소
    workdetail varchar(100), -- 업무내용
    workinghours_start varchar(5) not null,-- 근로 시작 시간
    workinghours_end varchar(5) not null,-- 근로 종료 시간
    workday int not null, -- 주당 근무일
    money bigint not null, -- 임금 - 시급, 일급, 월급을 정하거나 미리 데이터베이스를 여러개 만들고 따로 저장하는 것으로 함
    bonus bigint , -- 상여금
    insurance varchar(25),-- 보험
    createdate date-- 작성 날짜
);
select * from employmentcontract;
truncate table employmentcontract;
drop table employmentcontract;