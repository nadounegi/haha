
CREATE TABLE GSALES_mst (
  GSID INT(10) NOT NULL AUTO_INCREMENT,
  GID INT(10) NOT NULL,
  SID INT(10) NOT NULL,
  SDATE DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  SNUM INT(11) NOT NULL,
  PRIMARY KEY (GSID),
  FOREIGN KEY (GID) REFERENCES GOODS_mst(GID),
  FOREIGN KEY (SID) REFERENCES salesman(SID)
) AUTO_INCREMENT=1;

--シークエンスを作成
ALTER TABLE GSALES_mst MODIFY COLUMN GSID INT UNSIGNED NOT NULL AUTO_INCREMENT,
ADD CONSTRAINT min_GSID CHECK (GSID>=0),
ADD CONSTRAINT max_GSID CHECK (GSID<=100);
--2、とりがーを作って、GSIDの値を自動採番	
Create Trigger GSALES_trigger
Before Insert on GSALES_mst
For each row
SET NEW.GSID = (SELECT nextval FROM GSALES_seq);
	
commit;