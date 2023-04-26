CREATE TABLE `study_world`.`populations`(
	`contury_code` VARCHAR(2) NOT NULL,
    `value` INT UNSIGNED NOT NULL,
    CONSTRAINT PRIMARY KEY(`contury_code`)
    );

INSERT INTO `study_world`.`populations` (`contury_code`, `value`)
VALUES	('KR', 51780000),
		('JP', 125800000),
        ('US', 329500000),
        ('DE', 83240000),
        ('GB', 67220000),
        ('FR', 67390000),
        ('IT', 59550000);

SELECT * FROM study_world.populations;

# 인구가 가장 많은 국가 1개
SELECT *
FROM `study_world`.`populations`
ORDER BY `value` DESC
LIMIT 1;

# 인구가 가장 적은 국가 1개
SELECT *
FROM `study_world`.`populations`
ORDER BY `value` ASC
LIMIT 1;

# 인구가 세번째로 많은 국가 1개
SELECT *
FROM `study_world`.`populations`
ORDER BY `value` DESC
LIMIT 1 OFFSET 2;

# 인구가 세번째로 적은 국가 1개
SELECT *
FROM `study_world`.`populations`
ORDER BY `value` ASC
LIMIT 1 OFFSET 2;



INSERT `study_world`.`conturies` (`code`, `name_ko`, `name_en`)
VALUES ('AU', '호주', 'Australia');

INSERT `study_world`.`populations` (`contury_code`, `value`)
VALUES ('CA', 38010000);

SELECT	`population`.`contury_code` AS `국가 코드`,
		`contury`.`name_ko` AS `국가 이름`,
		`population`.`value` AS `인구`
FROM `study_world`.`populations` AS `population`
LEFT JOIN `study_world`.`conturies` AS `contury`
ON `population`.`contury_code` = `contury`.`code`;



CREATE TABLE `study_world`.`areas`(
	`contury_code` VARCHAR(2) NOT NULL,
    `value` INT UNSIGNED NOT NULL,
    CONSTRAINT PRIMARY KEY (`contury_code`)
);

INSERT INTO `study_world`.`areas` (`contury_code`, `value`)
VALUES	('KR', 100210),
		('JP', 377975),
        ('US', 9834000),
        ('DE', 357588),
        ('GB', 243610),
        ('FR', 543940),
        ('IT', 301230);

SELECT `contury_code`, `value` / 100 AS 'areas(㎢)'
FROM `study_world`.`areas`;

# FROM study_world.conturies

SELECT	`contury`.`code` AS '국가 코드',
		`contury`.`name_ko` AS '국가 이름',
        `population`.`value` AS '인구(명)',
        `area`.`value` AS '면적(km2)',
        `population`.`value` / `area`.`value` AS '면적당 인구(명/km2)'
FROM `study_world`.`conturies` AS `contury`
LEFT JOIN `study_world`.`populations` AS `population` ON `contury`.`code` = `population`.`contury_code`
LEFT JOIN `study_world`.`areas` AS `area` ON `contury`.`code` = `area`.`contury_code`
ORDER BY `name_ko` ASC;
