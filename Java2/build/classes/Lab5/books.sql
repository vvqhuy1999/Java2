create database Library;

use Library;

go 
create table books (
	id int identity primary key,
	title nvarchar(50),
	price float
)
go 
insert into books (title,price) values 
(N'Lập trình C',100),
(N'Lập trình Java',200),
(N'Lập trình C#',150);