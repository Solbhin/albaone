-- 등급 지정
create table Albarate
(
	parttimename varchar(5) primary key, -- 알바생이름
    commute int, -- 출퇴근
    absent int, -- 결근
    blinking int, -- QR 얼마나 깜빡했는지
    company int -- 사측 평가
);
select * from Albarate;
-- read 테스트
select parttimename,commute,absent,blinking,company
				from Albarate where parttimename = "알바생1";
-- 테스트용
drop table Albarate; -- 잘못 만들었을 경우 삭제용