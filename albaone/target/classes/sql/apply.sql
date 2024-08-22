-- 채용 테이블
CREATE TABLE if not exists Apply(
	id varchar(10), -- 아이디
	resume_number varchar(10),
	apply_id int auto_increment primary key,
	resumetitle varchar(20),
	companyName VARCHAR(20), -- 회사명
	workLocation VARCHAR(50), 
	salary INT, -- 급여
	workHours VARCHAR(20),
	workDays VARCHAR(5),
	jobDescription varchar(200),
	name  VARCHAR(10), -- 이름
	contact  VARCHAR(15), -- 전화번호
	email VARCHAR(50), -- 이메일
	address VARCHAR(100), -- 주소
    postNumber int, 
    status ENUM('지원 중', '수락', '거절') DEFAULT '지원 중'
);
select * from Apply;
drop table Apply;

SHOW COLUMNS FROM Apply LIKE 'status';