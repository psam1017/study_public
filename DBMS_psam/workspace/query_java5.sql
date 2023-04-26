# SCHEMA와 TABLE 생성 및 인코딩

CREATE SCHEMA test;

CREATE TABLE test.tbl_user
(
	id						VARCHAR(100)	NOT NULL	PRIMARY KEY,
    password				VARCHAR(128)	NOT NULL,
    name					VARCHAR(5)		NOT NULL,
    email					VARCHAR(100)	NOT NULL,
    phone_number_first		VARCHAR(4)		NOT NULL,
    phone_number_second		VARCHAR(4)		NOT NULL,
    phone_number_third		VARCHAR(4)		NOT NULL,
    birthday				DATE			NOT NULL,
    zipcode					TEXT(5)		NOT NULL,
    address					VARCHAR(500)	NOT NULL,
    address_detail			VARCHAR(500)	NOT NULL,
    email_send_agreed_at	DATETIME		NULL,
    phone_send_agreed_at	DATETIME		NULL,
    interest_action			VARCHAR(1)		NULL,
    interest_adventure		VARCHAR(1)		NULL,
    interest_casual			VARCHAR(1)		NULL,
    interest_indie			VARCHAR(1)		NULL,
    interest_MMO			VARCHAR(1)		NULL,
    interest_racing			VARCHAR(1)		NULL,
    interest_RPG			VARCHAR(1)		NULL,
    interest_simul			VARCHAR(1)		NULL,
    interest_sport			VARCHAR(1)		NULL,
    interest_strategy		VARCHAR(1)		NULL
);

ALTER TABLE test.tbl_user CONVERT TO CHARSET UTF8;

# INSERT 실행

