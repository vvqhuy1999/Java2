create database QLSINHVIEN;
use QLSINHVIEN;

create table Student(
	MaSV nvarchar(5) not null primary key,
	Hoten nvarchar(50) null,
	Email nvarchar(50) null,
	SoDT nvarchar(10) null,
	GioiTinh bit null,
	DiaChi nvarchar(100) null
);
insert into Student values
('SV001','Le Van Phung','phunglv@fpt.edu.vn','0903414749',0,'Ninh Thuan'),
('SV002','Le Quang Trung','trunglq@fpt.edu.vn','0901234567',0,'222 Le Van Si'),
('SV003','Le Thi Bao Hieu','hieultb@fpt.edu.vn','0683877432',1,'Phan Rang'),
('SV004','Le Thi H Hanh','hanhlth@fpt.edu.vn','0909999999',1,'Quan 12');

select * from Student;