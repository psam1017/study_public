UPDATE `study`.`foods`
SET	`price` = 16000,
	`sold_out_flag` = TRUE
WHERE `name` = '크림 스파게티'
LIMIT 1;

# 테이블 수정하기
ALTER TABLE `study`.`foods`
RENAME `meals`,
ADD COLUMN `popular_flag` BOOLEAN,
ADD COLUMN `sale_rate` DOUBLE AFTER `price`,
ADD COLUMN `category` VARCHAR(50) FIRST,
DROP COLUMN `sold_out_flag`,
MODIFY COLUMN `name` VARCHAR(100),
MODIFY COLUMN `popular_flag` BOOLEAN AFTER `sale_rate`,
CHANGE COLUMN `name` `new_name` VARCHAR(50) AFTER `category`;



#과제 1. 스키마, 테이블, 레코드 만들기 실습
CREATE SCHEMA `study_world`;

CREATE TABLE `study_world`.`conturies`(
	`code` VARCHAR(2),
    `name_ko` VARCHAR(50),
    `name_en` VARCHAR(50)
);

INSERT INTO `study_world`.`conturies`(`code`, `name_ko`, `name_en`)
VALUES	('KR', '대한민국', 'Republic of Korea'),
		('JP', '일본', 'Japan'),
        ('US', '미국', 'United States of America'),
        ('DE', '독일', 'Germany'),
        ('GB', '영국', 'United Kimdom'),
        ('FR', '프랑스', 'France'),
        ('IT', '이탈리아','Italy');

SELECT *
FROM `study_world`.`conturies`;

ALTER TABLE `study_world`.`conturies`
MODIFY COLUMN `code` VARCHAR(2) NOT NULL,
MODIFY COLUMN `name_ko` VARCHAR(50) NOT NULL,
MODIFY COLUMN `name_en` VARCHAR(50) NOT NULL;

DESC `study_world`.`conturies`;

DROP TABLE `study_world`.`conturies`;

CREATE TABLE `study_world`.`conturies`(
	`code` VARCHAR(2) NOT NULL,
    `name_ko` VARCHAR(50) NOT NULL,
    `name_en` VARCHAR(50) NOT NULL,
    CONSTRAINT PRIMARY KEY (`code`),
    CONSTRAINT UNIQUE (`name_ko`, `name_en`) # 한글 이름과 영어 이름의 조합이 겹치지 않게 설정하므로 의도와 달라짐.
);

CREATE TABLE `study_world`.`conturies`(
	`code` VARCHAR(2),
    `name_ko` VARCHAR(50) NOT NULL,
    `name_en` VARCHAR(50) NOT NULL,
    CONSTRAINT PRIMARY KEY (`code`),
    CONSTRAINT UNIQUE (`name_ko`),
    CONSTRAINT UNIQUE (`name_en`)
);

# code는 기본 키이므로 NOT NULL을 명시하지 않아도 NULL 값을 넣을 수 없음.
INSERT INTO study_world.conturies(code, name_ko, name_en) VALUES (NULL, 'abc', 'def');