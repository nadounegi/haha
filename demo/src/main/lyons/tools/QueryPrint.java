package lyons.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.dao.GoodsDao;
import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Goods;
import lyons.entity.SalesMan;

public final class QueryPrint {
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

/*
 * 曖昧検索して、検索結果を表示
 * 戻り値　GID、もし戻り値は-1になったら、検索異常です
 */
  public static int query(String oper){
    int GID = -1;
    String shopping = ScannerChoice.ScannerInfoString();//キーボードから商品名をゲット
    ArrayList<Goods>goodsList = new QueryPrint().queryGoodsKey(-1,shopping); 
      if(goodsList == null || goodsList.size() <= 0){
        System.err.println("\tこの商品はありません");

        ScannerChoice.changedInfoNext(oper);
      }else{//見つけた商品を変更
        Goods goods = goodsList.get(0);
        
        System.out.println("\t\t\t\t\t商品列表\n\n");
        System.out.println("\t商品番号\t\t商品名\t\t商品金額\t\t商品数量\t\t備考\n");
        System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
        if(goods.getGnum()==0){
          System.out.println("\t\tこの商品も売り切れました");
        }else if(goods.getGnum()<10){
          System.out.println("この商品は10点に満たない");
        }else
            {
              System.out.println("\t\t-");
            }
        GID = goods.getGid();
      }
    return GID;
  }
  //@return int 当商品件数有且只有一件时返回商品gid号，商品已售空时返回 -1. >1件时返回-2 . 查无此商品时返回-3
  public static int querySettlement()
  {
      int GID = -1;
      ArrayList<Goods>goodsSettlement = new GoodsDao().queryGoods(3);
    if(goodsSettlement == null || goodsSettlement.size() <= 0){
      System.err.println("\tこの商品はありません\n");
      GID = -3;
    }else{
      System.out.println("\t\t\t\t商品列表\n\n");
      System.out.println("\t商品番号\t\t商品名\t\t商品金額\t\t商品数量\t\t備考\n");
      for(int i = 0;i <goodsSettlement.size();i++){
        Goods goods = goodsSettlement.get(i);
        if(goods.getGnum() > 0){
          System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());

          if(goods.getGnum()==0){
            System.out.println("\t\tこの商品も売り切れ");
          }else if(goods.getGnum() < 10){
            System.out.println("\t\tこの商品が十件しかありません");
          }else{
            System.out.println("\t\t-");
          }
          if(goodsSettlement.size()==1){
            GID = goods.getGid();
          }else{
            GID = -2;
          }
        }
      }
    }
    return GID;
  }
  /*
   * 商品番号と商品名によって、商品情報を検索
   */
  public ArrayList<Goods>queryGoodsKey(int GID,String GNAME){
    ArrayList<Goods>goodsList = new ArrayList<Goods>();
    conn = DbConn.getconn();

    String sql = "select * from GOODS_mst where GID=? or GNAME=?";
      try{
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,GID);
        pstmt.setString(2, GNAME);
        rs = pstmt.executeQuery();
        while(rs.next()){
          int gid = rs.getInt("GID");
          String gname = rs.getString(2);
          double gprice = rs.getDouble(3);
          int gnum = rs.getInt(4);

          Goods goods = new Goods(gname, gprice, gnum);
          goodsList.add(goods);
        }
      }catch(SQLException e){
        e.printStackTrace();
      }finally{
        DbClose.queryClose(pstmt, rs, conn);
      }
      return goodsList;
  }
  /*
   * 販売員名前によって、販売員情報検索
   */
  public ArrayList<SalesMan> querySaleMan(String SNAME){
    ArrayList<SalesMan>SalesManList = new ArrayList<SalesMan>();
    conn = DbConn.getconn();
    String sql = "select * from Salesman_mst where SNAME=?";
      try{
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, SNAME);
        rs = pstmt.executeQuery();
        while(rs.next()){
          int SID = rs.getInt(SID);
          String salesmanName = rs.getString(2);
          String SPASSWORD = rs.getString(3);

          SalesMan salesMan = new SalesMan(SID,SNAME,SPASSWORD);
          SalesManList.add(salesMan);
        }
      }catch(SQLException e){
        e.printStackTrace();
      }finally{
        DbClose.queryClose(pstmt, rs, conn);
      }
      return SalesManList;
  }
}
