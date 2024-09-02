create table Review
(
	ReviewNumber int primary key auto_increment, -- 리뷰 글 넘버
	companyName VARCHAR(20) NOT NULL, -- 회사명
    ratingAvg decimal(2,1), -- 별점
    id varchar(10), -- 개인 회원 아이디
    comment text -- 리뷰
);

select * from Review;
truncate table Review;