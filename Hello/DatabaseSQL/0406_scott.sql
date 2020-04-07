-- CREATE TABLE  table_name ( [column_name  data_type] );


/*
(1)학점관리 : student_score

학번	id	char(10) //우리학교 학번은 열자리	
이름	name	varchar2(10)
국어	kor	number(3)//최대 점수는 100점 3자리 -999~+999 
영어	eng	number(3)
총점	total	number(3)
평균	avg	number(5,2)//최대 점수는 100점 3자리 소수점 2자리까지 표현
*/

CREATE TABLE student_score(
    id char(10),
    name varchar2(10),
    kor number(3),
    eng number(3),
    total number(3),
    avg number(5,2)
);


--구조 확인
--DESC student_score;
--DROP TABlE student_score;

/*
테이블 구조 변경
ALTER   TABLE  table_name ADD ( [ column_name  data_type ] );
        MODIFY( [ column_name  data_type ] );
        DROP( [ column_name ] );
*/
--수학점수 추가
ALTER TABLE student_score 
    ADD(math number(3));
    
--총점 컬럼 삭제
ALTER TABlE student_score DROP(total);

--평균 컬럼을 소수점 1자리로 변경
ALTER TABlE student_score MODIFY(AVG NUMBER(4,1));
--################################DML#####################
/*
 
 INSERT    INTO   table_name( columns ) VALUES ( values );

           -UPDATE : 수정

                       UPDATE  table_name SETcolumn=value WHEREcondition;

           -DELETE : 삭제

                       DELETE            FROMtable_name WHEREcondition;

           -SELECT : 검색

                       SELECT columns FROM table_name WHEREcondition;

*/
INSERT    INTO   student_score(id,name,kor,eng,math)
VALUES('1601111','홍길동',90,50,40);

--검색
SELECT * FROM student_score;

--학번이 2000인 홍길자 학생의 국어와 수학점수를 각각 50, 80 입력하기
INSERT    INTO   student_score(id,name,kor,math)
VALUES('1602000','홍길자',50,80);

--확실하게 디스크에 저장 하겠습니다. 싱크 맞추겠습니다.
COMMIT;

--과감하게 데이터 날려버리자
DELETE FROM student_score;

--과감하게 데이터를 날려버렸다면 다시 돌려 놓자
ROLLBACK;

--홍길자 학생의 정보를 지우기
DELETE FROM student_score where kor=50;

--수정 해봅시다
/*
-UPDATE : 수정
UPDATE  table_name SETcolumn=value WHEREcondition;
*/
--홍길동 학생의 학번을 1000으로 수정 해주세요
UPDATE student_score SET id='1000' where name='홍길동';
UPDATE student_score SET id='2000' where name='홍길자';

--1000번학생 수학 점수 77-> 44 변경
UPDATE student_score SET math='44' where id='1000';

--2000번 학생 영어 점수를 80로 입력//말이 입력이지 UPDATE 입니다.
--UPDATE는 이미 입력된(INSERT로 입력된) 레코드에서 값 하나만 바꾸는거
UPDATE student_score SET math='44' where id='2000';
UPDATE student_score SET eng='80' where id='2000';

--평균 구하기 (영어+국어+수학)/3
--where을 입력안하면 모든 레코드의 값이 전부 바뀐다.
--nvl => null값을 다른 숫자로 대치해서 계산 하겠습니다.
UPDATE student_score SET avg=(kor+eng+nvl(math,0))/3;

--테이블 복사하기 emp에 든 내용을 복사 해왔습니다.
--scott에 tabel에 들어가 있습니다.
CREATE TABLE emp_copy
AS SELECT empno, ename, sal, comm,hiredate,deptno 
FROM emp;

--문제풀기
SELECT * FROM emp_copy;
--1. 사원번호가 7782인 사원의 부서를 10번으로 변경
UPDATE emp_copy SET deptno=10 where empno=7782;
--2. 사원번호가 7782인 사원의 이름을 홍길숙으로 변경하고 급여를 3500으로 변경
UPDATE emp_copy set ename='홍길숙',sal=3500 where empno=7782;
--3. 모든 부서원의 보너스를 300씩 인상 변경
--UPDATE emp_copy set comm=+300; 라고 입력한거는 보너스를 300으로 바꿔주는 것이다 인상이 아니다.
UPDATE emp_copy set comm=nvl(comm,0)+300;
--4. 사원번호가 7499인 사원의 정보를 삭제
DELETE FROM emp_copy where empno=7499;
--입사일자가 81년 6월 1일 이전인 사원의 정보를 삭제
DELETE FROM emp_copy where hiredate<'810601';

/*
테이블 명 : info_tab

이름	name	char(5)
아이디 	jumin	char(14)
전화	tel	varchar2(20)
성별	gender	varchar2(4)
나이	age	number
출신지	home	varchar2(20)
*/
--테이블 만들기
--주의 테이블을 만들고 데이터 형을 변경하기 위해서는 ALTER MODIFY를 사용 하는 걸로
CREATE TABLE info_tab(
name char(10),
jumin char(14),
tel varchar2(20),
gender varchar2(4),
age number,
home varchar2(20));
--
ALTER TABlE info_tab MODIFY(NAME CHAR(10));
--레코드 삽입
INSERT INTO info_tab(name,jumin,tel,gender,age,home) VALUES('홍길동','800608-1234567','010-265-6954','남성',33,'서울');
--확인
SELECT * FROM INFO_TAB;

