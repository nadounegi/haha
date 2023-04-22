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
Before Insert on GOODS_mst
For each row
SET NEW.GID = (SELECT nextval FROM goods_seq);
	
--truncate