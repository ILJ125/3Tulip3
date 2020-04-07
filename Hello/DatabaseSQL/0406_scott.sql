-- CREATE TABLE  table_name ( [column_name  data_type] );


/*
(1)�������� : student_score

�й�	id	char(10) //�츮�б� �й��� ���ڸ�	
�̸�	name	varchar2(10)
����	kor	number(3)//�ִ� ������ 100�� 3�ڸ� -999~+999 
����	eng	number(3)
����	total	number(3)
���	avg	number(5,2)//�ִ� ������ 100�� 3�ڸ� �Ҽ��� 2�ڸ����� ǥ��
*/

CREATE TABLE student_score(
    id char(10),
    name varchar2(10),
    kor number(3),
    eng number(3),
    total number(3),
    avg number(5,2)
);


--���� Ȯ��
--DESC student_score;
--DROP TABlE student_score;

/*
���̺� ���� ����
ALTER   TABLE  table_name ADD ( [ column_name  data_type ] );
        MODIFY( [ column_name  data_type ] );
        DROP( [ column_name ] );
*/
--�������� �߰�
ALTER TABLE student_score 
    ADD(math number(3));
    
--���� �÷� ����
ALTER TABlE student_score DROP(total);

--��� �÷��� �Ҽ��� 1�ڸ��� ����
ALTER TABlE student_score MODIFY(AVG NUMBER(4,1));
--################################DML#####################
/*
 
 INSERT    INTO   table_name( columns ) VALUES ( values );

           -UPDATE : ����

                       UPDATE  table_name SETcolumn=value WHEREcondition;

           -DELETE : ����

                       DELETE            FROMtable_name WHEREcondition;

           -SELECT : �˻�

                       SELECT columns FROM table_name WHEREcondition;

*/
INSERT    INTO   student_score(id,name,kor,eng,math)
VALUES('1601111','ȫ�浿',90,50,40);

--�˻�
SELECT * FROM student_score;

--�й��� 2000�� ȫ���� �л��� ����� ���������� ���� 50, 80 �Է��ϱ�
INSERT    INTO   student_score(id,name,kor,math)
VALUES('1602000','ȫ����',50,80);

--Ȯ���ϰ� ��ũ�� ���� �ϰڽ��ϴ�. ��ũ ���߰ڽ��ϴ�.
COMMIT;

--�����ϰ� ������ ����������
DELETE FROM student_score;

--�����ϰ� �����͸� �������ȴٸ� �ٽ� ���� ����
ROLLBACK;

--ȫ���� �л��� ������ �����
DELETE FROM student_score where kor=50;

--���� �غ��ô�
/*
-UPDATE : ����
UPDATE  table_name SETcolumn=value WHEREcondition;
*/
--ȫ�浿 �л��� �й��� 1000���� ���� ���ּ���
UPDATE student_score SET id='1000' where name='ȫ�浿';
UPDATE student_score SET id='2000' where name='ȫ����';

--1000���л� ���� ���� 77-> 44 ����
UPDATE student_score SET math='44' where id='1000';

--2000�� �л� ���� ������ 80�� �Է�//���� �Է����� UPDATE �Դϴ�.
--UPDATE�� �̹� �Էµ�(INSERT�� �Էµ�) ���ڵ忡�� �� �ϳ��� �ٲٴ°�
UPDATE student_score SET math='44' where id='2000';
UPDATE student_score SET eng='80' where id='2000';

--��� ���ϱ� (����+����+����)/3
--where�� �Է¾��ϸ� ��� ���ڵ��� ���� ���� �ٲ��.
--nvl => null���� �ٸ� ���ڷ� ��ġ�ؼ� ��� �ϰڽ��ϴ�.
UPDATE student_score SET avg=(kor+eng+nvl(math,0))/3;

--���̺� �����ϱ� emp�� �� ������ ���� �ؿԽ��ϴ�.
--scott�� tabel�� �� �ֽ��ϴ�.
CREATE TABLE emp_copy
AS SELECT empno, ename, sal, comm,hiredate,deptno 
FROM emp;

