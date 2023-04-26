CREATE SCHEMA `study`;

CREATE TABLE `study`.`foods`(
	`name` VARCHAR(50),
    `price` MEDIUMINT UNSIGNED,
    `sold_out_flag` BOOLEAN
);

DESC `study`.`foods`;

INSERT INTO `study`.`foods` (`name`, `price`, `sold_out_flag`)
VALUES ('토마토 스파게티', 12000, FALSE);

INSERT INTO `study`.`foods` (`price`, `name`)
VALUES (12000, '크림 스파게티');

TRUNCATE `study`.`foods`; #모든 레코드 삭제

INSERT INTO `study`.`foods` (`name`, `price`, `sold_out_flag`)
VALUES	('토마토 스파게티', 12000, FALSE),
		('크림 스파게티', 12000, FALSE),
        ('짜장면', 7000, FALSE),
        ('짬뽕', 8000, FALSE),
        ('떡볶이', 6000, FALSE);

SELECT *
FROM study.foods;

SELECT	name AS '음식명',
		price AS '가격'
FROM study.foods
WHERE price >= 7000
ORDER BY `price` DESC
LIMIT 1 OFFSET 2;

SELECT 5 != 3;
SELECT 5 <> 3;
SELECT !FALSE;
SELECT NOT FALSE;
# 위의 결과 모두 TRUE

SELECT BINARY 'HELLO WORLD' = 'hello world';

DELETE
FROM `study`.`foods`
WHERE `price` < 10000;

DELETE
FROM `study`.`foods`
WHERE `price` >= 10000
LIMIT 1;
