CREATE database albaoneDB;
create table user(
	id varchar(10) primary key,
    password varchar(20) not null,
    name varchar(10) not null,
    phone char(13),
    email varchar(20),
    businessNumber varchar(20)
    );
select * from User;
select id, pw from user;

CREATE TABLE Resume (
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
    desired_days VARCHAR(20),     -- 희망 휴일
    MyimgName VARCHAR(20)         -- 이미지 이름
);

drop table Resume;

select * from Resume;

CREATE TABLE if not exists jobpost(
	postNumber INT AUTO_INCREMENT,
	companyName VARCHAR(20) NOT NULL,
    workLocation VARCHAR(50) NOT NULL,
    contactNumber CHAR(15) NOT NULL,
    salary INT NOT NULL,
    workHours VARCHAR(30) default "시간협의",
    workDays VARCHAR(5) default "요일협의",
    workDuration varchar(10) not null,
    jobDescription varchar(200)
);
    
    