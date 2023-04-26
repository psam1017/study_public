CREATE SCHEMA `study_school`;

CREATE TABLE study_school.grades(
	`value` TINYINT UNSIGNED NOT NULL,
    CONSTRAINT PRIMARY KEY(`value`)
);

INSERT INTO study_school.grades(`value`)
VALUES (1), (2), (3);

CREATE TABLE study_school.classes(
	`grade_value` TINYINT UNSIGNED NOT NULL,
    `value` TINYINT UNSIGNED NOT NULL,
	CONSTRAINT PRIMARY KEY(`grade_value`, `value`),
    CONSTRAINT FOREIGN KEY(`grade_value`)
		REFERENCES study_school.grades(`value`)
			ON DELETE CASCADE
            ON UPDATE CASCADE # 외래 키를 설정할 때 기본적으로 CASCADE 제약조건을 걸어주자.
);

INSERT INTO study_school.classes(`grade_value`, `value`)
VALUES (1, 1), (1, 2), (1, 3);

CREATE TABLE study_school.students(
	`grade_value` TINYINT UNSIGNED NOT NULL,
    `class_value` TINYINT UNSIGNED NOT NULL,
    `number` TINYINT UNSIGNED NOT NULL,
    `name` VARCHAR(5) NOT NULL,
	CONSTRAINT PRIMARY KEY(`grade_value`, `class_value`, `number`),
    CONSTRAINT FOREIGN KEY(`grade_value`, `class_value`)
		REFERENCES study_school.classes(`grade_value`, `value`)
			ON DELETE CASCADE
            ON UPDATE CASCADE
);

INSERT INTO study_school.students(`grade_value`, `class_value`, `number`, `name`)
VALUES	(1, 1 ,1, '일일일'),
		(1, 1, 2, '일일이'),
		(1, 1, 3, '일일삼'),
		(1, 2, 1, '일이일'),
		(1, 2, 2, '일이이'),
		(1, 2, 3, '일이삼'),
		(1, 3, 1, '일삼일'),
		(1, 3, 2, '일삼이'),
		(1, 3, 3, '일삼삼');

DESC study_school.students;
SELECT * FROM study_school.students;

CREATE TABLE study_school.teachers(
	`id` VARCHAR(7) NOT NULL,
    `name` VARCHAR(5) NOT NULL,
    `contact` VARCHAR(13) NOT NULL UNIQUE,
    CONSTRAINT PRIMARY KEY(`id`)
);

INSERT INTO study_school.teachers(`id`, `name`, `contact`)
VALUES	('2012-13', '김국어', '010-9988-7766'),
		('2006-55', '이수학', '010-1122-3344'),
        ('2014-07', '박영어', '010-0011-0011'),
        ('2016-41', '최물리', '010-5500-6600'),
        ('2017-32', '김화학', '010-1200-3400'),
        ('2016-98', '이생물', '010-7700-0077'),
        ('2020-36', '박지구', '010-0777-0700');

SELECT * FROM study_school.teachers;

CREATE TABLE study_school.designations(
	`teacher_id` VARCHAR(7) NOT NULL,
    `grade_value` TINYINT UNSIGNED NOT NULL,
    `class_value` TINYINT UNSIGNED NOT NULL,
    CONSTRAINT PRIMARY KEY (`teacher_id`),
    CONSTRAINT FOREIGN KEY (`teacher_id`)
		REFERENCES study_school.teachers (`id`)
			ON DELETE CASCADE
            ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (`grade_value`, `class_value`)
		REFERENCES study_school.classes (`grade_value`, `value`)
			ON DELETE CASCADE
            ON UPDATE CASCADE,
	CONSTRAINT UNIQUE (`grade_value`, `class_value`)
);

INSERT INTO study_school.designations(`teacher_id`, `grade_value`, `class_value`)
VALUES	('2012-13', 1, 1),
		('2006-55', 1, 2),
		('2014-07', 1, 3);



# 교사를 검색하되, 담임인 교사라면 학반과 학생 수를 같이 출력
# 코리아IT아카데미 박용현 강사 query
SELECT	`teacher`.`id` AS `교번`,
		`teacher`.`name` AS `교사 이름`,
        IFNULL(CONCAT(`designation`.`grade_value`, '학년 ', `designation`.`class_value`, '반'), '담임 없음') AS `담임`,
        (SELECT count(0) # 애스터리스크보다 성능 상 더 우월할 수 있음.
        FROM `study_school`.`students` AS `student`
		WHERE	`student`.`grade_value` = `designation`.`grade_value`
        AND		`student`.`class_value` = `designation`.`class_value`) AS `학생 수`
FROM `study_school`.`teachers` AS `teacher`
LEFT JOIN `study_school`.`designations` AS `designation`
	ON `teacher`.`id` = `designation`.`teacher_id`
ORDER BY `teacher`.`id` ASC;



# 과제 : UNION을 사용하여 마지막 레코드에 총 학생 수 구하기
# kdata style query
SELECT	교사.id '교번',
		교사.name '교사 이름',
        IFNULL(CONCAT(담임.grade_value, '학년 ', 담임.class_value, '반'), '담임 없음') '담임',
        (SELECT count(0)
		FROM study_school.students 학생
        WHERE	학생.grade_value = 담임.grade_value
        AND		학생.class_value = 담임.class_value) '학생 수'
FROM study_school.teachers 교사
LEFT JOIN study_school.designations 담임
	ON 교사.id = 담임.teacher_id
UNION
SELECT '총 학생 수', '', '', COUNT(0)
FROM study_school.students;
