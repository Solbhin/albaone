-- 계약서 테이블
create table employmentcontract
(
	num int primary key auto_increment, -- 삭제용 번호
    ownername varchar(10) not null, -- 사업주명 
    businessNumber varchar(10) not null, -- 사업자 번호
    ownerPhone char(11) not null, -- 사업자 전화번호
    owneraddr varchar(40) not null, -- 사업주 주소
    parttimename varchar(5) not null, -- 알바생명
    parttimePhone char(11), -- 알바생 전화번호
    parttimeaddr varchar(40) not null, -- 알바생 주소
    period_start date not null, -- 계약기간-근무시작
    period_end date not null, -- 계약기간-근무종료
    place varchar(10), -- 근로장소
    workdetail text, -- 업무내용
    workinghours_start varchar(10) not null,-- 근로 시작 시간
    workinghours_end varchar(10) not null,-- 근로 종료 시간
    workday varchar(15) not null, -- 주당 근무일
    money bigint not null, -- 임금 - 시급, 일급, 월급을 정하거나 미리 데이터베이스를 여러개 만들고 따로 저장하는 것으로 함
    bonus bigint , -- 상여금
    insurance varchar(25),-- 보험
    sinefilenameowner varchar(20), -- 파일경로(사업주)
    sinefilenameparttime varchar(20), -- 파일경로(알바생)
    createdate date-- 작성 날짜
);
select * from employmentcontract;
truncate table employmentcontract;
drop table employmentcontract;