CREATE TABLE TBL_TEST
(
	ID VARCHAR2(1000) PRIMARY KEY,
	NAME VARCHAR2(500)
);

INSERT INTO TBL_TEST
VALUES
('hds1234', '한동석');

INSERT INTO TBL_TEST
VALUES
('psm1234', '박성민');

SELECT * FROM TBL_TEST;