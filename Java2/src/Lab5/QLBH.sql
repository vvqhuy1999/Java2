create database QLBH;
use QLBH;
go
create table SanPham(
	maSP nvarchar(5) not null primary key,
	tenSP nvarchar(50) not null,
	donGia money not null,
	soLuong int not null,
	maloai int not null
);
go
create table LoaiSanPham(
	MaLoai int not null primary key,
	tenLoai nvarchar(255) null
);
GO
insert into LoaiSanPham values 
(1,N'ĐIỆN THOẠI'),
(2,N'PHỤ KIỆN'),
(3,N'LAPTOP');

insert into SanPham values 
('1',N'Samsung Galaxy J7',1000000,50,1),
('2',N'IPhone 6 32G',2000000,100,1),
('3',N'Laptop Dell Inspiron',20000000,50,3),
('4',N'Pin sạc dự phòng',500000,50,2),
('5',N'Nokia 3100',700000,100,1);

alter table SanPham 
add constraint Fk_SP_LSP 
foreign key (maloai) references LoaiSanPham(MaLoai);