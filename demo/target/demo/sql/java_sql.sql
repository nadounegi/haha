select * from GSALES_mst;
select * from GOODS_mst;
select * from Salesman_mst;

select GNAME,GPRICE,GNUM,allSum

from GOODS_mst,(select GID as salesid,sum(SNUM) as allSum
			from GSALES_mst
			where DATE(SDATE) = CURDATE()
			group by GID)
where GID = salesid;

select CURDATE();
select DATE_ADD(CURDATE(), INTERVAL 1 DAY);
SELECT SID, DATE_FORMAT(SDATE,'%Y/%m/%d') AS 'Sale Date' from GSALES_mst;
		