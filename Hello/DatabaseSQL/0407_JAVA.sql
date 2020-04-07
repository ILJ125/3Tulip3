CREATE TABLE reg_tab( text varchar2(20) );

INSERT INTO reg_tab VALUES('TIGER');
INSERT INTO reg_tab VALUES('TIGGER');
INSERT INTO reg_tab VALUES('elephant');
INSERT INTO reg_tab VALUES('tiger');
INSERT INTO reg_tab VALUES('tiger2');
INSERT INTO reg_tab VALUES('tiger3');
INSERT INTO reg_tab VALUES('doggy');
INSERT INTO reg_tab VALUES('5doggy');
INSERT INTO reg_tab VALUES('DOG');
INSERT INTO reg_tab VALUES('DOG2');
INSERT INTO reg_tab VALUES('��');
INSERT INTO reg_tab VALUES('cat');
INSERT INTO reg_tab VALUES('catty');
INSERT INTO reg_tab VALUES('9catty');
INSERT INTO reg_tab VALUES('catwoman');
INSERT INTO reg_tab VALUES('�����');
INSERT INTO reg_tab VALUES('BAT');
INSERT INTO reg_tab VALUES('BATMAN');
INSERT INTO reg_tab VALUES('BATGIRL');
INSERT INTO reg_tab VALUES('0BATGIRL');
INSERT INTO reg_tab VALUES('����');

SELECT *
FROM reg_tab;

-- 1.  text �÷��� ���ڿ����� 't'�ν����ϴ� ������ �˻�
SELECT *
FROM reg_tab
WHERE text like 't%';

-- 2. text �÷��� ���ڿ����� 't'�� ������ ������ �˻�
SELECT *
FROM reg_tab
WHERE text like '%t';
-- 3. ù��° 't'�ν����Ͽ� 5��° 'r'�� �ִ� ������ �˻�
SELECT *
FROM reg_tab
WHERE text like 't___r%';
--���Խ� ǥ�� ĸó�� ����
-- 4. ���ڷ� ������ ������ �˻�
SELECT *
FROM reg_tab
WHERE regexp_like(text,'[0-9]$');
 

-- 5. ���ڷ� �����ϴ� ����Ÿ �˻�
SELECT *
FROM reg_tab
WHERE regexp_like(text,'^[0-9]');
-- 6. ���ڰ� �ƴ� ���ڷ� �����ϴ� ������ �˻�
SELECT *
FROM reg_tab
WHERE not regexp_like(text,'^[0-9]');
-- 7. �빮�ڷ� �����ϴ� ������ �˻�
SELECT *
FROM reg_tab
WHERE regexp_like(text,'^[A-Z]');
-- 8. �ҹ��� ���� ���ڷ� �����ϴ� ������ �˻�
SELECT *
FROM reg_tab
WHERE not regexp_like(text,'^[a-z]');
-- 9. �ѱ۷� �����ϴ� ������ �˻�
-- �ѱ۷� �����Ѵ� ������ [��-�R] ��� �ѱ� 
SELECT *
FROM reg_tab
WHERE regexp_like(text,'^[��-�R]');
 
-- 10. ������ �� 'gg'�� 'GG'�� ����ִ� ������ �˻�
SELECT *
FROM reg_tab
WHERE  text like '%gg%' or text like '%GG%';