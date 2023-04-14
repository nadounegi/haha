--商品情報のテーブルを作成
CREATE TABLE GOODS_mst (
  GID int(10) NOT NULL AUTO_INCREMENT,
  GNAME varchar(20) NOT NULL UNIQUE,
  GPRICE decimal(18,2) NOT NULL,
  GNUM int(11) NOT NULL,
  PRIMARY KEY (GID)
)AUTO_INCREMENT=1;


ALTER TABLE GOODS_mst MODIFY COLUMN GID INT UNSIGNED NOT NULL AUTO_INCREMENT,
ADD CONSTRAINT min_GID CHECK (GID>=0),
ADD CONSTRAINT max_GID CHECK (GID<=100);


--2、とりがーを作って、GIDの値を自動採番
Create Trigger goods_trigger
	Before Insert on goods
	For each row
	begin
		Select goods_seq.nextval Into :new.GID From dual;
	End; 
	
--truncate