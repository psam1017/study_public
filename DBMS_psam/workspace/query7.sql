
# 시험 테이블, 과목 테이블, 성적 테이블 만들기

CREATE TABLE `study_school`.`subjects`(
	`code` VARCHAR(3) NOT NULL PRIMARY KEY,
    `name` VARCHAR(10) NOT NULL
);

INSERT INTO `study_school`.`subjects`
VALUES	('KOR', '국어'),
		('ENG', '영어'),
        ('MTH', '수학');

CREATE TABLE `study_school`.`tests`(
	`index` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(10) NOT NULL,
    `took_at` DATE NOT NULL
);

INSERT INTO `study_school`.`tests`(`name`, `took_at`)
VALUES	('3월 모의고사', '2022-03-11'),
		('6월 모의고사', '2022-06-18'),
        ('9월 모의고사', '2022-09-21');

CREATE TABLE `study_school`.`scores`(
	`index` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`student_grade` TINYINT UNSIGNED NOT NULL,
    `student_class` TINYINT UNSIGNED NOT NULL,
    `student_number` TINYINT UNSIGNED NOT NULL,
    `test_index` INT UNSIGNED NOT NULL,
	`subject_code` VARCHAR(3) NOT NULL,
    `score` TINYINT UNSIGNED NOT NULL,
    CONSTRAINT FOREIGN KEY (`student_grade`, `student_class`, `student_number`)
		REFERENCES `study_school`.`students`(`grade_value`, `class_value`, `number`)
			ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (`test_index`)
		REFERENCES `study_school`.`tests` (`index`)
			ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT UNIQUE (`student_grade`, `student_class`, `student_number`, `test_index`, `subject_code`)
);

desc `study_school`.scores;

INSERT INTO `study_school`.`scores`(`student_grade`, `student_class`, `student_number`, `test_index`, `subject_code`, `score`)
VALUES	(1, 1, 1, 1, 'KOR', 100),
		(1, 1, 1, 1, 'ENG', 24),
        (1, 1, 1, 1, 'MTH', 58),
        (1, 1, 2, 1, 'KOR', 78),
		(1, 1, 2, 1, 'ENG', 51),
        (1, 1, 2, 1, 'MTH', 48),
        (1, 1, 3, 1, 'KOR', 58),
		(1, 1, 3, 1, 'ENG', 89),
        (1, 1, 3, 1, 'MTH', 61),
        (1, 2, 1, 1, 'KOR', 88),
		(1, 2, 1, 1, 'ENG', 78),
        (1, 2, 1, 1, 'MTH', 66),
        (1, 2, 2, 1, 'KOR', 52),
		(1, 2, 2, 1, 'ENG', 100),
        (1, 2, 2, 1, 'MTH', 88),
        (1, 2, 3, 1, 'KOR', 100),
		(1, 2, 3, 1, 'ENG', 98),
        (1, 2, 3, 1, 'MTH', 96),
        (1, 3, 1, 1, 'KOR', 82),
		(1, 3, 1, 1, 'ENG', 96),
        (1, 3, 1, 1, 'MTH', 32),
        (1, 3, 2, 1, 'KOR', 66),
		(1, 3, 2, 1, 'ENG', 100),
        (1, 3, 2, 1, 'MTH', 72),
        (1, 3, 3, 1, 'KOR', 80),
		(1, 3, 3, 1, 'ENG', 84),
        (1, 3, 3, 1, 'MTH', 71);

SELECT * FROM `study_school`.`scores`;