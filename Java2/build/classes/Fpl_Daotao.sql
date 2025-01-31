USE [FPL_DaoTao]
GO
/****** Object:  Table [dbo].[GRADE]    Script Date: 3/20/2024 8:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GRADE](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MASV] [nvarchar](50) NULL,
	[TiengAnh] [decimal](4, 2) NULL,
	[TinHoc] [decimal](4, 2) NULL,
	[GDTC] [decimal](4, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[STUDENTS]    Script Date: 3/20/2024 8:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[STUDENTS](
	[MASV] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[SoDT] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Hinh] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MASV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USERS]    Script Date: 3/20/2024 8:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERS](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[role] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[GRADE] ON 

INSERT [dbo].[GRADE] ([ID], [MASV], [TiengAnh], [TinHoc], [GDTC]) VALUES (1, N'PS0001', CAST(10.00 AS Decimal(4, 2)), CAST(5.00 AS Decimal(4, 2)), CAST(5.00 AS Decimal(4, 2)))
INSERT [dbo].[GRADE] ([ID], [MASV], [TiengAnh], [TinHoc], [GDTC]) VALUES (2, N'PS0002', CAST(8.00 AS Decimal(4, 2)), CAST(8.00 AS Decimal(4, 2)), CAST(6.50 AS Decimal(4, 2)))
INSERT [dbo].[GRADE] ([ID], [MASV], [TiengAnh], [TinHoc], [GDTC]) VALUES (3, N'PS0003', CAST(6.00 AS Decimal(4, 2)), CAST(9.00 AS Decimal(4, 2)), CAST(9.00 AS Decimal(4, 2)))
INSERT [dbo].[GRADE] ([ID], [MASV], [TiengAnh], [TinHoc], [GDTC]) VALUES (4, N'PS0004', CAST(5.00 AS Decimal(4, 2)), CAST(6.00 AS Decimal(4, 2)), CAST(7.25 AS Decimal(4, 2)))
INSERT [dbo].[GRADE] ([ID], [MASV], [TiengAnh], [TinHoc], [GDTC]) VALUES (5, N'PS0005', CAST(8.00 AS Decimal(4, 2)), CAST(10.00 AS Decimal(4, 2)), CAST(5.00 AS Decimal(4, 2)))
INSERT [dbo].[GRADE] ([ID], [MASV], [TiengAnh], [TinHoc], [GDTC]) VALUES (6, N'PS0006', CAST(8.00 AS Decimal(4, 2)), CAST(7.00 AS Decimal(4, 2)), CAST(7.00 AS Decimal(4, 2)))
INSERT [dbo].[GRADE] ([ID], [MASV], [TiengAnh], [TinHoc], [GDTC]) VALUES (7, N'PS0007', CAST(8.00 AS Decimal(4, 2)), CAST(7.00 AS Decimal(4, 2)), CAST(8.00 AS Decimal(4, 2)))
SET IDENTITY_INSERT [dbo].[GRADE] OFF
GO
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh]) VALUES (N'PS0001', N'Nguyễn Văn Nam', N'namnguyen0932@gmail.com', N'0971711555', 1, N'1023 Đường Quang Trung Phường 12 Quận Gò Vấp', N'imagesflower_1.jpg')
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh]) VALUES (N'PS0002', N'Nguyễn Thị Hạ', N'hahanguyen32@gmail.com', N'0911916916 ', 0, N'12 Đường Lâm Văn Bền Phường Tân Quy Quận 7', N'castle.jpg')
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh]) VALUES (N'PS0003', N'Trần Quốc Hiếu', N'quoctungt030930@gmail.com', N'0961053049', 1, N'148/2/3/4 Đường Võ Văn Ngân Phường 2 Quận Thủ Đức', N'dog.jpg')
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh]) VALUES (N'PS0004', N'Lê Hồng Ngọc', N'ngoclhlt3402@gmail.com', N'0792053049', 0, N'18 Đường B1  Phường Tây Thạnh Quận Tân Phú', N'duck.jpg')
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh]) VALUES (N'PS0005', N'Hồ Bích Trâm', N'hbt123c@gmail.com', N'0868660080', 0, N'18 Phan Văn Trị Phường 10 Quận Gò Vấp', N'imagesflower_1.jpg')
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh]) VALUES (N'PS0006', N'Nguyễn Trần Nam', N'longpt3042@gmail.com', N'0901963678', 1, N'28 Đường Thống Nhất Phường 11 Quận Gò Vấp', N'mammal.jpg')
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh]) VALUES (N'PS0007', N'Trần Khánh Dũng', N'dungtrankhanh@gmail.com', N'0963385382', 1, N'551/2 Đường Phạm Văn Chí Phường 7 Quận 6', N'tiger.jpg')
GO
INSERT [dbo].[USERS] ([username], [password], [role]) VALUES (N'user01', N'user01', N'admin')
INSERT [dbo].[USERS] ([username], [password], [role]) VALUES (N'user02', N'user02', N'manager')
INSERT [dbo].[USERS] ([username], [password], [role]) VALUES (N'user03', N'user03', N'user')
INSERT [dbo].[USERS] ([username], [password], [role]) VALUES (N'user04', N'user04', N'user')
GO
ALTER TABLE [dbo].[GRADE]  WITH CHECK ADD FOREIGN KEY([MASV])
REFERENCES [dbo].[STUDENTS] ([MASV])
GO
