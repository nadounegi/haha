--セールスマンテーブルを作成
Create Table salesman
(
	SID 		NUMBER(10) Primary key,
	SPASSWORD 	VARCHAR2(20) not null,
	SNAME		VARCHAR2(10) not null unique
);

--主キーの自動生成ため

--2、トリガーを作って、SIDの値を自動採番	