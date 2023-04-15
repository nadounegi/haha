package lyons.entity;

public class Goods {
  private int GID;
  private String GNAME;
  private double GPRICE;
  private int GNUM;

  /*
   * 商品情報添加
   */
  public Goods(String GNAME,double GPRICE,int GNUM){
    this.GNAME = GNAME;
    this.GPRICE = GPRICE;
    this.GNUM = GNUM;
  }
  /*
   * 商品情報を展示
   */
  public Goods(int GID,String GNAME,double GPRICE,int GNUM){
    this.GID = GID;
    this.GNAME = GNAME;
    this.GPRICE = GPRICE;
    this.GNUM = GNUM;
  }
  /*
   * 商品番号によって、商品情報を変更
   */
  public Goods(int GID,int GNUM){
    this.GID = GID;
    this.GNUM = GNUM;
  }
  public Goods(int GID,double GPRICE){
    this.GID = GID;
    this.GPRICE = GPRICE;
  }
  public Goods(int GID, String GNAME){
    this.GID = GID;
    this.GNAME = GNAME;
  }

  //共有-get,set方法
    public int getGid(){
      return GID;
    }
    public void setGid(int GID){
      this.GID = GID;
    }
    public String getGname(){
      return GNAME;
    }
    public void setGname(String GNAME){
      this.GNAME = GNAME;
    }
    public double getGprice(){
      return GPRICE;
    }
    public void setGprice(Double GPRICE){
      this.GPRICE = GPRICE;
    }
    
}