--����Ǯ��
SELECT * FROM emp_copy;
--1. �����ȣ�� 7782�� ����� �μ��� 10������ ����
UPDATE emp_copy SET deptno=10 where empno=7782;
--2. �����ȣ�� 7782�� ����� �̸��� ȫ������� �����ϰ� �޿��� 3500���� ����
UPDATE emp_copy set ename='ȫ���',sal=3500 where empno=7782;
--3. ��� �μ����� ���ʽ��� 300�� �λ� ����
--UPDATE emp_copy set comm=+300; ��� �Է��ѰŴ� ���ʽ��� 300���� �ٲ��ִ� ���̴� �λ��� �ƴϴ�.
UPDATE emp_copy set comm=nvl(comm,0)+300;
--4. �����ȣ�� 7499�� ����� ������ ����
DELETE FROM emp_copy where empno=7499;
--�Ի����ڰ� 81�� 6�� 1�� ������ ����� ������ ����
DELETE FROM emp_copy where hiredate<'810601';

/*
���̺� �� : info_tab

�̸�	name	char(5)
���̵� 	jumin	char(14)
��ȭ	tel	varchar2(20)
����	gender	varchar2(4)
����	age	number
�����	home	varchar2(20)
*/
--���̺� �����
--���� ���̺��� ����� ������ ���� �����ϱ� ���ؼ��� ALTER MODIFY�� ��� �ϴ� �ɷ�
CREATE TABLE info_tab(
name char(10),
jumin char(14),
tel varchar2(20),
gender varchar2(4),
age number,
home varchar2(20));
--
ALTER TABlE info_tab MODIFY(NAME CHAR(10));
--���ڵ� ����
INSERT INTO info_tab(name,jumin,tel,gender,age,home) VALUES('ȫ�浿','800608-1234567','010-265-6954','����',33,'����');
--Ȯ��
SELECT * FROM INFO_TAB;

--���� 27���� ���� ���� �Է�
INSERT INTO info_tab(gender,age) VALUES('����',27);

--����!!! ������ ���̽� ���踦 ���ؼ� �����Ⱑ �Ȼ��⵵�� ��������
--�ߺ��� ���ڵ尡 �� ��� �� ���������� ����
/*
NOT NULL�� �ʼ��Է� ������ ���� �� 
PRIMARY KEY�� ������ ���� ����� ����Ѵ�. �׷��� �˻� �� ���ִ�.
//UNIQUE�� PK�� ������ UNIQUE�� ���൵ ������ PK�� �� �ʿ��ϴ�
CHECK �������� �Է�ó�� (���ڸ� �Է��ϰ� �ϱ����ؼ�)
DFAULT �Է°��� ��� �⺻���� �� �� ( null �϶� �־����� �⺻���� �����ش�.)
UNIQUE �ߺ��Ǵ� �� �ȵ�
*/
--���̺� �� ������
--�������Ը� ������ �� �� �� ����
--DROP TABlE info_tab;
CREATE TABLE info_tab(
name char(10) NOT NULL,
jumin char(14),
tel varchar2(20),
gender varchar2(4),
age number,
home varchar2(20),--��������
CONSTRAINT pk_info_tel PRIMARY KEY (tel));
--PK���� (tel)��

--�ٽ� ������1�Է� 
INSERT INTO info_tab(name,jumin,tel,gender,age,home) VALUES('ȫ�浿','800608-1234567','010-265-6954','����',33,'����');
--���Ἲ ���� ���� PK�� ���Ϲ����ϴ�.
--�� �����Ϳ��� ��ȭ��ȣ�� �ٲ㺸��(������2)
INSERT INTO info_tab(name,jumin,tel,gender,age,home) VALUES('ȫ�浿','800608-1234567','010-333-6954','����',33,'����');
--������3 ���� �ݵ���ԷµǾ��ϴ� ��ȭ��ȣ�� �Է��� �ȵǼ�
--INSERT INTO info_tab(gender,age) VALUES('����',27);
INSERT INTO info_tab(name,tel,gender,age) VALUES('ȫ����','010-222-3333','����',27);
--Ȯ��
SELECT * FROM INFO_TAB;

