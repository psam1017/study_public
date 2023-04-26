-- ajax 예제 실습

CREATE DATABASE sample_jsp_todo_ajax;

CREATE TABLE todo_list
(
	num			INT(11)					NOT NULL	AUTO_INCREMENT PRIMARY KEY,
    item		VARCHAR(255)			NULL		DEFAULT NULL,
    isChecked	ENUM('true', 'false')	NULL		DEFAULT 'false',
    insertDate	DATETIME				NULL		DEFAULT NULL
);

SELECT * FROM todo_list;

-- MVC와 DB 연동 예제(library) 실습

CREATE TABLE TBL_BOOK
(
	`bookCode`			VARCHAR(3)			NOT NULL PRIMARY KEY,
    title			VARCHAR(255)		NOT NULL,
    author			VARCHAR(31)		NOT NULL,
    originStock		SMALLINT UNSIGNED NOT NULL,
    currentStock	SMALLINT UNSIGNED NOT NULL
);

INSERT INTO TBL_BOOK
VALUES
('001', 'title1', 'author1', 5, 5),
('002', 'title2', 'author2', 3, 3);

SELECT * FROM TBL_BOOK;