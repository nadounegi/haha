--商品情報のテーブルを作成
Create Table GOODS
{ 
	GID NUMBER(10) primary key,
	GNAME VARCHAR2(20) not null unique,
	GPRICE NUMBER(18,2) not null,
	GNUM NUMBER(11) not null
};
--GID主キーの自動生成ため
--1、商品情報テーブルを基に、シークエンスを作成
Create Sequence goods_seq --シークエンス名
	Start with   1
	Increment by 1
	Minvalue     1 
	Maxvalue     10000　--最大値
	Nocycle　--最大値が終了後、ループは続けない
	Cache 10　--効率向上のため、バッファリングは１０を設定

--2、とりがーを作って、GIDの値を自動採番
Create Trigger goods_trigger
	Before Insert on goods
	For each row
	begin
		Select goods_seq.nextval Into :new.GID From dual;
	End;
	
--truncate