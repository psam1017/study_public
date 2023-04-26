
# Web 개발 -> 사용자 정보 다루기
# Web 개발 -> 게시판 시스템 BBS(Bulletin Board System)
# 인터넷 게시판은 BBS, 스레드 등을 주로 사용한다. 국내에서는 BBS를 주로 사용한다.

CREATE SCHEMA `study_web`;

CREATE TABLE study_web.user_genders(
	`value` VARCHAR(1) NOT NULL PRIMARY KEY,
    `text` VARCHAR(5) NOT NULL
);

INSERT INTO study_web.user_genders
VALUES	('M', '남'),
		('F', '여');

CREATE TABLE study_web.user_contact_telecoms(
	`value` VARCHAR(3) NOT NULL,
    `text` VARCHAR(5) NOT NULL,
    CONSTRAINT PRIMARY KEY(`value`)
);

INSERT INTO study_web.user_contact_telecoms
VALUES	('KT', 'KT'),
		('SKT', 'SKT'),
        ('LGU', 'LGU+');

CREATE TABLE study_web.user_statuses(
	`value` VARCHAR(3) NOT NULL PRIMARY KEY,
    `text` VARCHAR(50) NOT NULL
);

INSERT INTO study_web.user_statuses
VALUES	('EML', '이메일 인증 필요'),
		('OKY', '정상'),
        ('SUS', '정지'),
        ('DEL', '탈퇴');

# password VARCHAR(128) -> SHA512 알고리즘은 128 Bytes를 사용하여 단방향 암호화한다.
# COMMENT '주석 내용'
# contact_second VARCHAR(4) -> 숫자형 자료로 해버리면 0055 -> 55로 바뀌기 때문에.
# agreed_term_at DATE -> 개인 정보 수집 기간, 약관 재동의 등에 일자 정보가 필요함.
CREATE TABLE study_web.users(
	email					VARCHAR(50) NOT NULL PRIMARY KEY,
    password				VARCHAR(128) NOT NULL COMMENT 'SHA-512 해시 필요',
    nickname				VARCHAR(10) NOT NULL UNIQUE,
    name					VARCHAR(5) NOT NULL,
    gender_value			VARCHAR(1) NOT NULL,
    contact_telecom_value	VARCHAR(3) NOT NULL,
    contact_first			VARCHAR(4) NOT NULL,
    contact_second			VARCHAR(4) NOT NULL,
    contact_third			VARCHAR(4) NOT NULL,
    birth_date				DATE NOT NULL,
    agreed_term_at			DATETIME NOT NULL,
    agreed_marketing_at		DATETIME NULL DEFAULT NULL,
    created_at				DATETIME NOT NULL DEFAULT NOW(),
    status_code				VARCHAR(3) NOT NULL,
    CONSTRAINT FOREIGN KEY (gender_value)
		REFERENCES study_web.user_genders (value)
			ON DELETE CASCADE
            ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (contact_telecom_value)
		REFERENCES study_web.user_contact_telecoms (value)
			ON DELETE CASCADE
            ON UPDATE CASCADE,
	CONSTRAINT UNIQUE (contact_first, contact_second, contact_third),
	CONSTRAINT FOREIGN KEY (status_code)
		REFERENCES study_web.user_statuses (value)
			ON DELETE CASCADE
            ON UPDATE CASCADE
);

DESC study_web.users;

INSERT INTO study_web.users
VALUES	('admin@sample.com', 'C7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC',
        '관리자', '관리자', 'M',
        'SKT', '010', '1234', '1234',
        '0000-01-01',
        NOW(), NULL, NOW(),
        'OKY'),
        ('user1@sample.com', '5703BDFBD16EF47F929DDBF4785D4486E385049F627233EFB359B094ADD552921033F95F6E89453EC81C5D502F3F477DE1E9C8948C61468A6ED9D9A615BDE126',
        '사용자1', '사용자1', 'M',
        'LGU', '010', '5678', '5678',
        '1955-06-11',
        NOW(), NULL, NOW(),
        'OKY'),
		('user2@sample.com', '27E21DFF71A5B350F3B44FE6CFBE7FA91B128B2204B1CF0970AC07937928B388FE600DA6C1C66D90D571BA60F94114B499142A8B7D4FAC10E60150F20D63215D',
        '사용자2', '사용자2', 'F',
        'KT', '010', '9090', '9090',
        '1999-10-22',
        NOW(), NULL, NOW(),
        'OKY');

# 게시글이 참조하는 엔터티 -> 게시판, 사용자
# 댓글이 참조하는 엔터티 -> 게시글, 사용자

CREATE TABLE study_web.bbs_boards(
	`value` VARCHAR(10) NOT NULL PRIMARY KEY,
    `text` VARCHAR(50) NOT NULL
);

INSERT INTO study_web.bbs_boards
VALUES	('free', '자유게시판'),
		('notice', '공지사항');

