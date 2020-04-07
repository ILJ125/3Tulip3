CREATE TABLE sawon(
sabun number(6),
sawon_name char(10),
ubmu varchar2(20) DEFAULT '개발',
weolgub number(7) ,
buseo number(3),
jiyeok char(20) NOT NULL,
CONSTRAINT pk_sabun PRIMARY KEY(sabun),
CONSTRAINT ck_ubmu CHECK (ubmu IN ('개발','유지보수','관리')),
CONSTRAINT fk_buseo FOREIGN KEY(buseo) 
REFERENCES buseo(buseo_no)
);
CREATE TABLE buseo(
buseo_no number(3),
buseo_name char(20),
CONSTRAINT pk_buseo_no PRIMARY KEY(buseo_no)
);

==========04/07 복습 =====================
CREATE TABLE gogek(
id char(8),
name char(10) not null,
tel char(20),
CONSTRAINT pk_id PRIMARY KEY(id)
);
CREATE TABLE sangpum(
no char(6),
title char(20) not null,
detail char(100),
count number(20) not null,
price number(20),
CONSTRAINT pk_no PRIMARY KEY(no)
);
CREATE TABLE jumun(
no number(4),
gogek char(8),
sangpum char(6),
count number(10),
jumunil DATE,
CONSTRAINT pk_jumun_no PRIMARY KEY(no),
CONSTRAINT fk_jumun_gogek FOREIGN KEY(gogek) REFERENCES gogek(id),
CONSTRAINT fk_jumun_sangpum FOREIGN KEY(sangpum) REFERENCES sangpum(no)
);

--데이터 입력
INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','홍길동', '031-333-3333' );

INSERT INTO gogek ( id, name, tel ) VALUES('babo1111','김길동', '031-111-1111' );

INSERT INTO gogek ( id, name, tel ) VALUES('babo2222','홍길동', '031-222-2222' );

INSERT INTO gogek ( id, name, tel ) VALUES('babo9999','박길동', '031-333-3333' );
--오류 id가 겹친다.
INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','맹길동', '031-999-9999' );
--오률 id 값이 너무 크다
INSERT INTO gogek ( id, name, tel ) VALUES('babo12345','이길동', '031-333-1234' );

INSERT INTO gogek ( id, name, tel ) VALUES('123','최길동', '031-999-9999' );

INSERT INTO gogek ( id, name ) VALUES('babo','봉길동' );
--필수 입력 값 name이 null이다.
INSERT INTO gogek ( id, tel ) VALUES('babo1988','031-888-8888' );

 

 

INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00001','이쁜바지', 30, 1000, '싸고이뻐서 금방 다 팔릴 바지입니다' );

INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00002','그냥바지', 20, 500, '그냥이뻐고 편안한 바지입니다' );

INSERT INTO sangpum ( no, title, count )VALUES ('B00009','윗도리', 20 );
--오류 입력하겠다는 값 보다 데이터가 더 많음
INSERT INTO sangpum ( no, title, count,price ) VALUES ('Z0001','비싼코트', 3, 20000, '겁나 비싼코트입니다' );
--오류 어디에 멀 집어넣을 지 입력하지 않았을 떄 테이블의 순서대로 값을 입력 받는데  순서가 적합하지 않다
INSERT INTO sangpum VALUES ('Z00001','비싼코트2', 5, 20000, '겁나 비싼 코트입니다' );

INSERT INTO sangpum VALUES ('Z00001','비싼코트3','겁나 비싼 코트입니다', 5, 20000);

 

 

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1000, 'babo1234', 'A00001', 1, '2016/09/09' );

--오류 babo1233은 없는 아이디
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1001, 'babo1233', 'Z00001', 1, '2016/09/09' );

--오류 Babo1235 아이디 없어여 대문자 소문자 구분합니다.
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1002, 'Babo1234', 'A00002', 2, '2016/09/10' );

--오류 B00001 값이 없다. 
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1003, 'babo1234', 'B00001', 1, '2016/09/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1004, 'babo', 'Z00001', 1, '2016/10/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1005, 'babo1234', 'B00009', 1, '2016/11/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1006, 'babo1234', 'B00009', 1, '2016/12/12' );

--데이터 변경 및 검색
--gogek 전체 검색
SELECT *
FROM gogek;
--1.전화번호가 없는 고객은 누구인지 고객명을 검색하세요
SELECT name
FROM gogek
WHERE tel is null;
--2.홍씨 성을 가진 고객들의 정보를 검색하세요
SELECT *
FROM gogek
WHERE name like '홍%';
--3.babo2222 고객명을 박길동으로 변경하세요
UPDATE gogek 
SET name='박길동'
WHERE id='babo2222';
--4.아이디 123 고객의 아이디를 babo123 으로 변경하세요
UPDATE gogek
SET id='babo123'
WHERE id='123';
--5.봉길동씨의 전화번호 02-555-5555를 추가하세요
UPDATE gogek
SET tel='02-555-5555'
WHERE name='봉길동';
--상품 테이블 검색
SELECT *
FROM sangpum;
--6.상품번호 B00009 에 가격 1200원 그리고 “겁나 쌕시한 옷입니다”라는 상품설명을 추가하세요
UPDATE sangpum
SET price='1200',detail='겁나 쌕시한 옷입니다'
WHERE no='B00009';
--7.이쁜바지 상품이 10개가 팔렸습니다.
UPDATE sangpum
SET count = count-10
WHERE title='이쁜바지';
--8.Z00001 상품이 3개가 더 입고 되었습니다.
UPDATE sangpum
SET count = count +3
WHERE no ='Z00001';
--9.상품 가격이 1000원을 넘는 상품들을 검색하세요
SELECT *
FROM sangpum
WHERE price > 1000;
--주문 테이블 검색
SELECT *
FROM jumun;
--10.11월 이후에 주문한 상품 번호를 검색하세요
SELECT *
FROM jumun
WHERE jumunil>='2016/11/01';

--11.babo 고객이 주문한 상품을 A00002로 변경하고 수량을 2개로 수정하세요
UPDATE jumun
SET sangpum='A00002',count=2
WHERE gogek='babo';
--12.babo1234 고객이 11월에 주문한 상품 번호을 검색하세요
SELECT sangpum
FROM jumun
WHERE gogek='babo1234' and (to_char(jumunil,'mm')='11');
--13.B00009 상품을 주문한 고객 아이디를 검색하세요
SELECT gogek
FROM jumun
WHERE sangpum='B00009';








