CREATE DATABASE TS01101_LAB8;
GO
USE TS01101_LAB8;
GO

CREATE TABLE accounts (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100),
    fullname NVARCHAR(100),
    email NVARCHAR(100)
);

-- Thêm cột trước khi update
ALTER TABLE accounts ADD role NVARCHAR(20);
ALTER TABLE accounts ADD admin BIT DEFAULT 0;

-- Sau đó mới insert và update
INSERT INTO accounts (username, password, fullname, email, role, admin)
VALUES ('admin', '123', N'Quản trị viên', 'admin@gmail.com', 'admin', 1);
