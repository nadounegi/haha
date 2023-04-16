package lyons.tools;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthToggleButtonUI;

import lyons.page.GoodsPage;
import lyons.page.MainPage;
import lyons.page.SalesManPage;
/*
 * 操作が完成できると、次のステップへ
 * インタフェース選択
 */

public class ScannerChoice {
  //キーボードから商品金額をゲット,小数点以下２桁
  public double ScannerInfo(){
    double num = 0.00;
    do{
      Scanner sc = new Scanner(System.in);
      System.out.print("小数点以下2桁、入力してください:");
      String info = sc.next();

      String regex ="(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//小数点以下2桁を保留
      if(info.matches(regex)){
        num = Double.parseDouble(info);
      }else{
        System.err.println("入力が違い");
        continue;
      }
      break;
    }while(true);
    return num;
  }
  //キーボードから商品数量をゲット
  public static int ScannerNum(){
    int num = 0;
    String regex = "([1-9])|([1-9][0-9]+)";
    do{
      Scanner sc = new Scanner(System.in);
      System.out.print("入力してください");
      String nums = sc.next();

      if (nums.matches(regex)){
        num = Integer.parseInt(nums);
      }else{
        System.err.println("入力が違い");
        continue;
      }
    break;
    }while(true);
  return num;
  }
  public static String ScannerInfoString(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("入力してください");
    return scanner.next();
  }
  /*
   * 商品情報添加、次のステップ
   * 商品情報変更、次のステップ
   * 商品情報削除、次のステップ
   */
    public static void changedInfoNext(String oper){
      do{
        System.out.println("現在の操作を続行するかどうか(Y/N)");
        String choice = ScannerChoice.ScannerInfoString();
        //equalsは値を比較してる、==は場所を比較してる
        if("y".equals(choice) ||"Y".equals(choice)){
          //if-else 選んだ操作にジャンプ
          if("updateGoodsPage".equals(oper)){
            GoodsPage.updateGoodsPage();
          }else if("deleteGoodsPage".equals(oper)){
            GoodsPage.deleteGoodsPage();
          }else if("addGoodsPage".equals(oper)){
            GoodsPage.addGoodsPage();
          }
        }else if("N".equals(choice)||"n".equals(choice)){
          MainPage.MaintenancePage();
        }
        System.out.println("\n入力間違い！もう一回入力してください");
      }while(true);
    }

    /*
     * 販売員添加、次のステップ
     * 販売員変更、次のステップ
     * 販売ん検索、次のステップ
     */
    public static void choiceSalesManNext(String oper){
      do{
        System.out.println("現在の操作を続行するかどうか(Y/N)");
        String choice = ScannerChoice.ScannerInfoString();

        if("y".equals(choice)||"Y".equals(choice)){
          SalesManPage.updateSalesManPage();
        }
      }
    }
  
  }