--나이 27세에 남성 정보 입력
INSERT INTO info_tab(gender,age) VALUES('남성',27);

--주의!!! 데이터 베이스 설계를 잘해서 쓰레기가 안생기도록 주의하자
--중복된 레코드가 들어갈 경우 등 제약조건을 주자
/*
NOT NULL꼭 필수입력 사항을 받을 때 
PRIMARY KEY는 무조건 꼭꼭 만들어 줘야한다. 그래야 검색 할 수있다.
//UNIQUE와 PK의 차이점 UNIQUE는 안줘도 되지만 PK는 꼭 필요하다
CHECK 제한적인 입력처리 (남자만 입력하게 하기위해서)
DFAULT 입력값이 없어서 기본값을 줄 때 ( null 일때 주어지는 기본값을 정해준다.)
UNIQUE 중복되는 값 안돼
*/
--테이블 다 날리자
--비디오가게를 전제로 할 때 고객 관리
--DROP TABlE info_tab;
CREATE TABLE info_tab(
name char(10) NOT NULL,
jumin char(14),
tel varchar2(20),
gender varchar2(4),
age number,
home varchar2(20),--제약조건
CONSTRAINT pk_info_tel PRIMARY KEY (tel));
--PK지정 (tel)에

--다시 데이터1입력 
INSERT INTO info_tab(name,jumin,tel,gender,age,home) VALUES('홍길동','800608-1234567','010-265-6954','남성',33,'서울');
--무결성 제약 조건 PK는 유일무이하다.
--위 데이터에서 전화번호를 바꿔보자(데이터2)
INSERT INTO info_tab(name,jumin,tel,gender,age,home) VALUES('홍길동','800608-1234567','010-333-6954','남성',33,'서울');
--데이터3 오류 반드시입력되야하는 전화번호가 입력이 안되서
--INSERT INTO info_tab(gender,age) VALUES('남성',27);
INSERT INTO info_tab(name,tel,gender,age) VALUES('홍길자','010-222-3333','남성',27);
--확인
SELECT * FROM INFO_TAB;

--UNIQUE 주민번호에 제약조건
--ALTER TABLE info_tab ADD CONSTRAINT uq_info_jumin UNIQUE(jumin);

--전화번호가 010-333-6954 인 col읮 주민 번호 200101-1111111변경 //주민번호가 중복이있어서 UNIQUE 설정이 안됨 그래서 수정
UPDATE info_tab set jumin='200101-1111111' where tel='010-333-6954';

--다시 UNIQUE 주민번호에 제약조건
ALTER TABLE info_tab ADD CONSTRAINT uq_info_jumin UNIQUE(jumin);

--제약조건 확인
SELECT constraint_name, constraint_type
FROM user_constraints 
where table_name='INFO_TAB';

--CHECK 제약 조건 테이블 생성 후에 주기
ALTER TABLE info_tab ADD CONSTRAINT ck_info_gender CHECK(gender IN('남성','여성'));

--PK로 검색해서 성별을 '남성'으로 수정 
--UPDATE info_tab set gender='남자' where tel='010-333-6954';

--DFAULT는 기존에 있는 gender의 데이터형을 바꿔줘야한다.
AlTER TABLE info_tab MODIFY gender varchar2(4)  DEFAULT '남성';
--DEFAULT 값이 지정되도 잘 저장되는지
INSERT INTO info_tab(name, tel,gender)
VALUES('홍순이','051-5555','여성');
--null 값일 때 default 값이 잘나오는 지
INSERT INTO info_tab(name, tel)
VALUES('홍갑이','061-666666');

--다시 테이블 만들면서 제약조건 설정하기
CREATE TABLE info_tab(
name char(10) NOT NULL,
jumin char(14),
tel varchar2(20),
gender varchar2(4) DEFAULT '남자',
age number,
home varchar2(20),--제약조건
CONSTRAINT pk_info_tel PRIMARY KEY (tel)
,CONSTRAINT uq_info_jumin UNIQUE (jumin)
,CONSTRAINT check_gender CHECK (gender IN('남자','여자'))
);
--입력
INSERT INTO info_tab( name, tel, jumin )
VALUES('갑순이', '02-777-4444', '990909-1234567');

INSERT INTO info_tab( name, tel, jumin, gender, age, home )
VALUES('갑갑이','03-555-5555', '880808-1234567', '남자', 27,'경기');

INSERT INTO info_tab( name, tel, jumin, gender, age, home )
VALUES('홍길동','03-031-0310', '900909-1234567', '남성', 27,'경기');
--오류 체크 제약 조건으로 '남자','여자'만 지정해 줬는데 '남성'은 포함되지 않는다.

