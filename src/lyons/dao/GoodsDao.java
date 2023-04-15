package lyons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.db.DbClose;
import lyons.entity.Goods;

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
      conn = DbConn.getconn();
      String sql = "insert into GOODS_mst(GNAME,GPRICE,GNUM)values(?,?,?)";
        try{
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1,goods.getGname());
          pstmt.setDouble(2,goods.getGprice());
          pstmt.setInt(3,goods.getGnum());

          int rs = pstmt.executeUpdate();
          if(rs > 0){
            bool =true;
          }
        }catch(SQLException e){
          e.printStackTrace();
        }finally
                    {
                      DbClose.addClose(pstmt,conn);
                    }
      return bool;
    }
     
   
}
