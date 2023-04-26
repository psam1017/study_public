-- 1일차

-- SELECT 실습 : 필드명
SELECT name, area, popu, metro, region
FROM TBL_CITY;

SELECT name AS `도시명`, area AS `면적(km^2)`, popu AS `인구(만 명)`
FROM TBL_CITY;

SELECT name AS `도시명`, area AS `면적(km^2)`, popu*10000 AS `인구(명)`
FROM TBL_CITY;

SELECT name, area, popu, (popu * 10000) / area `인구밀도`
FROM TBL_CITY;

SELECT 60 * 60 * 24 `오늘은 몇 초?`
FROM DUAL;

-- SELECT 실습 : 연산과 함수
SELECT COUNT(name)
FROM TBL_STAFF;

SELECT *
FROM TBL_CITY
WHERE area > 1000;

SELECT *
FROM TBL_CITY
WHERE metro = 'y';

SELECT name, popu
FROM TBL_CITY
WHERE popu < 10;

SELECT *
FROM TBL_CITY
WHERE region = "전라";

SELECT name, salary
FROM TBL_STAFF
WHERE salary >= 400;

SELECT name, score
FROM TBL_STAFF
WHERE score IS NULL;

SELECT name, score
FROM TBL_STAFF
WHERE score IS NOT NULL;

SELECT *
FROM TBL_CITY
WHERE	popu >= 100
AND		area >= 700;

SELECT *
FROM TBL_CITY
WHERE	popu >= 100
OR		area >= 700;

-- AND는 논리곱이고, OR는 논리합이다. 따라서 AND가 우선 적용된다.
SELECT *
FROM TBL_CITY
WHERE region = "경기" AND popu >= 50 OR area >= 500;

SELECT *
FROM TBL_CITY
WHERE region = "경기" OR popu >= 50 AND area >= 500;

SELECT *
FROM TBL_CITY
WHERE region != "경기";

SELECT *
FROM TBL_CITY
WHERE NOT(region= "경기");

-- 2일차

SELECT *
FROM TBL_CITY
WHERE	region = "전라"
OR		metro = 'y';

SELECT *
FROM TBL_CITY
WHERE	NOT(region = "전라" OR metro = 'y');

-- 월급이 300 미만이면서 성취도 60 이상인 직원
SELECT name, salary, score
FROM TBL_STAFF
WHERE salary < 300 AND score >= 60;

-- 영업부 여직원 이름
SELECT name, depart, gender
FROM TBL_STAFF
WHERE depart = "영업부" AND gender = '여';

-- 와일드 카드
-- % : 0개 이상의 문자와 대응
-- _ : 1개이 문자와 대응
-- [] : [] 안에 포함된 문자 리스트 중 하나의 문자라도 있으면 반환
-- [^] : [^] 안에 포함된 문자 리스트에 포함되지 않은 하나의 문자와 대응

SELECT *
FROM TBL_CITY
WHERE name LIKE "%천%";

-- %천, 천%, %천_, _천_ 등 활용도가 높다.
-- 예를 들어, 마지막 공백 문자 하나를 제외하고 검색하려면 "%천_"으로 검색

-- 1. '정' 씨 조회 / 2. (성이 아니라)이름에 '신'이 들어간 직원 조회. 단, 성은 외자라고 가정.
SELECT name
FROM TBL_STAFF
WHERE name LIKE "정%";

SELECT name
FROM TBL_STAFF
WHERE name LIKE "_%신%";

SELECT name, area
FROM TBL_CITY
WHERE area BETWEEN 500 AND 1000;

-- BETWEEN은 양쪽 끝 결과를 포함한다.
SELECT *
FROM TBL_STAFF
WHERE salary BETWEEN 200 AND 299;

SELECT *
FROM TBL_CITY
WHERE region IN ("경상", "전라");

-- ORDER BY
SELECT name "도시명", area "구획 크기"
FROM TBL_CITY
ORDER BY area;

