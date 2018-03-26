CREATE TABLE CRM_Key(
	CRM_Key_id INT IDENTITY(1,1) PRIMARY KEY,
	VARCHAR(50) title NOT NULL,
	VARCHAR(120) content NOT NULL
);

CREATE TABLE CRM_Password(
	CRM_password_id int IDENTITY(1,1) PRIMARY KEY,
	mail VARCHAR(50) UNIQUE,
	password VARCHAR(250)
);

CREATE TABLE CRM_Topic(
	CRM_Topic_id int IDENTITY(1,1) PRIMARY KEY,
	content VARCHAR(128)
);

CREATE TABLE CRM_Client(
	CRM_Client_id int IDENTITY(1,1) PRIMARY KEY,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	mail VARCHAR(50),
	number INT,
	key int FOREIGN KEY references CRM_Key.CRM_Key_id
);

CREATE TABLE CRM_Staff(
	CRM_Staff_id int IDENTITY(1,1) PRIMARY KEY,
	UserPassword VARCHAR(250),
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	mail VARCHAR(50),
	number INT
);

CREATE TABLE CRM_Meeting(
	CRM_Meeting_id int IDENTITY(1,1) PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	date DATETIME NOT NULL,
	place VARCHAR(128) NOT NULL
	);

CREATE TABLE CRM_Meeting_Staffs(
	CRM_Meeting_staff_id int IDENTITY(1,1) PRIMARY KEY,
	meeting int FOREIGN KEY REFERENCES CRM_Meeting(CRM_Meeting_id),
	staff int FOREIGN KEY REFERENCES CRM_Staff(CRM_Staff_id)
);

CREATE TABLE CRM_Meeting_Topics(
	CRM_Meeting_staff_id IDENTITY(1,1) PRIMARY KEY,
	meeting int REFERENCES(CRM_Meeting.CRM_Meeting_id),
	topic int REFERENCES(CRM_Topic.CRM_topic_id)
);

CREATE TABLE CRM_Action(
	CRM_Action_id int IDENTITY(1,1) PRIMARY KEY,
	text TEXT,
	deadline DATETIME,
	comment TEXT,
	staff int FOREIGN KEY REFERENCES CRM_Staff(CRM_Staff_id)
);