INSERT INTO test.tbl_user VALUES ('psm1017', '9DB35390D2D537C0C1D7144260F90C94AEA8B5B90E28969A29B061157BF846728E307075AB963D411677090E838CDF86E684ABEC72DDCEA6F27E04E45763FFEF', '박성민', 'psam1017@naver.com', '010', '4623', '7790', '1996-10-17', '41842', '서울시 강남구 테헤란로 52', '3층 302호(역삼동)', NOW(), NOW() , 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N');
INSERT INTO test.tbl_user VALUES ('superman', 'A9B773C0AC6EC9E29CFB14A591E02D9709C0537CC44C0EE7CAF3C904EF519C6F792064030312A4430FC2C2D57CC9368C5A2C42347FB4CF5315B11422D10A65E0', '박효신', 'phs0010@naver.com', '010', '4937', '2486', '1955-9-28', '42151', '서울시 항정구 테헤란로 45', '2층 202호(충무동)', '2022-11-20 14:45:48', '2022-11-20 14:45:48' , 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N');
INSERT INTO test.tbl_user VALUES ('chidin', '273BB74C48FC90664A4C59C45B7BE5EF918C58EB8FBEDA2C3CE76D0C82B319A61225B617CD0C52588AA34835C57D71C3304C0DAF781EF64C32382F4A64FD1DBB', '김지훈', 'kjh123@hanmail.net', '010', '1276', '5367', '2000-4-17', '22574', '서울시 홍대임구 테헤란로 22', '5층 502호(셔얼동)', NULL, NULL , 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N');
INSERT INTO test.tbl_user VALUES ('pass', '0683BB5776CB9D04232CA2A887E7A175012279CEFFAEDF387CBA6E2A889F55BF7FE539A6347226851446DD8BE2624FE4FE1399451F948FC6EB751BA92F90B054', '최형식', 'chs1130@google.com', '010', '4456', '3578', '1977-8-15', '12375', '서울시 신천구 신설로 1', '4층 403호(약수동)', '2022-8-10 14:45:48', NULL , 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y');
INSERT INTO test.tbl_user VALUES ('meme', '9DB35390D2D537C0C1D7144260F90C94AEA8B5B90E28969A29B061157BF846728E307075AB963D411677090E838CDF86E684ABEC72DDCEA6F27E04E45763FFEF', '손나라', 'snr007@naver.com', '010', '4452', '5435', '1988-5-4', '68954', '서울시 구대구 중리로 46', '1층 102호(금은동)', NULL, '2022-4-10 14:45:58' , 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'N', 'N', 'Y', 'N');
INSERT INTO test.tbl_user VALUES ('realguy', '273BB74C48FC90664A4C59C45B7BE5EF918C58EB8FBEDA2C3CE76D0C82B319A61225B617CD0C52588AA34835C57D71C3304C0DAF781EF64C32382F4A64FD1DBB', '박미래', 'pmr@google.com', '010', '5544', '7790', '1999-4-27', '44527', '서울시 농구 평리로 52', '23층 233호(공덕동)', '2022-11-20 14:45:48', '2022-11-20 14:45:48' , 'Y', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'Y', 'N');
INSERT INTO test.tbl_user VALUES ('realname', '0683BB5776CB9D04232CA2A887E7A175012279CEFFAEDF387CBA6E2A889F55BF7FE539A6347226851446DD8BE2624FE4FE1399451F948FC6EB751BA92F90B054', '선우경자', 'gjgjparty@naver.com', '010', '3567', '5521', '1978-2-8', '54375', '신도시 멋진구 새로 73', '73호(공수동)', NULL, NULL , 'N', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'N', 'N');
INSERT INTO test.tbl_user VALUES ('skygood', 'D67928BAC3FE018DE50BD2D62B276D579A5F2E5DD8846C4249F51942CD08D7EE9E401E9010E130D35EC2BEFB64E4DD6845BDEB46E9260E158F2269FDC1B9EB28', '사공용수', 'spring@google.com', '010', '3515', '5542', '1987-2-6', '55781', '서울시 신담구 거기로 22', '22호(홍길동)', '2022-3-10 14:45:48', '2022-3-10 14:45:48' , 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'N', 'N', 'Y', 'N');
INSERT INTO test.tbl_user VALUES ('false', '9DB35390D2D537C0C1D7144260F90C94AEA8B5B90E28969A29B061157BF846728E307075AB963D411677090E838CDF86E684ABEC72DDCEA6F27E04E45763FFEF', '이지훈', 'jhlee@naver.com', '010', '5547', '6985', '1998-7-5', '44235', '서울시 왕신니구 용두로 34', '10호(마파동)', NULL, NULL , 'Y', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'Y', 'N');
INSERT INTO test.tbl_user VALUES ('iamgood', 'D67928BAC3FE018DE50BD2D62B276D579A5F2E5DD8846C4249F51942CD08D7EE9E401E9010E130D35EC2BEFB64E4DD6845BDEB46E9260E158F2269FDC1B9EB28', '선해수', 'jumong@google.com', '010', '6894', '5768', '1989-12-31', '32455', '서울시 성수구 둣심로 42', '4층 402호(우동)', '2022-11-10 14:45:48', '2022-11-10 14:45:48' , 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'Y', 'N');

# SELECT 실행
# (1)번 조건
SELECT id, name
FROM test.tbl_user
WHERE id = 'psm1017';

# (2)번 조건 : 성이 박씨, 이메일 도메인이 naver, 출생연도가 1990 이후
SELECT id, name
FROM test.tbl_user
WHERE name LIKE '박%';

SELECT id, name, email
FROM test.tbl_user
WHERE email LIKE '%@naver%';

SELECT id, name, birthday
FROM test.tbl_user
WHERE birthday >= '1990-01-01';

# (3)번 조건 : 박 씨이면서 번호 뒷자리가 7790, 1990년생 이후이면서 액션에 관심이 있는 사람, 2022년 10월 이전에 수신에 하나라도 동의한 사람
SELECT id, name, phone_number_first, phone_number_second, phone_number_third
FROM test.tbl_user
WHERE name LIKE '박%'
AND   phone_number_third = '7790';

SELECT id, name, birthday, interest_action
FROM test.tbl_user
WHERE birthday >= '1990-01-01'
AND interest_action = 'Y';

SELECT id, name, email_send_agreed_at, phone_send_agreed_at
FROM test.tbl_user
WHERE	email_send_agreed_at <= '2022-10-01'
OR		phone_send_agreed_at <= '2022-10-01';

# UPDATE 실행alter

SELECT id, name, password FROM test.tbl_user WHERE id = 'psm1017';
UPDATE test.tbl_user
SET password = 'F4ED4429E1AF3130AC85F45FC1F3418D7A295D81EEDB4487F164A3CCAEC257CB59DA815328FF0F720B24EAB67C649500A5454B7AC2FEE217BE554CB90FCA3537'
WHERE id = 'psm1017' AND password = '9DB35390D2D537C0C1D7144260F90C94AEA8B5B90E28969A29B061157BF846728E307075AB963D411677090E838CDF86E684ABEC72DDCEA6F27E04E45763FFEF';
SELECT id, name, password FROM test.tbl_user WHERE id = 'psm1017';

SELECT id, name, zipcode, address, address_detail FROM test.tbl_user WHERE id = 'superman';
UPDATE test.tbl_user
SET zipcode = '23665',
	address = '대구시 서구 평현로 35길 44',
    address_detail = '107층(하늘동)'
WHERE id = 'superman';
SELECT id, name, zipcode, address, address_detail FROM test.tbl_user WHERE id = 'superman';

SELECT id, name, phone_number_first, phone_number_second, phone_number_third FROM test.tbl_user WHERE id = 'chidin';
UPDATE test.tbl_user
SET	phone_number_first = '010',
	phone_number_second = '1577',
    phone_number_third = '8892'
WHERE id = 'chidin';
SELECT id, name, phone_number_first, phone_number_second, phone_number_third FROM test.tbl_user WHERE id = 'chidin';

SELECT id, name, email FROM test.tbl_user WHERE id = 'realguy';
UPDATE test.tbl_user
SET	email = 'captain@koreait.co.kr'
WHERE id = 'realguy';
SELECT id, name, email FROM test.tbl_user WHERE id = 'realguy';

SELECT id, name, zipcode, address, address_detail, phone_number_first, phone_number_second, phone_number_third, email FROM test.tbl_user WHERE id = 'iamgood';
UPDATE test.tbl_user
SET	zipcode = '55423',
	address = '부산광역시 해운대구 해운대로 34',
    address_detail = '부산냉면집(해운동)',
    phone_number_first = '010',
    phone_number_second = '7979',
    phone_number_third = '5874',
    email = 'coolnoodle@busan.org'
WHERE id = 'iamgood';
SELECT id, name, zipcode, address, address_detail, phone_number_first, phone_number_second, phone_number_third, email FROM test.tbl_user WHERE id = 'iamgood';

DESC test.tbl_user;
