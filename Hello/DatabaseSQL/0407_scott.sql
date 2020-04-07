SELECT ename, sal, sal+nvl(comm,0)as total_sal FROM emp;

--연산과 함수를 사용하여 새로운 콜럼을 만들 겨우 별칭을 줘야한다. as (별칭) 
--as가 생략이 가능 하다.

--이름 데이터에 업무데이터를 붙여서 나올 수 있도록 
--노랑색이 별칭
SELECT  ename ||'['||job||']' ename,sal, sal+nvl(comm,0)as total_sal FROM emp;

--사원 테이블(emp)에서 업무만 출력 (JOB)
--all 을 써줘야 전부 출력된느데 all이 기본값이어서 생략 가능
SELECT all job FROM emp;
--DISTINCT  all이랑 같지만 중복이 배제 된다.
SELECT DISTINCT job FROM emp;

SELECT deptno FROM emp;
SELECT DISTINCT deptno FROM emp;

--부서 숫자도, 업무도 중복 배제 job deptno 두개의 값이 같은거 중복 배제
SELECT DISTINCT job ,deptno  FROM emp;

--문제1 20번 부서에 사원 번호, 이름, 부서번호을 출력하세요
SELECT empno,ename,deptno
FROM emp
WHERE deptno=20;
--문제2  입사일이 81/01/01에서 81/06/09인 사원의 사원번호, 이름, 입사일을 출력
--between 사용법 입사일 x날 ~ y날까지
--where hiredate BETWEEN 'x' AND 'y';
SELECT empno,ename,hiredate
FROM emp
WHERE hiredate BETWEEN '81/01/01' and '81/06/09' ;
-- 문제3- 담당업무가 salesman, clerk인 사원들의 이름과 업무를 출력
--주의 데이터는 소문자 대문자 구분 한다.
SELECT ename,job
FROM emp
WHERE job='SALESMAN' OR job='CLERK';
-- 문제4- 업무가 president이고/ 급여가 1500이상이거나 업무가 salesman인 사원의 정보를 출력
SELECT *
FROM emp
WHERE (sal>=1500 OR job='SALESMAN') AND job='PRESIDENT';  
--문제4- (업무가 president이고 급여가 1500이상이거나) 업무가 salesman인 사원의 정보를 출력
SELECT *
FROM emp
WHERE (job='PRESIDENT' AND sal>=1500) OR job='SALESMAN';   

-- 5- 업무가 president 또는 salesman이고 급여가 1500이상인 사원의 정보를 출력
SELECT *
FROM emp
WHERE (job='PRESIDENT' OR job='SALESMAN') AND sal>=1500 ;  

-- 6- 커미션(comm)이 없는 사원의 이름, 급여, 커미션을 출력
SELECT ename,sal,comm
FROM emp
WHERE nvl(comm,0)=0;

--  7- 사원명, 급여, 커미션, 총급여( 급여 + 커미션)을 출력
SELECT ename,sal,comm,sal+nvl(comm,0) as 총급여
FROM emp;
-- 8- 이름 A로 시작하는 사원명 출력
SELECT ename
FROM emp
WHERE ename LIKE 'A%';

-- 9- 이름이 두번째 문자가 L인 사원명 출력
SELECT ename
FROM emp
WHERE ename LIKE '_L%';

-- 10- 이름에 L이 두 번 이상 포함된 사원명 출력 // L이 2번이 무조건 포함된다면 L이 3번인거도 4번인거도 출력이 된다. 
SELECT ename
FROM emp
WHERE ename LIKE '%L%L%';

-- 11- 커미션(COMM)이 NULL이 아닌 사원의 모든 정보를 출력
SELECT *
FROM emp
WHERE comm is NOT NULL;

-- 12- 보너스가 급여보다 10%가 많은 모든 사원에 대해 이름, 급여, 보너스를 출력
SELECT ename,sal,comm
FROM emp
WHERE comm>sal+sal/10;

-- 13- 업무가 clerk이거나 analyst이고 급여가 1000, 3000, 5000이 아닌 모든 사원의 정보를 출력
--not in => not ( col name in (x,y));
SELECT *
FROM emp
WHERE (job='CLERK' OR job='ANALYST') AND not (sal  in (1000,3000,5000));

