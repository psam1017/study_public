CREATE TABLE `member`
(
	id			VARCHAR(100) NOT NULL PRIMARY KEY,
    password	VARCHAR(128) NOT NULL,
    name		VARCHAR(100) NOT NULL
);

SELECT * FROM `member`;

-- ----------------------------------------------------------

CREATE TABLE IF NOT EXISTS product(
	p_id VARCHAR(10) NOT NULL,
	p_name VARCHAR(20),
	p_unitPrice  INTEGER,
	p_description TEXT,
   	p_category VARCHAR(20),
	p_manufacturer VARCHAR(20),
	p_unitsInStock LONG,
	p_condition VARCHAR(20),
	p_fileName  VARCHAR(20),
	PRIMARY KEY (p_id)
)default CHARSET=utf8;

desc product;


INSERT INTO product VALUES('P1234', 'iPhone 6s', 800000, '1334X750 Renina HD display, 8-megapixel iSight Camera','Smart Phone', 'Apple', 1000, 'new', 'P1234.png');
INSERT INTO product VALUES('P1235', 'LG PC gram', 1500000, '3.3-inch,IPS LED display, 5rd Generation Intel Core processors', 'Notebook', 'LG', 1000, 'new', 'P1235.png');
INSERT INTO product VALUES('P1236', 'Galaxy Tab S', 900000, '3.3-inch, 212.8*125.6*6.6mm,  Super AMOLED display, Octa-Core processor', 'Tablet', 'Samsung', 1000, 'new', 'P1236.png');

SELECT * FROM product;

-- ----------------------------------------------------------

CREATE TABLE IF NOT EXISTS member(
   id VARCHAR(20) NOT NULL,
   passwd  VARCHAR(20),
   name VARCHAR(30),    
   PRIMARY KEY (id)
);

INSERT INTO member VALUES('9', '1234', 'park');
INSERT INTO member VALUES('10', '1235', 'kim');

SELECT * FROM `member` ORDER BY id ASC;

-- ----------------------------------------------------------

create table member ( 
    id varchar(10) not null,
    password varchar(10) not null,
    name varchar(10) not null,
    gender varchar(4),
    birth  varchar(10),
    mail  varchar(30),
    phone varchar(20),
    address varchar(90),
    regist_day varchar(50),    
    primary key(id) 
) default CHARSET=utf8;

create table admin ( 
    id varchar(10) not null,
    password varchar(10) not null,
    name varchar(10) not null,
    lately_login_day VARCHAR(50),
    gender varchar(4),
    birth  varchar(10),
    mail  varchar(30),
    phone varchar(20),
    address varchar(90),
    regist_day varchar(50),    
    primary key(id) 
) default CHARSET=utf8;

insert into admin(id, password, name) values ('admin', 'admin1234', 'admin');

-- ----------------------------------------------------------

CREATE TABLE IF NOT EXISTS cart(
	cartId INT(11) PRIMARY KEY AUTO_INCREMENT,
    memberId VARCHAR(10) NULL,
    orderNo VARCHAR(50),
    productId VARCHAR(10) NOT NULL,
    name VARCHAR(20),
    unitPrice INTEGER DEFAULT 0,
    cnt INTEGER DEFAULT 0,
    insertDate DATE
)default CHARSET=utf8;

-- ----------------------------------------------------------

CREATE TABLE address_book
(
	id		INT(11)			NOT NULL	PRIMARY KEY	AUTO_INCREMENT,
    name	VARCHAR(100)	NOT NULL,
    email 	VARCHAR(100)	NULL,
    comdept	VARCHAR(100)	NOT NULL,
    birth	VARCHAR(100)	NOT NULL,
    tel		VARCHAR(100)	NULL,
    memo	VARCHAR(100)	NULL
) DEFAULT CHARSET=UTF8;

INSERT INTO address_book(name, email, comdept, birth, tel, memo)
VALUES ('psm', 'psm@inter.net', 'comdept', '961017', '01012345678', 'memo');

INSERT INTO address_book
VALUES (NULL, 'psm', 'psm@inter.net', 'comdept', '961017', '01012345678', 'memo');

UPDATE address_book
SET name = 'psam', comdept = 'company'
WHERE id = 2;

SELECT * FROM address_book ORDER BY id DESC;

-- ----------------------------------------------------------

CREATE TABLE board
(
	num				INT				NOT NULL	AUTO_INCREMENT	PRIMARY KEY,
    id				VARCHAR(10)	NOT NULL,
    name			VARCHAR(10)	NOT NULL,
    subject		VARCHAR(100)	NOT NULL,
    content			TEXT			NOT NULL,
    register_day	VARCHAR(30)	NOT NULL	DEFAULT NOW(),
    hit				INT				NULL		DEFAULT 0,
    ip				VARCHAR(48)	NULL
)DEFAULT CHARSET=UTF8;

INSERT INTO board(id, name, subject, content, ip)
VALUES('id', 'name', 'subject', 'content', '127.0.0.1');

UPDATE board SET hit = hit + 1 WHERE num = 1;

SELECT * FROM board ORDER BY num DESC;

-- --------------------------------------------------------------

CREATE TABLE news
(
	aid		INT UNSIGNED	NOT NULL	AUTO_INCREMENT	PRIMARY KEY,
    title	VARCHAR(255)	NOT NULL,
    img		VARCHAR(255)	NOT NULL,
    date	DATETIME		NOT NULL	DEFAULT CURRENT_TIMESTAMP(),	
    content	VARCHAR(2000)	NOT NULL
);

SELECT * FROM news;

ALTER TABLE news CONVERT TO CHARSET UTF8;

-- --------------------------------------------------------------

























