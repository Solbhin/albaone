reate table Severance
(
	num int primary key auto_increment, -- 단순 숫자(의미 없음 - 기본키용)
	parttimename varchar(5), -- 알바생
    company varchar(20), -- 상호명
    money bigint, -- 퇴직금
    companyNum char(10) -- 사업자 등록번호
);
select * from Severance;
select * from Severance where companyNum = "사업자 번호"; -- 사장 알바 퇴직금 조회 확인용  
select * from Severance where parttimename="알바생명"; -- 알바 퇴직금 조회 확인용 
drop table Severance;