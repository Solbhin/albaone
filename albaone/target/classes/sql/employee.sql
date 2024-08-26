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
    where e.businessNumber = "1";
delete from employee where hireDate is null;
insert into employee values("1", "w", "2023-04-11");
UPDATE employee SET resignationDate = "2024-06-11" WHERE id = "q" AND businessNumber = "1";