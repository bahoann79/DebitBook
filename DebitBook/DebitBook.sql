IF DB_ID('DebitBook') IS NOT NULL
BEGIN 
	USE master
	DROP DATABASE DebitBook
END
GO

CREATE DATABASE DebitBook
GO

USE DebitBook
GO

-- TABLE

CREATE TABLE Account 
(
	username		VARCHAR(150),
	[password]		VARCHAR(150),

	CONSTRAINT		PK_username		PRIMARY KEY (username)
)

CREATE TABLE [User]
(
	id				INT				IDENTITY(1,1),
	[name]			VARCHAR(150),
	email			VARCHAR(150),
	[address]		VARCHAR(150),
	phone_number	VARCHAR(50),
	gender			BIT,
	[image]			TEXT,
	isActive		BIT				DEFAULT 0,
	isAdmin			BIT				DEFAULT 0,

	CONSTRAINT		PK_user_id		PRIMARY KEY (id),
	CONSTRAINT		FK_email		FOREIGN KEY (email)			REFERENCES Account(username)
)

CREATE TABLE Debtor
(
	id				INT				IDENTITY(1,1),
	[name]			VARCHAR(150),
	[address]		VARCHAR(150),
	gender			BIT,
	email			VARCHAR(150),
	phone_number	VARCHAR(50),
	createdBy		INT,
	createdAt       DATETIME,
	updatedAt		DATETIME,
	deletedAt		DATETIME,
	isDeleted		BIT				DEFAULT 0,
	total_money		MONEY			DEFAULT 0,

	CONSTRAINT		PK_debtor_id			PRIMARY KEY (id),
	CONSTRAINT		FK_debtor_createdBy		FOREIGN KEY (createdBy)	REFERENCES [User](id)
)


CREATE TABLE OTPRequest
(
	id				INT				IDENTITY(1,1),
	code			VARCHAR(150),
	[type]			VARCHAR(150),
	expired_time	DATETIME,
	isVerify		BIT,
	createdBy		INT,
	createdAt       DATETIME,
	updatedAt		DATETIME,
	deletedAt		DATETIME,
	isDeleted		BIT				DEFAULT 0,

	CONSTRAINT		PK_otp_id		PRIMARY KEY (id),
	CONSTRAINT		FK_user_id		FOREIGN KEY (createdBy)		REFERENCES [User](id)
)

CREATE TABLE Debt
(
	id					INT				IDENTITY(1,1),
	reason				TEXT,
	role_debt			BIT,
	[money]				MONEY,
	debtor_id			INT,
	debtCreatedTime		DATE,
	createdBy			INT,
	createdAt			DATETIME,
	updatedAt			DATETIME,
	deletedAt			DATETIME,
	isDeleted			BIT				DEFAULT 0,

	CONSTRAINT		PK_debt_id			PRIMARY KEY (id),
	CONSTRAINT		FK_debtor_id		FOREIGN KEY (debtor_id)		REFERENCES Debtor(id),
)

CREATE TABLE Email
(
	id				INT			IDENTITY(1,1),
	content			TEXT,
	isSend			BIT,


	CONSTRAINT		PK_emailId	PRIMARY KEY (id),
)

-- INSERT
INSERT INTO Account(username, [password])
VALUES  ('bahoann@gmail.com',		'202cb962ac59075b964b07152d234b70'),
		('trungkien@gmail.com',		'202cb962ac59075b964b07152d234b70'),
		('anhduy@gmail.com',		'202cb962ac59075b964b07152d234b70'),
		('dinhhai@gmail.com',		'202cb962ac59075b964b07152d234b70'),
		('quytruong@gmail.com',		'202cb962ac59075b964b07152d234b70')


INSERT INTO [User]([name], email, [address], phone_number, gender, isActive, isAdmin)
VALUES	('Nguyen Ba Hoan',		'bahoann@gmail.com',	'Hola', '098123123', 1, 1, 0),
		('Nguyen Trung Kien',	'trungkien@gmail.com',	'Hola', '098123124', 1, 1, 0),
		('Ngo Anh Duy',			'anhduy@gmail.com',		'Hola', '098123125', 1, 1, 0),
		('Dinh Hai',			'dinhhai@gmail.com',	'Hola', '098123126', 1, 1, 0),
		('Le Quy Truong',		'quytruong@gmail.com',	'Hola',	'098123127', 1, 1, 0)

INSERT INTO Debtor([name], [address], gender, email, phone_number, createdBy, createdAt)
VALUES  -- con nợ của Hoàn
		('Nguyen Trung Kien', 'Hola',	   1, 'trungkien@gmail.com', '098123124', 1, GETDATE()),
		('Ngo Anh Duy',		  'Hola',	   1, 'anhduy@gmail.com',    '098123125', 1, GETDATE()),
		('Dinh Hai',		  'Hola',	   1, 'dinhhai@gmail.com',   '098123126', 1, GETDATE()),
		-- con nợ của Kiên
		('Ngo Anh Duy',		  'Hola',	   1, 'anhduy@gmail.com',    '098123125', 2, GETDATE()),
		('Dinh Hai',		  'Hola',	   1, 'dinhhai@gmail.com',	 '098123126', 2, GETDATE()),
		-- con nợ của Duy
		('Dinh Hai',		  'Hola',	   1, 'dinhhai@gmail.com',	 '098123126', 3, GETDATE()),
		-- chủ nợ của Duy
		('Quy Truong',		  'Hola',	   1, 'quytruong@gmail.com', '098123127', 3, GETDATE())
