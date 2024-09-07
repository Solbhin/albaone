CREATE TABLE employee(
	businessNumber varchar(20),
    id varchar(15),
    hireDate date,
    resignationDate date
);

alter table employee add column resignationDate date;
select * from employee;
select e.id, u.name, e.hireDate
	from employee e
    inner join user u
    on e.id = u.id
    where e.businessNumber = "1" and e.resignationDate is null;
delete from employee where hireDate is null;
insert into employee values("1", "w", "2023-04-11");
UPDATE employee SET resignationDate = "2024-06-11" WHERE id = "q" AND businessNumber = "1";

SELECT e.id, u.name, e.hireDate, e.resignationDate
	FROM employee e
    INNER JOIN user u
    ON e.id = u.id
    WHERE e.businessNumber = "1" AND e.resignationDate is NOT NULL;
    
update employee set hireDate = "2024-05-08" where hireDate = "2023-05-08";
SELECT e.id, u.name, e.hireDate, e.resignationDate
	FROM employee e
    INNER JOIN user u
    ON e.id = u.id
    WHERE e.id = "q" AND e.businessNumber = "1" AND e.resignationDate is NOT NULL;
SELECT e.businessNumber, e.id, u.name, e.hireDate, e.resignationDate
	FROM employee e
    INNER JOIN user u
    ON e.id = u.id
    WHERE e.id = "w" AND e.resignationDate IS NOT NULL;
    
insert into employee values("2", "q", "2023-01-01", "2024-08-28");

delete from employee where id = "1";