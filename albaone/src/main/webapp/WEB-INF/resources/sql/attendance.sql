-- 근태 관리 테이블
CREATE TABLE attendance(
	id varchar(15),
	companyName varchar(20),
    businessNumber varchar(15),
    name varchar(10),
    check_in_time datetime,
    check_out_time datetime,
    workHours time,
    FOREIGN KEY(id) REFERENCES user(id),
    CONSTRAINT chk_time CHECK (check_in_time <> check_out_time)
);
select * from attendance;
drop table attendance;
select sum(workHours) from attendance where id='q' and check_in_time >= '2024-08-01' and check_out_time < '2024-09-01';
delete from attendance where check_in_time = "2024-08-22 15:42:03";
SELECT * FROM attendance WHERE id = "q" ORDER BY check_in_time DESC LIMIT 1;
SELECT Sum(workHours) FROM attendance WHERE id="w" AND check_in_time >= "2024-05-26" AND check_out_time <= "2024-08-25";