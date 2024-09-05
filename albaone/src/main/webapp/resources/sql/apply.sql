-- 채용 테이블
CREATE TABLE if not exists Apply(
	id varchar(10),
	resume_number varchar(10),
	apply_id int auto_increment primary key,
	resumetitle varchar(20),
	companyName VARCHAR(20),
	workLocation VARCHAR(50),
	salary INT,
	workHours VARCHAR(20),
	workDays VARCHAR(5),
	jobDescription varchar(200),
	name  VARCHAR(10),
	contact  VARCHAR(15),
	email VARCHAR(50), 
	address VARCHAR(100),
    postNumber int,
    status ENUM('지원 중', '수락', '거절', '공고 없음') DEFAULT '지원 중',
    MyimgName VARCHAR(20)
);
select * from Apply;
drop table Apply;

SHOW COLUMNS FROM Apply LIKE 'status';