-- 14- 부서가 30이거나 또는 관리자가 7782인 사원의 모든 정보를 출력
SELECT *
FROM emp
WHERE deptno = 30 OR mgr=7782;

--자기정보 (사번 : 8000, 이름 : 홍길동, 직업 : 개발자) 입력
-----------------------------------------------------------INSERT INTO emp(ENAME,job,deptno)  VALUES ('홍길동','개발자',8000);

--부서번호로 정렬
SELECT *
FROM emp
--WHERE
ORDER BY deptno DESC;
--asc : 오름차순 10~ 40
--desc : 내림차순 
--부서번호로 정렬하되 급겨가 높은 순서대로 출력
SELECT *
FROM emp
ORDER BY deptno ASC,sal DESC;

--연습문제
-- 최근 입사한순으로 사원명, 급여, 입사일자를 출력
SELECT ename,sal,hiredate
FROM emp
ORDER BY hiredate DESC;
-- 커미션이 높은 순으로 정렬
--  (단, 커미션이 없으면 제일 나중에 출력되도록 )
SELECT *
FROM emp
ORDER BY nvl(comm,0) DESC; --만약 0 이 아니라 null을 마지막에 추력하고 싶으면 null 값을 -1로 주면 된다.
-- 부서번호로 정렬한 후 부서번호가 같을 경우는 급여가 많은순으로 정렬하여 사원번호, 이름, 업무, 부서번호, 급여를 출력
SELECT empno,ename,job,deptno,sal
FROM emp
ORDER BY deptno ASC,sal DESC;

--함수===========================================================================
--사원명, 급여, 월급(급여/12)를 출력하되 월급은 십단위에서 반올림하여 출력
SELECT ename,sal,ROUND(sal/12,-2) as "월급"
FROM emp;
 
--사원명, 급여, 세금(급여의 3.3%)를 원단위 절삭하고 출력
SELECT ename,sal,TRUNC(sal*3.3/100,-1) as "세금"
FROM emp;

 -- smith의정보를 사원번호, 성명, 담당업무(소문자) 출력
SELECT empno,ename,lower(job) as job
FROM emp
where ename = upper('smith');
          

-- 사원번호, 사원명(첫글자만 대문자), 담당업무(첫글자만대문자)로 출력
SELECT empno,INITCAP(ename),INITCAP(job)
FROM emp;
          

-- 이름의 첫글자가 ‘K’보다크고 ‘Y’보다 작은 사원의 정보( 사원번호, 이름, 업무, 급여, 부서번호)를 출력하되 이름순으로 정렬
SELECT empno,ename,job,sal,deptno
FROM emp
where  SUBSTR(ename,1,1) between 'K' and 'Y'
ORDER BY ename;

--info_tab 테이블에 주민번호에서 년도만 출력하기
SELECT subSTR(jumin,1,2)as "출생년도"
FROM info_tab;

--info_tab 테이블에 주민번호에서 성별만 출력하기
SELECT decode(SUBSTR(jumin,8,1),1,'남자',2,'여자') as 성별
FROM info_tab;

-- 이름이 5글자 이상인사원들을 출력
SELECT *
FROM emp
WHERE LENGTH(ename)>=5;
  

-- 이름을 15자로 맞추고글자는 왼쪽에 오른쪽에는 ‘*’로 채운다
SELECT RPAD(ename,15,'*')
FROM emp;
 

-- 급여은 10자로 맞추고숫자는 오른쪽에 왼쪽엔 ‘-‘로 채운다
SELECT LPAD(sal,10,'-')
FROM emp;
 

--양쪽 공백을 제거
/*
 select  '-' || trim(' 이순신 ')|| '-' as col1,
 '-'|| ltrim(' 이순신 ') || '-' as col2,
 '-'|| rtrim(' 이순신 ') || '-' as col3 from dual;
*/
 
-- 급여를 숫자에서 ‘영일이삼사오육칠팔구’ 글자로 대체
SELECT TRANSLATE(sal,'0123456789','영일이삼사오육칠팔구')SAL
FROM emp;
        
