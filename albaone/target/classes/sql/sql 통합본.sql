CREATE database albaoneDB;
drop database albaoneDB;
use albaoneDB;

-- 사용자 테이블
create table user
(
	id varchar(10) primary key,
    password varchar(20) not null,
    name varchar(10) not null,
    phone char(13),
    email varchar(20),
    businessNumber varchar(20) UNIQUE
);
select * from User;
select id, pw from user;
drop table user;

-- 근태 관리 테이블
CREATE TABLE attendance(
	id varchar(15),
	companyName varchar(20),
    businessNumber varchar(15),
    name varchar(10),
    check_in_time datetime,
    check_out_time datetime,
    FOREIGN KEY(id) REFERENCES user(id),
    CONSTRAINT chk_time CHECK (check_in_time <> check_out_time)
);

select * from attendance;
drop table attendance;

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


-- 퇴직금 조회
use albaoneDB;
create table Severance
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

CREATE TABLE empolyee(
	businessNumber varchar(20),
    id varchar(15)
);
select * from empolyee;
insert into empolyee value(1, "알바생1");
insert into empolyee value(1, "알바생2");
insert into empolyee value(1, "알바생3");


-- 등급 지정
use albaoneDB;

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