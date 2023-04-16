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
import lyons.tools.ScannerChoice;

/*
 * テーブルGOODS_mst操作
 */
public final class GoodsDao 
{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public boolean addGoods(Goods goods){//商品の添加
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
   
    public boolean updateGoods(int key,Goods goods)//商品情報の変更
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
            public boolean deleteGoods(int GID){//番号によって、商品を削除
              boolean bool = false;
              conn = DbConn.getconn();
              String sql = "Delete From GOODS_mst where GID=?";
                try{
                  pstmt = conn.prepareStatement(sql);
                  pstmt.setInt(1, GID);
                  int rs = pstmt.executeUpdate();
                  if (rs > 0){
                    bool = true;
                  }
                }catch(SQLException e){
                  e.printStackTrace();
                }finally{
                      DbClose.addClose(pstmt, conn);
                }
              return bool;
            }
            public ArrayList<Goods> queryGoods(int key){//リストから商品情報の検索
              ArrayList<Goods>goodsList = new ArrayList<>();
              conn = DbConn.getconn();

              switch(key){
                case 1:
                  //key=1 商品数量 昇順検索
                  String sqlGnum = "select * from GOODS_mst order by GNUM asc";
                  try{
                    pstmt = conn.prepareStatement(sqlGnum);
                    rs = pstmt.executeQuery();
                    while(rs.next()){
                      int GID = rs.getInt("GID");
                      String GNAME = rs.getString(2);
                      double GPRICE = rs.getDouble(3);
                      int GNUM = rs.getInt(4);

                      Goods goods = new Goods(GID,GNAME,GPRICE,GNUM);
                      goodsList.add(goods);
                    }
                  }catch(SQLException e){
                    e.printStackTrace();
                  }finally{
                    DbClose.queryClose(pstmt, rs, conn);
                  }
                  break;
                case 2:
                  //key=2 商品金額 昇順金額
                  String sqlGprice = "select * from GOODS_mst order by GPRICE asc";//金額昇順
                  try{
                    pstmt = conn.prepareStatement(sqlGprice);
                    rs = pstmt.executeQuery();
                    while(rs.next()){//昇順した内容をリストに格納
                      int GID = rs.getInt("GID");
                      String GNAME = rs.getString(2);
                      double GPRICE = rs.getDouble(3);
                      int GNUM = rs.getInt(4);

                      Goods goods = new Goods(GID,GNAME,GPRICE,GNUM);
                      goodsList.add(goods);
                    }
                  }catch(SQLException e){
                    e.printStackTrace();
                  }finally{
                    DbClose.queryClose(pstmt, rs, conn);
                  }
                  break;
                case 3:
                //key=3 キーワード検索
                  String nameGet = ScannerChoice.
              }
            }

}
