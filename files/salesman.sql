--セールスマンテーブルを作成
CREATE TABLE Salesman_mst
(
    SID int(10) NOT NULL AUTO_INCREMENT,
    SPASSWORD VARCHAR(20) not null,
    SNAME	VARCHAR(10) not null unique,
    PRIMARY KEY (SID)
) AUTO_INCREMENT=1;

ALTER TABLE Salesman_mst MODIFY COLUMN SID INT UNSIGNED NOT NULL AUTO_INCREMENT,
ADD CONSTRAINT min_SID CHECK (SID>=0),
ADD CONSTRAINT max_SID CHECK (SID<=100);

--2、トリガーを作って、SIDの値を自動採番	SID
Create Trigger Salesman_trigger
Before Insert on Salesman_mst
For each row
SET NEW.SID = (SELECT nextval FROM Salesman_seq);
	