GO

-- CREATE Trigger
-- Update filed total_money
CREATE Trigger trg_UpdateTotalMoney
ON Debt AFTER INSERT
AS
BEGIN
	SET NOCOUNT ON
	IF(SELECT role_debt FROM inserted) = 0
		BEGIN
			UPDATE Debtor 
			SET total_money = total_money + (SELECT [money] FROM inserted WHERE Debtor.id = inserted.debtor_id)
			FROM Debtor JOIN inserted ON Debtor.id = inserted.debtor_id
		END

	ELSE 
		BEGIN
			UPDATE Debtor 
			SET total_money = total_money - (SELECT [money] FROM inserted WHERE Debtor.id = inserted.debtor_id)
			FROM Debtor JOIN inserted ON Debtor.id = inserted.debtor_id
		END
END

-- Tạo Trigger xong mới bắt đầu insert các bảng ghi của bảng Debt

-- role_debt: 0 người nợ (+), 1 chủ nợ(-)

-- Test TH1: tạo khoản nợ cho người nợ mình < của Hoàn>
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('rent apartment',	0, 5000, '2022-11-22', 1, 1, GETDATE())
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('hospital fee',	0, 1000, '2023-01-23', 1, 1, GETDATE())
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('buy gold',		0, 400,  '2022-07-11', 2, 1, GETDATE())
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('cost of living',	0, 5000, '2022-09-14', 3, 1, GETDATE())

-- Test TH2: tạo khoản nợ cho người mình vay < của Hoàn>
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('hospital fee',	1, 7000, '2022-03-08', 1, 1, GETDATE())

-- Con nợ của Kiên
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('gambling',	0, 333, '2022-11-11', 4, 2, GETDATE())
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('', 0, 333, '2022-10-23', 5, 2, GETDATE())

-- Con nợ của Duy
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('gambling', 0, 444, '2022-11-24', 6, 3, GETDATE())
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('gambling', 0, 444, '2023-02-11', 6, 3, GETDATE())
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('gambling', 0, 444, '2022-01-13', 6, 3, GETDATE())

-- Chủ nợ của Duy
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('tax fee', 1, 700, '2023-01-07', 7, 3, GETDATE())
INSERT INTO Debt(reason, role_debt, [money], debtCreatedTime, debtor_id, createdBy, createdAt)
VALUES	('tax fee', 1, 123, '2023-03-01', 7, 3, GETDATE())

-- Debtor List
SELECT u.id, u.[name], u.email, u.[address], u.phone_number, u.isActive, u.isAdmin,
	   d.id, d.[name], d.[address], d.gender, d.email, d.phone_number, d.createdAt, d.updatedAt, d.createdBy, d.total_money
FROM [User] u LEFT JOIN Debtor d ON u.id = d.createdBy
WHERE u.id = 1

-- Danh sách những khoản nợ của 1 Debtor cụ thể
SELECT u.[user_id], u.display_name, u.email, u.[address], u.phone_number, u.isActive, u.isAdmin,
	   d.debtor_id, d.debtor_name, d.[address], d.gender, d.email, d.phone_number, d.created_time, d.updated_time, d.created_by, d.total_money,
	   de.debt_id, de.reason, de.role_debt, de.[money], de.created_time
FROM [User] u LEFT JOIN Debtor d ON u.[user_id] = d.created_by
			  LEFT JOIN Debt de  ON de.debtor_id = d.debtor_id
WHERE u.[user_id] = 1 AND d.debtor_id = 1

-- Danh sách những khoản nợ của 1 User cụ thể
SELECT u.[user_id], u.display_name, u.email, u.[address], u.phone_number, u.isActive, u.isAdmin,
	   d.debtor_id, d.debtor_name, d.[address], d.gender, d.email, d.phone_number, d.created_time, d.updated_time, d.created_by, d.total_money,
	   de.debt_id, de.reason, de.role_debt, de.[money], de.created_time
FROM [User] u LEFT JOIN Debtor d ON u.[user_id] = d.created_by
			  LEFT JOIN Debt de  ON de.debtor_id = d.debtor_id
WHERE u.[user_id] = 1


SELECT id, reason, role_debt, [money], debt_createdTime, createdAt
FROM Debt WHERE debtor_id = 1 AND isDeleted = 0

SELECT 
WHERE otp_id = 13 AND isVerify = 0 AND [user_id] = 6
SELECT * FROM EmailRequest
  
-- Login
SELECT a.username,
	   u.id, u.[name], u.email
FROM Account a LEFT JOIN [User] u ON a.username = u.email
WHERE a.username = ? AND a.[password] = ?

-- Forgot Password
SELECT a.username,
		u.id, u.[name], u.email, u.phone_number
FROM Account a LEFT JOIN [User] u ON a.username = u.email
WHERE a.username = ?


SELECT * FROM Account
SELECT * FROM [User]
SELECT * FROM OTPRequest
SELECT * FROM Debtor
SELECT * FROM Debt


