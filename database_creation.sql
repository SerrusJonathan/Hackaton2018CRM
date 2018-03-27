CREATE TABLE CRM_Key(
	CRM_Key_id INT AUTO_INCREMENT PRIMARY KEY,
	VARCHAR(50) title NOT NULL,
	VARCHAR(120) content NOT NULL
);

CREATE TABLE CRM_Password(
	CRM_password_id int AUTO_INCREMENT PRIMARY KEY,
	mail VARCHAR(50) UNIQUE,
	password VARCHAR(250)
);

CREATE TABLE CRM_Topic(
	CRM_Topic_id int AUTO_INCREMENT PRIMARY KEY,
	content VARCHAR(128)
);

CREATE TABLE CRM_Client(
	CRM_Client_id int AUTO_INCREMENT PRIMARY KEY,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	mail VARCHAR(50),
	number INT,
	key int
);

CREATE TABLE CRM_Staff(
	CRM_Staff_id int AUTO_INCREMENT PRIMARY KEY,
	UserPassword VARCHAR(250),
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	mail VARCHAR(50),
	number INT
);

CREATE TABLE CRM_Meeting(
	CRM_Meeting_id int AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	date DATETIME NOT NULL,
	place VARCHAR(128) NOT NULL
	);

CREATE TABLE CRM_Meeting_Staffs(
	CRM_Meeting_staff_id int AUTO_INCREMENT PRIMARY KEY,
	meeting int,
	staff int
);

CREATE TABLE CRM_Meeting_Topics(
	CRM_Meeting_staff_id AUTO_INCREMENT PRIMARY KEY,
	meeting int,
	topic int
);

CREATE TABLE CRM_Action(
	CRM_Action_id int AUTO_INCREMENT PRIMARY KEY,
	text TEXT,
	deadline DATETIME,
	comment TEXT,
	staff int
);