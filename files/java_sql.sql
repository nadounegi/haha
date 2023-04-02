select * from gsales;
select * from goods;
select * from salesman;

select GNAME,GPRICE,GNUM,allSum

from goods,(select GID as salesid,sum(SNUM) as allSum
			from gsales
			where trunc(SDATE) = trunc(Sysdate)
			group by GID)
where GID = salesid;

select trunc(Sydate) from dual;
select trunc(Sydate) +1 from dual;
select Sydate from dual;

select SID, to_char(SDATE,'yyyy/mm/dd') from gsales;
		