INSERT INTO SINHVIEN (masv, tensv, gioitinh, ngaysinh, anh, diachi, sodienthoai, dantoc, email, nienkhoa, cmnd, pass, role, allow)
VALUES
('admin', 'Trần Văn Trí', 'Nam', '2002-02-02', 'anh2.png', 'Long An', '0387653312', 'kinh', 'tranvantri270802@gmail.com', '2020 - 2023', '079202026277', '1', 'admin', false),
('20-0-00322', 'Gia Minh Khôi', 'Nam', '2003-01-02', 'anh3.png', '234 Đọc Lập, P.Tân Thành Q.Tân Phú', '0258744236', 'Kinh', 'minhkhoi@gmail.com', '2020 - 2023', '079202026277', '123', 'user', true),
('20-0-00111', 'Nguyễn Trúc Linh', 'Nữ', '2003-01-02', 'anh11.png', '138/8 P.12 Q.Tân Bình', '0155874563', 'kKnh', 'truclinh@gmail.com', '2020 - 2023', '0158774663336', '123', 'user', true),
('20-0-00222', 'Bùi Hoàng Minh', 'Nam', '2003-01-02', 'anh4.png', '35/16 Nguyễn Phúc Chu P.15 Q.Tân Bình', '0578854123', 'Kinh', 'hoangminh@gmail.com', '2020 - 2023', '078966541236', '123', 'user', true),
('20-0-00333', 'Nguyễn Minh Quang', 'Nam', '2003-01-02', 'anh5.png', '179/11 P.15 Q.Bình Thạnh', '0356998745', 'Kinh', 'minhquang@gmail.com', '2020 - 2023', '0255479999874', '123', 'user', true),
('20-0-00444', 'Lê Thị Quỳnh Anh', 'Nữ', '2003-01-02', 'anh6.png', '49/19/6 Nguyễn Bỉnh Khiêm', '0355478411', 'Kinh', 'quynhanh@gmail.com', '2020 - 2023', '079202026277', '123', 'user', true),
('20-0-00555', 'Đỗ Mai Ái Linh', 'Nữ', '2003-01-02', 'anh8.png', '192 Đại lộ 3 Thành phố Thủ Đức', '0544789633', 'Kinh', 'ailinh@gmail.com', '2020 - 2023', '079202026277', '123', 'user', true),
('20-0-00666', 'Nguyễn Yến Duyên', 'Nữ', '2003-01-02', 'anh9.png', '84/19 Ngô Chí Quốc P.Bình Chiểu', '0355664412', 'Kinh', 'yenduyen@gmail.com', '2020 - 2023', '079202026277', '123', 'user', true),
('20-0-00777', 'Cao Thái Sơn', 'Nam', '2003-01-02', 'anh7.png', '686/8 quốc lộ 13 P.Hiệp Bình Phước', '0577896541', 'Kinh', 'thaison@gmail.com', '2020 - 2023', '079202026277', '123', 'user', true),
('20-0-00888', 'Trần Quang Mạnh', 'Nam', '2003-01-02', 'anh12.png', 'B15/20 Quốc lộ 50 xã Bình Hưng ', '0387653312', 'kinh', 'xuantruong@gmail.com', '2020 - 2023', '079202026277', '123', 'user', true),
('20-0-00999', 'Nguyễn Hoài Thu', 'Nữ', '2003-01-02', 'anh10.png', '301 Trần Hưng Đạo P.Cái Khế Q.Ninh Kiều', '0787985241', 'Kinh', 'hoaithu@gmail.com', '2020 - 2023', '079202026277', '123', 'user', true);

