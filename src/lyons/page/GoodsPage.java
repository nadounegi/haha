package lyons.page;

import java.util.ArrayList;

import lyons.dao.GoodsDao;
import lyons.entity.Goods;
import lyons.tools.ScannerChoice;
import lyons.tools.QueryPrint;
/*
 * 商品インタフェース
 */
public final class GoodsPage extends ScannerChoice {
  //商品添加インタフェース
  public static void addGoodsPage(){
    System.out.println("\n添加したい商品名を入力してください");
    String goodsName = ScannerInfoString();

    System.out.println("\n商品金額を入力してください");
    double goodsPrice = ScannerInfo();

    System.out.println("\n商品数量を入力してください");
    int goodsNumber = ScannerNum();

    Goods goods = new Goods(goodsName, goodsPrice, goodsNumber);
    boolean bool = new GoodsDao().addGoods(goods);

    if(bool){
      System.out.println("\n\t!商品がデータベースに追加できた！");
    }else{
      System.out.println("商品が添加出来なかった");
    }
    changedInfoNext("addGoodsPage");
  }
  //商品情報変更インタフェース
  public static void updateGoodsPage(){
    System.out.println("変更したい商品名を入力してください");

    
  }
}
