-- INSERT
INSERT INTO TBL_CITY
VALUES	('용인', 297, 98, 'n', '경기');

INSERT INTO TBL_STAFF
VALUES ('박성민', 'IT', '남', '2022-11-10', '사원', 500, '100');

-- CREATE ~ AS ~ SELECT
CREATE TABLE TBL_SUDO
AS
SELECT name, area, popu
FROM TBL_CITY
WHERE region = '경기'; 

SELECT * FROM TBL_SUDO;

CREATE TABLE TBL_BEST_SCORES
AS
SELECT name, salary, score
FROM TBL_STAFF
WHERE score >= 80;

SELECT * FROM TBL_BEST_SCORES;

-- DELETE
DELETE FROM TBL_CITY
WHERE name = '부산';

-- TRUNCATE TABLE 테이블 : 테이블의 레코드만 삭제하고, 로그를 남긴다.
-- WHERE 절 없는 DELETE :  서버에 부하도 생기고 COMMIT이 되버릴 수 있으니 사용하지 않는 것이 권장된다.

-- UPDATE
UPDATE TBL_STAFF
SET depart = '사업총괄부', salary = 1000
WHERE name = '박성민';

SELECT * FROM TBL_STAFF;

-- ALTER, DELETE 등 DB에서 직접 수정하는 것은 편집기의 UI에서 직접 하는 게 더 안전하고 편하다.
-- workbench의 경우 Navigator의 테이블 위로 hover를 하면 나타는 버튼들을 클릭하면 가능하다.












