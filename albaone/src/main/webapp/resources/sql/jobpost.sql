-- 공고 테이블
CREATE TABLE if not exists jobpost(
	postNumber INT AUTO_INCREMENT primary key,  -- 게시글 번호
	companyName VARCHAR(20) NOT NULL,			-- 상호명
    workLocation VARCHAR(50) NOT NULL,			-- 근무지 주소
    contactNumber CHAR(15) NOT NULL,			-- 연락처
    salary INT NOT NULL,						-- 급여
    workHours VARCHAR(30) default "시간협의",		-- 근무시간
    workDays VARCHAR(5) default "요일협의",		-- 근무요일
    workDuration varchar(10) not null,			-- 근무기간
    jobDescription varchar(200),				-- 하는 일
    id VARCHAR(20)								-- 작성자 아이디
);
select * from jobpost;
truncate table jobpost;