--UNIQUE �ֹι�ȣ�� ��������
--ALTER TABLE info_tab ADD CONSTRAINT uq_info_jumin UNIQUE(jumin);

--��ȭ��ȣ�� 010-333-6954 �� col�� �ֹ� ��ȣ 200101-1111111���� //�ֹι�ȣ�� �ߺ����־ UNIQUE ������ �ȵ� �׷��� ����
UPDATE info_tab set jumin='200101-1111111' where tel='010-333-6954';

--�ٽ� UNIQUE �ֹι�ȣ�� ��������
ALTER TABLE info_tab ADD CONSTRAINT uq_info_jumin UNIQUE(jumin);

--�������� Ȯ��
SELECT constraint_name, constraint_type
FROM user_constraints 
where table_name='INFO_TAB';

--CHECK ���� ���� ���̺� ���� �Ŀ� �ֱ�
ALTER TABLE info_tab ADD CONSTRAINT ck_info_gender CHECK(gender IN('����','����'));

--PK�� �˻��ؼ� ������ '����'���� ���� 
--UPDATE info_tab set gender='����' where tel='010-333-6954';

--DFAULT�� ������ �ִ� gender�� ���������� �ٲ�����Ѵ�.
AlTER TABLE info_tab MODIFY gender varchar2(4)  DEFAULT '����';
--DEFAULT ���� �����ǵ� �� ����Ǵ���
INSERT INTO info_tab(name, tel,gender)
VALUES('ȫ����','051-5555','����');
--null ���� �� default ���� �߳����� ��
INSERT INTO info_tab(name, tel)
VALUES('ȫ����','061-666666');

--�ٽ� ���̺� ����鼭 �������� �����ϱ�
CREATE TABLE info_tab(
name char(10) NOT NULL,
jumin char(14),
tel varchar2(20),
gender varchar2(4) DEFAULT '����',
age number,
home varchar2(20),--��������
CONSTRAINT pk_info_tel PRIMARY KEY (tel)
,CONSTRAINT uq_info_jumin UNIQUE (jumin)
,CONSTRAINT check_gender CHECK (gender IN('����','����'))
);
--�Է�
INSERT INTO info_tab( name, tel, jumin )
VALUES('������', '02-777-4444', '990909-1234567');

INSERT INTO info_tab( name, tel, jumin, gender, age, home )
VALUES('������','03-555-5555', '880808-1234567', '����', 27,'���');

INSERT INTO info_tab( name, tel, jumin, gender, age, home )
VALUES('ȫ�浿','03-031-0310', '900909-1234567', '����', 27,'���');
--���� üũ ���� �������� '����','����'�� ������ ��µ� '����'�� ���Ե��� �ʴ´�.

INSERT INTO info_tab( name, jumin) VALUES('ȫ����', '550505-1234567');
--tel�� PK�� �ʼ��� �Էµǰ� not null�̾���ϴµ� �Ѵ� �������� �ʴ´�.

INSERT INTO info_tab( tel, jumin ) VALUES('031-777-7777', '700707-1234567');
--name�� not null��  null�� �����Ǹ� �ȵǱ⿡ �����͸� �Է�������ϴµ� null������ �����ǰ� �ִ�.

INSERT INTO info_tab( name, tel, jumin ) VALUES('������', '031-000-0000', '700707-1234567');

--emp_copy�� ����� 7900�� Ȧ�浿 ����� ������ �Է��ϱ�
INSERT INTO emp_copy(EMPNO,ENAME)VALUES(7900,'ȫ�浿');

--emp�� ����� 7369�� Ȧ�浿 ����� ������ �Է��ϱ�
--����� PK���� �Է��� �ȵȴ�.
INSERT INTO emp(EMPNO,ENAME)VALUES(7369,'ȫ�浿');

--emp_copy���� ����� PK�� �������ֱ�
ALTER TABLE emp_copy ADD CONSTRAINTS pk_EMPNO PRIMARY KEY(EMPNO);

