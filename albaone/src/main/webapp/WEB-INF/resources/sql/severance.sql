create table severance(
	id varchar(20),
    businessNumber varchar(20),
    hireDate date,
    resignationDate date,
    period int,
    total3MonthSalary varchar(20),
    averageWage varchar(20),
    severance varchar(20)    
);
drop table severance;
select * from severance;

select s.id, u.name, s.businessNumber, s.hireDate, s.resignationDate, s.period, s.total3MonthSalary, s.averageWage, s.severance
	FROM severance s
    INNER JOIN user u
    ON s.id = u.id
    WHERE s.id = "w" AND s.businessNumber = "1";