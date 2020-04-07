CREATE TABLE sawon(
sabun number(6),
sawon_name char(10),
ubmu varchar2(20) DEFAULT '����',
weolgub number(7) ,
buseo number(3),
jiyeok char(20) NOT NULL,
CONSTRAINT pk_sabun PRIMARY KEY(sabun),
CONSTRAINT ck_ubmu CHECK (ubmu IN ('����','��������','����')),
CONSTRAINT fk_buseo FOREIGN KEY(buseo) 
REFERENCES buseo(buseo_no)
);
CREATE TABLE buseo(
buseo_no number(3),
buseo_name char(20),
CONSTRAINT pk_buseo_no PRIMARY KEY(buseo_no)
);

==========04/07 ���� =====================
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

--������ �Է�
INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','ȫ�浿', '031-333-3333' );

INSERT INTO gogek ( id, name, tel ) VALUES('babo1111','��浿', '031-111-1111' );

INSERT INTO gogek ( id, name, tel ) VALUES('babo2222','ȫ�浿', '031-222-2222' );

INSERT INTO gogek ( id, name, tel ) VALUES('babo9999','�ڱ浿', '031-333-3333' );
--���� id�� ��ģ��.
INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','�ͱ浿', '031-999-9999' );
--���� id ���� �ʹ� ũ��
INSERT INTO gogek ( id, name, tel ) VALUES('babo12345','�̱浿', '031-333-1234' );

INSERT INTO gogek ( id, name, tel ) VALUES('123','�ֱ浿', '031-999-9999' );

INSERT INTO gogek ( id, name ) VALUES('babo','���浿' );
--�ʼ� �Է� �� name�� null�̴�.
INSERT INTO gogek ( id, tel ) VALUES('babo1988','031-888-8888' );

 

 

INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00001','�̻۹���', 30, 1000, '�ΰ��̻��� �ݹ� �� �ȸ� �����Դϴ�' );

INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00002','�׳ɹ���', 20, 500, '�׳��̻��� ����� �����Դϴ�' );

INSERT INTO sangpum ( no, title, count )VALUES ('B00009','������', 20 );
--���� �Է��ϰڴٴ� �� ���� �����Ͱ� �� ����
INSERT INTO sangpum ( no, title, count,price ) VALUES ('Z0001','�����Ʈ', 3, 20000, '�̳� �����Ʈ�Դϴ�' );
--���� ��� �� ������� �� �Է����� �ʾ��� �� ���̺��� ������� ���� �Է� �޴µ�  ������ �������� �ʴ�
INSERT INTO sangpum VALUES ('Z00001','�����Ʈ2', 5, 20000, '�̳� ��� ��Ʈ�Դϴ�' );

INSERT INTO sangpum VALUES ('Z00001','�����Ʈ3','�̳� ��� ��Ʈ�Դϴ�', 5, 20000);

 

 

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1000, 'babo1234', 'A00001', 1, '2016/09/09' );

--���� babo1233�� ���� ���̵�
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1001, 'babo1233', 'Z00001', 1, '2016/09/09' );

--���� Babo1235 ���̵� ��� �빮�� �ҹ��� �����մϴ�.
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1002, 'Babo1234', 'A00002', 2, '2016/09/10' );

--���� B00001 ���� ����. 
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1003, 'babo1234', 'B00001', 1, '2016/09/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1004, 'babo', 'Z00001', 1, '2016/10/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1005, 'babo1234', 'B00009', 1, '2016/11/11' );

INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1006, 'babo1234', 'B00009', 1, '2016/12/12' );

--������ ���� �� �˻�
--gogek ��ü �˻�
SELECT *
FROM gogek;
--1.��ȭ��ȣ�� ���� ���� �������� ������ �˻��ϼ���
SELECT name
FROM gogek
WHERE tel is null;
--2.ȫ�� ���� ���� ������ ������ �˻��ϼ���
SELECT *
FROM gogek
WHERE name like 'ȫ%';
--3.babo2222 ������ �ڱ浿���� �����ϼ���
UPDATE gogek 
SET name='�ڱ浿'
WHERE id='babo2222';
--4.���̵� 123 ���� ���̵� babo123 ���� �����ϼ���
UPDATE gogek
SET id='babo123'
WHERE id='123';
--5.���浿���� ��ȭ��ȣ 02-555-5555�� �߰��ϼ���
UPDATE gogek
SET tel='02-555-5555'
WHERE name='���浿';
--��ǰ ���̺� �˻�
SELECT *
FROM sangpum;
--6.��ǰ��ȣ B00009 �� ���� 1200�� �׸��� ���̳� �ٽ��� ���Դϴ١���� ��ǰ������ �߰��ϼ���
UPDATE sangpum
SET price='1200',detail='�̳� �ٽ��� ���Դϴ�'
WHERE no='B00009';
--7.�̻۹��� ��ǰ�� 10���� �ȷȽ��ϴ�.
UPDATE sangpum
SET count = count-10
WHERE title='�̻۹���';
--8.Z00001 ��ǰ�� 3���� �� �԰� �Ǿ����ϴ�.
UPDATE sangpum
SET count = count +3
WHERE no ='Z00001';
--9.��ǰ ������ 1000���� �Ѵ� ��ǰ���� �˻��ϼ���
SELECT *
FROM sangpum
WHERE price > 1000;
--�ֹ� ���̺� �˻�
SELECT *
FROM jumun;
--10.11�� ���Ŀ� �ֹ��� ��ǰ ��ȣ�� �˻��ϼ���
SELECT *
FROM jumun
WHERE jumunil>='2016/11/01';

--11.babo ���� �ֹ��� ��ǰ�� A00002�� �����ϰ� ������ 2���� �����ϼ���
UPDATE jumun
SET sangpum='A00002',count=2
WHERE gogek='babo';
--12.babo1234 ���� 11���� �ֹ��� ��ǰ ��ȣ�� �˻��ϼ���
SELECT sangpum
FROM jumun
WHERE gogek='babo1234' and (to_char(jumunil,'mm')='11');
--13.B00009 ��ǰ�� �ֹ��� �� ���̵� �˻��ϼ���
SELECT gogek
FROM jumun
WHERE sangpum='B00009';