INSERT INTO info_tab( name, jumin) VALUES('홍길자', '550505-1234567');
--tel이 PK로 필수로 입력되고 not null이어야하는데 둘다 충족되지 않는다.

INSERT INTO info_tab( tel, jumin ) VALUES('031-777-7777', '700707-1234567');
--name이 not null로  null로 지정되면 안되기에 데이터를 입력해줘야하는데 null값으로 지정되고 있다.

INSERT INTO info_tab( name, tel, jumin ) VALUES('갑동이', '031-000-0000', '700707-1234567');

--emp_copy에 사번이 7900인 홀길동 사원의 정보를 입력하기
INSERT INTO emp_copy(EMPNO,ENAME)VALUES(7900,'홍길동');

--emp에 사번이 7369인 홀길동 사원의 정보를 입력하기
--사번이 PK여서 입력이 안된다.
INSERT INTO emp(EMPNO,ENAME)VALUES(7369,'홍길동');

--emp_copy에도 사번이 PK로 지정해주기
ALTER TABLE emp_copy ADD CONSTRAINTS pk_EMPNO PRIMARY KEY(EMPNO);

--EMP 테이블에 사번 8888인 갑동이 사원의 정보를 입력하되 부서번호가 99를 입력 
--DEPT 테이블이 부서정보를 EMP에 DEPTNO를 연결  시켜줌
--테이블 과 테이블 연결 시킨거를 FOREIGN KEY라고 한다.
INSERT INTO emp_copy(EMPNO,ENAME,DEPTNO) VALUES(8888,'갑동이',99);

--FK(FOREIGN KEY) 
/*ALTER  TABLE   table_name
ADD  CONSTRAINTS  fk_name  FOREIGN  KEY ( column_name )
REFERENCES  ref_table_name ( ref_column_name );
*/
--emp_copy에 설정
ALTER TABLE emp_copy 
ADD CONSTRAINT fk_emp_copy_depno FOREIGN KEY(DEPTNO)
REFERENCES dept(deptno);

--1번
CREATE TABLE sawon(
sabun number(6),
sawon_name char(5),
ubmu varchar2(10),
weolgub number(10,2) ,
buseo number(3)
);

--2번
ALTER TABLE sawon
ADD CONSTRAINT pk_sawon_sabun PRIMARY KEY(sabun);

--3번

ALTER TABLE sawon 
ADD (jiyeok char(10)NOT NULL) ;

--확인
SELECT * FROM sawon;
SELECT * FROM buseo;
--확인
SELECT constraint_name, constraint_type
FROM user_constraints 
where table_name='SAWON';

--4번
ALTER TABLE sawon
MODIFY (weolgub number(7));

--5번
ALTER TABLE sawon
ADD CONSTRAINT ck_sawon_ubmu CHECK(ubmu IN ('개발','유지보수','관리'));

--6번
ALTER TABLE sawon
MODIFY ubmu  DEFAULT '개발';

--7번
CREATE TABLE buseo(
buseo_no number(3),
buseo_name char(10),
CONSTRAINT pk_buseo_buseo_no PRIMARY KEY (buseo_no));

--8번
ALTER TABLE sawon 
ADD CONSTRAINT fk_sawon_buseo FOREIGN KEY(buseo)
REFERENCES buseo(buseo_no);

--9번
INSERT INTO buseo (buseo_no,buseo_name) VALUES (101,'소프트웨어유지보수부');
INSERT INTO buseo (buseo_no,buseo_name) VALUES (202,'관리부');
INSERT INTO buseo (buseo_no,buseo_name) VALUES (303,'인적자원부');

ALTER TABLE sawon
MODIFY (sawon_name char(10)) ;

--10번(총2개)
INSERT INTO sawon(sabun, sawon_name,weolgub,buseo,jiyeok) VALUES (8001,'홍길동이군',100000,'101','부산');
--check 조건에 위배됨
INSERT INTO sawon(sabun, sawon_name,ubmu,weolgub,buseo,jiyeok) VALUES (8002,'홍길자','사무',200000,'202','인천');
--부서 111은 없다. 무결성 제약 조건
INSERT INTO sawon(sabun, sawon_name,ubmu,buseo,jiyeok) VALUES (8003,'홍길순','개발',111,'대전');
--weolgub 정수형 7자리인데 8자리, 
INSERT INTO sawon(sabun, sawon_name,weolgub,jiyeok) VALUES (8004,'홍길석',12345678,'서울');
INSERT INTO sawon(sabun, sawon_name,ubmu,buseo,jiyeok) VALUES (8005,'홍길철','유지보수',303,'판교');

--11번 문제
ALTER TABLE sawon DROP (jiyeok);

--12번
-- foreign 키로 연결되어있어서 삭제가 불가능하다.
DELETE FROM buseo where buseo_name='인적자원부';

--13번
--저장공간을 해제
--delete는 1을 삭제하면 다음 값을 입력하면 저장공간은 그대로 있곡 2로 입력이 되는데
--truncate는 1을 삭제하면 다음 값을 입력할 때 1로 입력된다.
TRUNCATE TABLE sawon;

CREATE USER 'canon';
IDENTIFIED BY 'kosmo';




 
