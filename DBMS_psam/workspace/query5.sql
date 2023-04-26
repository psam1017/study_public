
# conturies에 존재하는 code와 일치시키기 위하여, 외래 키(FK)를 사용.
CREATE TABLE study_world.gdps(
	`contury_code` VARCHAR(2) NOT NULL,
    `value` DOUBLE UNSIGNED NOT NULL,
    CONSTRAINT PRIMARY KEY(`contury_code`),
    CONSTRAINT FOREIGN KEY(`contury_code`) REFERENCES `study_world`.`conturies`(`code`)
);

#아직 아무런 값도 없는 상태
SELECT * FROM study_world.gdps;

INSERT INTO `study_world`.`gdps` (`contury_code`,`value`)
VALUES ('KR', 1.631);

#실행 불가능. 외래 키 제약조건을 어겼기 때문.
INSERT INTO `study_world`.`gdps` (`contury_code`,`value`)
VALUES ('ES', 1.281);

#실행 불가능. 부모 레코드 conturies의 code 중 'KR'을 gdps 테이블에서 참조하고 있기 때문에 삭제할 수 없다.
DELETE FROM study_world.conturies WHERE code = 'KR' LIMIT 1;

# 'AU'는 참조하고 있는 키가 없기 때문에 삭제가 가능하다.
DELETE FROM study_world.conturies WHERE code = 'AU' LIMIT 1;



DROP TABLE study_world.gdps;

CREATE TABLE study_world.gdps(
	`contury_code` VARCHAR(2) NOT NULL,
    `value` DOUBLE UNSIGNED NOT NULL,
    CONSTRAINT PRIMARY KEY(`contury_code`),
    CONSTRAINT FOREIGN KEY(`contury_code`) REFERENCES `study_world`.`conturies`(`code`)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

INSERT INTO `study_world`.`gdps` (`contury_code`,`value`)
VALUES ('KR', 1.631);

INSERT INTO `study_world`.`gdps` (`contury_code`,`value`)
VALUES ('JP', 1.231);

# conturies 테이블의 레코드를 수정 및 삭제하면 gpds 테이블의 레코드들도 같이 수정 및 삭제된다.
UPDATE `study_world`.`conturies` SET `code` = 'KO' WHERE `code` = 'KR' LIMIT 1;
DELETE FROM `study_world`.`conturies` WHERE `code` = 'JP' LIMIT 1;



# 함수 실습
SELECT `contury_code`, `value`, IF(`value` >= 100000000, '1억 이상', '1억 미만') AS `인구 1억 여부`
FROM study_world.populations;

SELECT	CONCAT('내 나이는', 27, '살이다. ', FALSE) AS `CONCAT 실습`,
		LENGTH(CONCAT('내 나이는', 27, '살이다. ', FALSE)) AS `LENGTH 실습`;

SELECT	REPLACE('Hello World', 'Hello', 'Hi') AS `REPLACE 실습`,
		LEFT('Hello World', 5) AS `LEFT 실습`,
		RIGHT('Hello World', 5) AS `RIGHT 실습`,
        SUBSTRING('Hello World And DBMS', 7, 5) AS `SUBSTRING 실습`;

SELECT	LTRIM('   Hello Wrold   ') AS `LTRIM 실습`,
		RTRIM('   Hello Wrold   ') AS `RTRIM 실습`,
        TRIM('   Hello Wrold   ') AS `TRIM 실습`;

SELECT	UPPER('hello world') AS `UPPER 실습`,
		LOWER('HELLO WORLD') AS `LOWER 실습`;

SELECT	REVERSE('hello world') AS `REVERSE 실습`;

SELECT	ABS(-5),
		CEILING(3.14),
        FLOOR(3.14),
        ROUND(3.14);

SELECT	ROUND(3.141592, 0),
		ROUND(3.141592, 4),
        TRUNCATE(3.141592, 4),
        ROUND(1113.141592, -1);

SELECT	POW(2, 4),
		GREATEST(3, 4, 5),
        LEAST(3, 4, 5);

SELECT NOW(), CURDATE(), CURTIME();

SELECT	NOW(),
		DATE_ADD(NOW(), INTERVAL 3 YEAR),
        DATE_SUB('2020-01-01 00:00:00', INTERVAL 1 QUARTER);

SELECT DATE_FORMAT(NOW(), '%Y년 %m월 %d일 %H시 %i분 %S초') AS `DATE_FORMAT 실습`;
