create database QuanLySach;

use QuanLySach;

create table Sach(
	masach varchar(20) primary key,
	tensach varchar(50),
	gia float,
	namxb int
);

insert into Sach values
('s01','Bai tap Java', 55,2022),
('s02','Lap trinh c', 12,2021),
('s03','Tho To Huu', 121.6,2021),
('s04','Hon dat', 70,2020),
('s05','Bai tap C', 500,2022);

select * from sach;