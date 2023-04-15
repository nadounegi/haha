package lyons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.db.DbClose;
import lyons.db.DbConn;
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
/*
 * テーブルGOODS_mstに商品情報の変更
 */
   
    public boolean updateGoods(int key,Goods goods)
    {
      boolean bool = false;
      conn = DbConn.getconn();
            switch (key)
            {
              case 1: 
                  String sqlName = "update GOODS_mst set GNAME=? where GID=?";

                  try{
                    pstmt = conn.prepareStatement(sqlName);
                    pstmt.setString(1,goods.getGname());
                    pstmt.setInt(2,goods.getGid());

                    int rs = pstmt.executeUpdate();
                    if(rs > 0){
                      bool = true;
                    }
                  }catch (SQLException e){
                    e.printStackTrace();
                  }finally{
                        DbClose.addClose(pstmt,conn);
                  }
                    break;
              case 2:
              String sqlPrice = "update GOODS_mst set GPRICE=? where GID=?";

              try{
                pstmt = conn.prepareStatement(sqlPrice);
                pstmt.setDouble(1,goods.getGprice());
                pstmt.setInt(2,goods.getGid());

                int rs = pstmt.executeUpdate();
                if(rs > 0){
                  bool = true;
                }
              }catch (SQLException e){
                e.printStackTrace();
              }finally{
                    DbClose.addClose(pstmt,conn);
              }
                break;
              case 3:
                String sqlNum = "update GOODS_mst set GNUM=? where GID=?";
  
                try{
                  pstmt = conn.prepareStatement(sqlNum);
                  pstmt.setInt(1,goods.getGnum());
                  pstmt.setInt(2,goods.getGid());
  
                  int rs = pstmt.executeUpdate();
                  if(rs > 0){
                    bool = true;
                  }
                }catch (SQLException e){
                  e.printStackTrace();
                }finally{
                      DbClose.addClose(pstmt,conn);
                }
                  break;
              default:
                  break;
            }
            return bool;
    }
    
}