--EMP ���̺� ��� 8888�� ������ ����� ������ �Է��ϵ� �μ���ȣ�� 99�� �Է� 
--DEPT ���̺��� �μ������� EMP�� DEPTNO�� ����  ������
--���̺� �� ���̺� ���� ��Ų�Ÿ� FOREIGN KEY��� �Ѵ�.
INSERT INTO emp_copy(EMPNO,ENAME,DEPTNO) VALUES(8888,'������',99);

--FK(FOREIGN KEY) 
/*ALTER  TABLE   table_name
ADD  CONSTRAINTS  fk_name  FOREIGN  KEY ( column_name )
REFERENCES  ref_table_name ( ref_column_name );
*/
--emp_copy�� ����
ALTER TABLE emp_copy 
ADD CONSTRAINT fk_emp_copy_depno FOREIGN KEY(DEPTNO)
REFERENCES dept(deptno);

--1��
CREATE TABLE sawon(
sabun number(6),
sawon_name char(5),
ubmu varchar2(10),
weolgub number(10,2) ,
buseo number(3)
);

--2��
ALTER TABLE sawon
ADD CONSTRAINT pk_sawon_sabun PRIMARY KEY(sabun);

--3��

ALTER TABLE sawon 
ADD (jiyeok char(10)NOT NULL) ;

--Ȯ��
SELECT * FROM sawon;
SELECT * FROM buseo;
--Ȯ��
SELECT constraint_name, constraint_type
FROM user_constraints 
where table_name='SAWON';

--4��
ALTER TABLE sawon
MODIFY (weolgub number(7));

--5��
ALTER TABLE sawon
ADD CONSTRAINT ck_sawon_ubmu CHECK(ubmu IN ('����','��������','����'));

--6��
ALTER TABLE sawon
MODIFY ubmu  DEFAULT '����';

--7��
CREATE TABLE buseo(
buseo_no number(3),
buseo_name char(10),
CONSTRAINT pk_buseo_buseo_no PRIMARY KEY (buseo_no));

--8��
ALTER TABLE sawon 
ADD CONSTRAINT fk_sawon_buseo FOREIGN KEY(buseo)
REFERENCES buseo(buseo_no);

--9��
INSERT INTO buseo (buseo_no,buseo_name) VALUES (101,'����Ʈ��������������');
INSERT INTO buseo (buseo_no,buseo_name) VALUES (202,'������');
INSERT INTO buseo (buseo_no,buseo_name) VALUES (303,'�����ڿ���');

ALTER TABLE sawon
MODIFY (sawon_name char(10)) ;

--10��(��2��)
INSERT INTO sawon(sabun, sawon_name,weolgub,buseo,jiyeok) VALUES (8001,'ȫ�浿�̱�',100000,'101','�λ�');
--check ���ǿ� �����
INSERT INTO sawon(sabun, sawon_name,ubmu,weolgub,buseo,jiyeok) VALUES (8002,'ȫ����','�繫',200000,'202','��õ');
--�μ� 111�� ����. ���Ἲ ���� ����
INSERT INTO sawon(sabun, sawon_name,ubmu,buseo,jiyeok) VALUES (8003,'ȫ���','����',111,'����');
--weolgub ������ 7�ڸ��ε� 8�ڸ�, 
INSERT INTO sawon(sabun, sawon_name,weolgub,jiyeok) VALUES (8004,'ȫ�漮',12345678,'����');
INSERT INTO sawon(sabun, sawon_name,ubmu,buseo,jiyeok) VALUES (8005,'ȫ��ö','��������',303,'�Ǳ�');

--11�� ����
ALTER TABLE sawon DROP (jiyeok);

--12��
-- foreign Ű�� ����Ǿ��־ ������ �Ұ����ϴ�.
DELETE FROM buseo where buseo_name='�����ڿ���';

--13��
--��������� ����
--delete�� 1�� �����ϸ� ���� ���� �Է��ϸ� ��������� �״�� �ְ� 2�� �Է��� �Ǵµ�
--truncate�� 1�� �����ϸ� ���� ���� �Է��� �� 1�� �Էµȴ�.
TRUNCATE TABLE sawon;

CREATE USER 'canon';
IDENTIFIED BY 'kosmo';




 
