-- 근태 관리 테이블
CREATE TABLE attendance(
	id varchar(15),
	companyName varchar(20),
    businessNumber varchar(15),
    name varchar(10),
    check_in_time datetime,
    check_out_time datetime,
    workHours time,
    reason text, -- 사유, 사유가 있으면 출근은 아니지만 등급에선 출근으로 인정, 월급계산에선 출근X null값 허용
    edit char(4), -- 수정시 null 체크, null 아닌 행의 개수를 셀 예정
    FOREIGN KEY(id) REFERENCES user(id),
    CONSTRAINT chk_time CHECK (check_in_time <> check_out_time)
);
select * from attendance;
drop table attendance;
select sum(workHours) from attendance where id='q' and check_in_time >= '2024-08-01' and check_out_time < '2024-09-01';
delete from attendance where check_in_time = "2024-08-22 15:42:03";
SELECT * FROM attendance WHERE id = "q" ORDER BY check_in_time DESC LIMIT 1;
SELECT Sum(workHours) FROM attendance WHERE id="w" AND check_in_time >= "2024-05-26" AND check_out_time <= "2024-08-25";

alter table attendance add column reason text;
alter table attendance add column edit char(4);

INSERT INTO attendance(id, businessNumber, check_in_time, check_out_time, workHours)
	VALUES("알바생1", "8459201902", '2024-10-01 01:23:00', '2024-10-01 03:22:00', '00:10:00');

truncate table attendance;


-- 사유 조회
SELECT 
a.id, j.companyName, a.businessNumber, u.name, a.check_in_time, a.check_out_time, a.workHours , a.reason , a.edit
				FROM attendance a 
				INNER JOIN user u ON a.id = u.id
				INNER JOIN jobPost j ON a.businessNumber = j.businessNumber
				WHERE a.id = "알바생1";
                
UPDATE attendance SET edit = "edit"
WHERE id = "알바생1" AND businessNumber = "8459201902" AND check_in_time = "2024-09-05 00:00:00";

SELECT a.id, j.companyName, a.businessNumber, u.name, a.check_in_time, a.check_out_time , a.reason ,a.edit
				FROM attendance a
				inner join user u on a.id = u.id
				INNER JOIN jobPost j ON a.businessNumber = j.businessNumber
				WHERE a.businessNumber = "8459201902";