-- ORDER BY에 여러 개의 필드를 입력할 수 있다. 입력할 필드는 SELECT에 없어도 된다.
SELECT name "직원명", salary "급여"
FROM TBL_STAFF
ORDER BY salary, grade DESC;

-- 2번째 필드를 기준으로 정렬한다. 단, 가독성이나 직관성은 떨어진다.
SELECT *
FROM TBL_CITY
ORDER BY 2;

-- 테이블에 없는 계산값도 기준이 될 수 있다.
SELECT *
FROM TBL_CITY
ORDER BY popu / area;

-- 월급 오름차순, 성취도 내림차순
SELECT name, salary, score
FROM TBL_STAFF
ORDER BY salary ASC, score DESC;

-- 영업부 입사 오름차순
SELECT name, depart, joindate
FROM TBL_STAFF
WHERE depart = "영업부"
ORDER BY joindate;

-- DISTINCT : 중복 제거
-- ALL : 중복 허용
SELECT DISTINCT region
FROM TBL_CITY;

-- 실습문제 : DATE 비교
SELECT depart, name, joindate
FROM TBL_STAFF
WHERE joindate >= "20200101";

-- LIMIT x : x개만 선택.
-- OFFSET y : y개를 건너뜀.
-- FETCH z : OFFSET과 함께 사용하는 ORDER BY의 옵션. 예시 참고.
-- LIMIT a, b : a개를 건너뛰고 b개를 선택. 단, 가독성 측면에서 불리함.
SELECT name, area "면적 TOP 3"
FROM TBL_CITY
ORDER BY area DESC
LIMIT 3;

SELECT name, area "면적 3위"
FROM TBL_CITY
ORDER BY area DESC
LIMIT 1 OFFSET 2;
-- ORDER BY area DESC LIMIT 2, 1
-- ORDER BY area DESC OFFSET 2 ROWS FETCH NEXT 1 ROWS ONLY

SELECT *
FROM TBL_STAFF
ORDER BY salary, name
LIMIT 5 OFFSET 11;

-- 단일 행 집계함수 : SUM, AVG, MIN, MAX, VARIANCE, STDDEV

SELECT COUNT(1) "총 직원 수"
FROM TBL_STAFF;

SELECT COUNT(DISTINCT depart) "총 부서 수"
FROM TBL_STAFF;

-- 집계함수는 대상에 NULL이 있으면 그 값을 제외하고 결과를 반환한다.
-- 따라서 AVG(score)와 SUM(score) / COUNT(*)의 결과는 다르다.
-- 또한, COUNT(*)의 대상이 NULL인 경우 0을 출력하지만, 다른 집계함수는 NULL이 나온다.
SELECT COUNT(1) - COUNT(score) "평가 미완료 대상"
FROM TBL_STAFF;

-- 최댓값과 최솟값 같이 구하기
SELECT name "도시", popu "인구 수"
FROM TBL_CITY
WHERE	popu = (SELECT MAX(popu) FROM TBL_CITY)
OR		popu = (SELECT MIN(popu) FROM TBL_CITY)
LIMIT 2;

-- 서브쿼리는 SELECT, FROM, WHERE 등에서 사용할 수 있다.
SELECT name, (SELECT AVG(popu) FROM TBL_CITY)
FROM TBL_STAFF
LIMIT 1;



-- 3일차

-- GROUP BY
SELECT depart, AVG(salary)
FROM TBL_STAFF
GROUP BY depart;

SELECT depart, gender, AVG(salary)
FROM TBL_STAFF
GROUP BY depart, gender;

-- SELECT 문의 실행 순서 : FROM - WHERE - GROUP BY - HAVING - SELECT - ORDER BY

-- 급여가 300 이상인 직원들만 부서 별로 모아서 평균을 출력
SELECT depart, AVG(salary)
FROM TBL_STAFF
WHERE salary >= 350
GROUP BY depart;

-- 부서 별 급여 평균 중에서 350 이상인 부서만 출력
SELECT depart, AVG(salary)
FROM TBL_STAFF
GROUP BY depart
HAVING AVG(salary) >= 350;