-- 급여의 숫자에서 0을‘$’로 바꾸어 출력
-- 중간 공백을 제거할 때 사용
select REPLACE(sal,0,'$')sal
FROM emp;

--간단한 결과를 테이블 안만들고 바로 출력하고 싶을 때 dual이라는 더미테이블 사용
SELECT sysdate
FROM dual;
 
SELECT 1+2
FROM dual;

-- 앞 뒤 공백 제거 TRIM ,RTRIM : 오른 쪽 공백 제거 ,LTRIM : 왼쪽 공백 제거
SELECT TRIM('   홍  길    동  ') FROM dual;

--중간 공백도 제거 replace
SELECT replace('   홍     길  동   ',' ',null) FROM dual;

--날짜형 함수
-- 현재까지 근무일 수가 많은 사람 순으로 출력
SELECT *
FROM emp
ORDER BY SYSDATE-nvl(hiredate,SYSDATE) DESC;
          

-- 현재까지 근무일 수가 몇 주 몇 일인가를 출력
--mod 값은 나머지 이지만 정수값이 아니다. 소수점으로 나온다.
SELECT TRUNC(((sysdate-hiredate)/7),0)||'주' as week,CEIL(MOD((sysdate-hiredate),7))||'일' as days
FROM emp;

-- 10번 부서의 사원의 현재까지의 근무 월수를 계산
SELECT ename, TRUNC(months_between (sysdate,hiredate),0) as "월수"
FROM emp
where deptno=10;
          

-- 현재 날짜에서 3개월후의 날짜 구하기
-- select  add_months( sysdate, 3 ) as mydate from dual;


-- 현재 날짜에서 돌아오는 ‘월’요일의 날짜 구하기
-- 지역의 언어를 인식 하기에 한글로 입력해야한다.
SELECT next_day(sysdate,'월') as "다음주월요일"FROM dual ;
          

-- 현재 날짜에서 해당 월의 마지막 날짜 구하기
-- 다른 날짜에 마지막 날을 구하고 싶으면 직접 날짜를 입력해주면된다. '년/월/일'
--SELECT last_day('2020/08/06')as"4월마지막" FROM dual ;
SELECT last_day(sysdate)as"4월마지막" FROM dual ;
  
  
--변환 변수
-- 입사일자에서 입사년도를 출력
-- 년도,월,일 TO char (데이터,'YYYY'),'MM','DD'
SELECT ename,hiredate,TO_CHAR(hiredate,'YYYY') hire_year,TO_CHAR(hiredate,'MM') hire_month,TO_CHAR(hiredate,'DD') hire_days
FROM emp;
          

-- 입사일자를 ‘1999년 1월 1일’ 형식으로 출력
-- TO_CHAR 사용
SELECT TO_CHAR(hiredate,'YYYY"년" MM"월" DD"일"')as hiredate
FROM emp;
          

-- 1981년도에 입사한 사원 검색
SELECT *
FROM emp
WHERE TO_CHAR(hiredate,'YYYY')=1981;
 

-- 5월에 입사한 사원 검색
SELECT *
FROM emp
WHERE TO_CHAR(hiredate,'MM')=05;

-- 81년 2월에 입사한 사원 검색
SELECT *
FROM emp
--WHERE TO_CHAR(hiredate,'YYYY')=1981 AND TO_CHAR(hiredate,'MM')=02 ;
WHERE TO_CHAR(hiredate,'YYYYMM')=198102; 
-- 81년 입사하지 않은 사원 검색
SELECT *
FROM emp
WHERE not TO_CHAR(hiredate,'YYYY')=1981;
-- 81년 하반기에 입사한 사원 검색
SELECT *
FROM emp
WHERE TO_CHAR(hiredate,'YYYY')=1981 AND TO_CHAR(hiredate,'MM')>06 ;

-- 급여 앞에 $를 삽입하고 3자리 마다 ,를 출력
-- 데이터는 숫자 그대로 이나 to_char로 인해 출력되는 형태에 변화를 준거다
-- 넉넉잡아 많이 주자.
SELECT ename,sal,to_char(sal,'$999,999,999') as dollar
FROM emp;


