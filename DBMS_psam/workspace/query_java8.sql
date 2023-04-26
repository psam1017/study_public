
CREATE TABLE order_info
(
	orderNo			VARCHAR(50)	PRIMARY KEY,
    memberId		VARCHAR(50),
    orderName		VARCHAR(20),
    orderTel		VARCHAR(20),
    orderEmail		VARCHAR(30),
    receiveName		VARCHAR(20),
    receiveTel		VARCHAR(20),
    receiveAddress	VARCHAR(200),
    payMethod		VARCHAR(20),
    carryNo			VARCHAR(20),	
    orderStep		VARCHAR(20)	NOT NULL	DEFAULT	'orderFail',
    dateOrder		DATETIME		NOT NULL,
    datePay			DATETIME,
    dateCarry		DATETIME,
    dateDone		DATETIME
);

CREATE TABLE order_date
(
	num			INT(11)			NOT NULL	AUTO_INCREMENT	PRIMARY KEY,
	orderNo		VARCHAR(50),
    cartId		INT(11),
    bookId		VARCHAR(50),
    bookName	VARCHAR(50),
    unitPrice	INT(11)			NOT NULL	DEFAULT 0,
    cnt			TINYINT(4)		NOT NULL	DEFAULT 0,
    sumPrice	INT(11)			NOT NULL	DEFAULT 0,
    INDEX		`orderNo`(`orderNo`)
);


































