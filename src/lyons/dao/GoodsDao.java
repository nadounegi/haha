package lyons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;

/*
 * テーブルGOODS_mst操作
 */
public final class GoodsDao 
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /*
     * テーブルGOODS_mstに商品を添加
     */
    public boolean addGoods(Goods goods){
      boolean bool = false;
      conn = DbConn.getconn()
    }

}