CREATE TABLE study_web.bbs_articles(
	`index`			INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `board_value`	VARCHAR(10) NOT NULL,
    `user_email`	VARCHAR(50) NOT NULL,
    `title`			VARCHAR(100) NOT NULL,
    `content`		VARCHAR(10000) NOT NULL,
    `written_at`	DATETIME NOT NULL DEFAULT NOW(),
    `view_count`	INT UNSIGNED NOT NULL DEFAULT 0,
    CONSTRAINT FOREIGN KEY (board_value)
		REFERENCES study_web.bbs_boards (value)
			ON DELETE CASCADE
            ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (user_email)
		REFERENCES study_web.users (email)
			ON DELETE CASCADE
            ON UPDATE CASCADE
);

INSERT INTO study_web.bbs_articles (board_value, user_email, title, content, written_at, view_count)
VALUES	('free', 'admin@sample.com', '자유게시판 이용 규칙', '아무 내용', NOW(), 13),
		('free', 'user1@sample.com', '삼성전자 88층에 갇혔습니다', '아무 내용', NOW(), 185),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 3),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'user1@sample.com', '삼전 앞으로 전망이 어떤가요?', '아무 내용', NOW(), 5),
        ('free', 'user1@sample.com', '이 게시판 아무도 안 쓰나요?', '아무 내용', NOW(), 8),
        ('free', 'user1@sample.com', '카카오 좀 살려주세요', '아무 내용', NOW(), 13),
		('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 0),
        ('free', 'user2@sample.com', '내가 광고충이지만 사용자1은 주식하지 마라', '아무 내용', NOW(), 250),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'user1@sample.com', '너 어디 사냐', '아무 내용', NOW(), 190),
        ('free', 'user1@sample.com', '사람 피 말리는데 그딴 글이나 적냐', '아무 내용', NOW(), 325),
        ('free', 'user1@sample.com', '내가 너 찾아간다', '아무 내용', NOW(), 266),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'user2@sample.com', '적중률 99% 종목 추천 카톡 sagi123', '아무 내용', NOW(), 1),
        ('free', 'admin@sample.com', '자유게시판 이용이 잠정 중단됩니다', '아무 내용', NOW(), 80);

CREATE TABLE study_web.bbs_comments(
	`index`			INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `article_index`	INT UNSIGNED NOT NULL,
    `user_email`	VARCHAR(50) NOT NULL,
    `content`		VARCHAR(10000) NOT NULL,
    `written_at`	DATETIME NOT NULL DEFAULT NOW(),
    CONSTRAINT FOREIGN KEY (article_index)
		REFERENCES study_web.bbs_articles (`index`)
			ON DELETE CASCADE
            ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (`user_email`)
		REFERENCES study_web.users (email)
			ON DELETE CASCADE
            ON UPDATE CASCADE
);

INSERT INTO study_web.bbs_comments (`article_index`, `user_email`, `content`, `written_at`)
VALUES (1, 'user1@sample.com', '네 알겠습니다.', NOW()),
		(13, 'user1@sample.com', '너 어디 사냐.', NOW()),
        (13, 'user1@sample.com', '대답', NOW()),
        (13, 'user1@sample.com', '대답!', NOW()),
        (16, 'user2@sample.com', '알아서 뭐하게', NOW()),
        (16, 'user2@sample.com', '그럴 시간에 주식 공부나 해', NOW()),
        (16, 'user1@sample.com', '너 내가 진짜 꼭 찾아간다.', NOW()),
        (16, 'user2@sample.com', 'ㅇㅇ', NOW()),
        (16, 'user1@sample.com', '장난 같지?', NOW()),
        (16, 'user1@sample.com', '불법 광고나 하는 녀석이', NOW()),
        (16, 'user2@sample.com', '너보다는 돈 잘 벌죠?', NOW()),
        (18, 'user2@sample.com', 'ㅇㅉㅌㅂ', NOW());



# 일반 게시판처럼 가장 최근 작성 게시글이 가장 맨 위로.
# 한 페이지에 표시할 게시글 개수 : 10개
# 1페이지를 보고 있다는 가정 하에 과제를 수행.
#	-> 페이지마다 10개씩 검색되도록 수행.
SELECT	게시판.text `게시판 구분`,
		게시글.index `글 번호`,
		게시글.title `제목`, 
        COUNT(댓글.article_index) `댓글`,
        사용자.nickname `작성자`,
        게시글.written_at `작성 일시`,
        게시글.view_count `조회수`
FROM study_web.bbs_articles 게시글
LEFT OUTER JOIN study_web.bbs_boards 게시판
	ON 게시글.board_value = 게시판.value
LEFT OUTER JOIN study_web.bbs_comments 댓글
	ON 게시글.index = 댓글.article_index
LEFT OUTER JOIN study_web.users 사용자
	ON 게시글.user_email = 사용자.email
GROUP BY `글 번호`
ORDER BY `글 번호` DESC
LIMIT 10 OFFSET 0;



# 변수 만드는 방법
SET @totalArticleCount = 11;
SET @articleCountPerPage = 10;

SELECT CEILING(@totalArticleCount / @articleCountPerPage);
