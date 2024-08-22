CREATE TABLE employee(
	businessNumber varchar(20),
    id varchar(15)
);
select * from employee;
select e.id, u.name
	from employee e
    inner join user u
    on e.id = u.id
    where e.businessNumber = "1";