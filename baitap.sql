CREATE DATABASE t3h;
USE t3h;
CREATE TABLE LopHoc (
                        MaLop INT AUTO_INCREMENT PRIMARY KEY,
                        TenLop VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE SinhVien (
                          MaSV INT AUTO_INCREMENT PRIMARY KEY,
                          HoTen VARCHAR(100) NOT NULL,
                          NgaySinh DATE,
                          Email VARCHAR(100) UNIQUE,
                          HocPhi DECIMAL(10,2) DEFAULT 0 CHECK (HocPhi >= 0),
                          MaLop INT,
                          FOREIGN KEY (MaLop) REFERENCES LopHoc(MaLop)
);

INSERT INTO LopHoc (TenLop) VALUES
                                ('Java Backend'),
                                ('Frontend React'),
                                ('Data Analyst'),
                                ('Mobile Flutter');

INSERT INTO SinhVien (HoTen, NgaySinh, Email, HocPhi, MaLop) VALUES
                                                                 ('Nguyen Van Anh', '2000-05-15', 'anhnv@gmail.com', 2500, 1),
                                                                 ('Tran Quang Huy', '1998-10-20', 'huytq@gmail.com', 4500, 1),
                                                                 ('Le Thi Mai', '2001-01-12', 'mailt@gmail.com', 1500, 2),
                                                                 ('Pham Quang Minh', '1999-12-30', 'minhpq@gmail.com', 3500, 2),
                                                                 ('Vu Hoang Yen', '2002-03-25', 'yenvh@gmail.com', 5500, 1),
                                                                 ('Nguyen Ngoc An', '2000-08-08', 'annn@gmail.com', 2000, 3),
                                                                 ('Do Quang Dat', '1997-06-18', 'datdq@gmail.com', 6000, 3),
                                                                 ('Bui Bich Phuong', '2001-11-22', 'phuongbb@gmail.com', 4000, NULL);

SELECT * FROM SinhVien;

SELECT HoTen, Email
FROM SinhVien
WHERE HocPhi > 3000;

SELECT *
FROM SinhVien
WHERE NgaySinh BETWEEN '2000-01-01' AND '2000-12-31';

SELECT *
FROM SinhVien
WHERE HoTen LIKE '% Quang %';

SELECT *
FROM SinhVien
ORDER BY HocPhi DESC
    LIMIT 3;

UPDATE SinhVien
SET HocPhi = 2000
WHERE HoTen = 'Le Thi Mai';

UPDATE SinhVien
SET HocPhi = HocPhi * 1.10
WHERE MaLop = 1;

DELETE FROM SinhVien
WHERE MaSV = 8;

SELECT * FROM SinhVien;

SELECT COUNT(*) AS TongSinhVien
FROM SinhVien;

SELECT
    AVG(HocPhi) AS HocPhiTrungBinh,
    MAX(HocPhi) AS HocPhiCaoNhat,
    MIN(HocPhi) AS HocPhiThapNhat
FROM SinhVien;

SELECT MaLop, COUNT(*) AS SoLuongSinhVien
FROM SinhVien
GROUP BY MaLop;

SELECT MaLop, SUM(HocPhi) AS TongHocPhi
FROM SinhVien
GROUP BY MaLop
HAVING SUM(HocPhi) > 5000;

SELECT sv.HoTen, sv.Email, lh.TenLop
FROM SinhVien sv
         INNER JOIN LopHoc lh ON sv.MaLop = lh.MaLop;

SELECT lh.TenLop, sv.HoTen
FROM LopHoc lh
         LEFT JOIN SinhVien sv ON lh.MaLop = sv.MaLop;

SELECT *
FROM SinhVien
WHERE HocPhi > (
    SELECT AVG(HocPhi)
    FROM SinhVien
);

SELECT MaLop, TenLop
FROM LopHoc
WHERE MaLop IN (
    SELECT MaLop
    FROM SinhVien
    WHERE HoTen LIKE 'Nguyen%'
);

SELECT Email
FROM SinhVien

UNION

SELECT 'giangvien1@gmail.com'
UNION
SELECT 'giangvien2@gmail.com'
UNION
SELECT 'giangvien3@gmail.com';