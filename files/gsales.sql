--セールステーブル
Create Table gsales
--外部キー制約があり
(
	GSID 　NUMBER(10) primary key,
	GID   NUMBER(10)　References goods(GID) not null,
	SID   NUMBER(10) References salesman(SID) not null,
	SDATE DATE Default Sysdate not null, --システム時間とシンクロナスする
	SNUM　　NUMBER(11) not null
);

--シークエンスを作成
Create Sequence gsales_seq
	Start with     1
	Increment by   1
	Minvalue       1
	Maxvalue       10000
	Nocyle
	Cache          10
--2、とりがーを作って、GSIDの値を自動採番	
Create Trigger gsales_trigger
	Before Insert On gsales
	For each row
	Begin
		Select gsales_seq.nextval into :new.GSID From Dual;
	End
commit;