INSERT INTO KHOA (makhoa,tenkhoa)
VALUES 
('MK001','Khoa IT'),
('MK002','KhoaDu Lịch và Ẩm Thực'),
('MK003','Khoa Công Nghệ Thực Phẩm'),
('MK004','Khoa Công Nghệ May'),
('MK005','Khoa Sinh Học Môi Trường'),
('MK006','Khoa Công Nghệ Hóa Học'),
('MK007','Khoa Kinh Doanh Quản Lí'),
('MK008','Khoa Học và Nghệ Thuật'),
('MK009','Khoa Chính Trị luật'),
('MK010','Khoa Công Nghệ Cơ Khí'),
('MK011','Khoa Điều Dưỡng'),
('MK012','Khoa Ngôn ngữ');

INSERT INTO LOP (tenlop,malop,makhoa)
VALUES 
('LTA','Lập trình máy tính A',1),
('LTB','Lập trình máy tính B',1),
('AVA','Anh Văn A',12),
('AVB','Anh Văn B',12),
('MKA','Marketing A',7),
('MKB','Marketing B',7),
('NHA','Nhà hàng Khách sạn A',7),
('NHB','Nhà hàng khách sạn B',7),
('CKA','Cơ khí A',10),
('CKB','Cơ Khí B',10);

INSERT INTO GIAOVIEN(magv,tengv,chuyennghanh,diachi, gioitinh,makhoa)
VALUES
('GV001','Nguyễn Thị Lệ' ,'Lập Trình Máy Tính','TPHCM','Nữ',1),
('GV002','Nguyễn Thị Lệ Anh' ,'Dinh Dưỡng','TPHCM','Nữ',11),
('GV003','Phạm Minh Khoa' ,'Du Lịch','TPHCM','Nữ',2),
('GV004','Trần Thanh Tú' ,'Quản Trị Nhân Sự','TPHCM','Nữ',7),
('GV005','Cao Minh Thông' ,'Ngôn Ngữ Anh','TPHCM','Nữ',12),
('GV006','Huỳnh Nhất Nam' ,'Marketing','TPHCM','Nữ',2),
('GV007','Nguyễn Thị Kim Nga' ,'Công Nghệ Thực Phẩm','TPHCM','Nữ',3),
('GV008','Trần Thị Linh Chi' ,'Luật','TPHCM','Nữ',9),
('GV009','Huỳnh Thị Bé An' ,'Thiết Kế Đồ Họa','TPHCM','Nữ',1),
('GV010','Trần Minh Anh' ,'Kỹ Thuật Chế Tạo','TPHCM','Nữ',1),
('GV011','Nguyễn Thị Ánh Tuyết' ,'Logistics','TPHCM','Nữ',10);

INSERT INTO MONHOC(mamh,tenmh,sogio)
VALUES
('MH001','Lập Trình Font-end','90'),
('MH002','Toán Rời Rạc','60'),
('MH003','Anh Văn 1','60'),
('MH004','Hóa Hữa Cơ','90'),
('MH005','Tư Vấn Dinh Dưỡng','90'),
('MH006','Thực Phẩm Có lợi','90'),
('MH007','Độc Tố','90'),
('MH008','Adobe InDesign','90'),
('MH009','Luật Tố Tụng Dân Sự','90'),
('MH010','Quản Trị Kinh Doanh Lữ Hành','90'),
('MH11','Cơ sở dữ liệu','90'),
('MH12','Lập trình căn bản','90');



INSERT INTO thoikhoabieu(thu, giobatdau, gioketthuc,phong,monhoc,giaovien)
VALUES 
('Thứ 2', '09:00' , '11:00','107',1,1),
('Thứ 3', '10:00' ,' 11:00','202',2,2),
('Thứ 2', '09:00' , '11:00','107',4,3),
('Thứ 3', '10:00' ,' 11:00','202',5,4),
('Thứ 2', '09:00' , '11:00','107',7,5),
('Thứ 4', '10:00' ,' 11:00','202',9,6),
('Thứ 5', '09:00' , '11:00','107',3,7),
('Thứ 6', '10:00' ,' 11:00','202',3,8),
('Thứ 7', '09:00' , '11:00','107',1,9),
('Thứ 7', '10:00' ,' 11:00','202',2,2);
















