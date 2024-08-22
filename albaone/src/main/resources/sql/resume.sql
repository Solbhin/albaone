-- 이력서 테이블
CREATE TABLE if not exists Resume
(
	resume_id varchar(10),  		-- 아이디
	number INT auto_increment PRIMARY KEY, -- 이력서 글 번호
    name VARCHAR(10),           -- 성명
    birthdate DATE,             -- 생년월일
    gender VARCHAR(10),         -- 성별
    contact VARCHAR(15),        -- 연락처 (Tel/H.P.)
    email VARCHAR(50),          -- 이메일
    address VARCHAR(100),       -- 현 주소
    school VARCHAR(100),        -- 학교명
    period VARCHAR(50),         -- 기간
    major VARCHAR(50),          -- 전공
    job_title VARCHAR(100),     -- 직장명
    experience_period VARCHAR(50), -- 경력 기간
    main_work VARCHAR(100),     -- 주요 업무
    reason TEXT,                 -- 지원 동기
    work_hours VARCHAR(20),     -- 근무 시간
    desired_salary VARCHAR(20), -- 희망 시급
    desired_days varchar(20),
    MyimgName VARCHAR(20)		 -- 이미지 이름
);
drop table Resume;
delete from Resume;
select * from Resume;
SELECT * FROM Resume WHERE resume_id = "알바생1";