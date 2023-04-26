-- 자바 방특

CREATE TABLE person
(
	person_id INT UNSIGNED AUTO_INCREMENT,
    fname VARCHAR(20),
    lname VARCHAR(20),
    eye_color ENUM('BR', 'BL', 'GR'),
    birth_date DATE,
    street VARCHAR(30),
    city VARCHAR(20),
    state VARCHAR(20),
    country VARCHAR(20),
    postal_code VARCHAR(20),
    PRIMARY KEY(person_id)
);

DESC sample.person;

INSERT INTO sample.person(person_id, fname, lname, eye_color, birth_date)
VALUES	(null, 'William', 'Turner', 'BR', '1972-05-27');

INSERT INTO sample.person(person_id, fname, lname, eye_color, birth_date)
VALUES	(null, 'Maria', 'Divine', 'BL', '1988-10-25');

SELECT *
FROM person
WHERE person_id <= 3
GROUP BY person_id
HAVING COUNT(person_id) = 1
ORDER BY 1;

UPDATE sample.person SET eye_color = 'BL'
WHERE person_id = 1;

CREATE TABLE sample.favorite_food
(
	person_id INT UNSIGNED,
    food VARCHAR(20),
    CONSTRAINT PRIMARY KEY(person_id, food),
    CONSTRAINT fk FOREIGN KEY(person_id)
		REFERENCES sample.person(person_id)
			ON DELETE CASCADE
            ON UPDATE CASCADE
);

DESC sample.favorite_food;

INSERT INTO sample.favorite_food
VALUES	(1, 'korean ramen');

UPDATE sample.person
SET	street = '1225 Tremont St.',
	city = 'Boston',
    state = 'MA',
    country = 'USA',
    postal_code = '02138'
WHERE person_id = 1;

DELETE FROM sample.person
WHERE person_id = 2;
