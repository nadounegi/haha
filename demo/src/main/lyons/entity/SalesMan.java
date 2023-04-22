package lyons.entity;

public final class SalesMan {
  private int SID;
  private String SNAME;
  private String SPASSWORD;

  /*
   * ユーザー登録
   */
  public SalesMan(int SID,String SPASSWORD){
    this.SID = SID;
    this.SPASSWORD = SPASSWORD;
  }
  /*
   * ユーザー検索、ユーザーパスワード変更
   */
  public SalesMan(int SID,String SNAME,String SPASSWORD){
    this.SID = SID;
    this.SNAME = SNAME;
    this.SPASSWORD = SPASSWORD;
  }
  /*
   * ユーザー添加
   */
  public SalesMan(String NsName,String SPASSWORD){
    this.SNAME = NsName;
    this.SPASSWORD = SPASSWORD;
  }

  //共有get.set方法
    public int getSid(){
      return SID;
    }
    public void setSid(int id){
      SID = id;
    }
    public String getSName(){
      return SNAME;
    }
    public void SetSName(String name){
      SNAME = name;
    }
    public String getSPassWord(){
      return SPASSWORD;
    }
    public void setSPassWord(String password){
      SPASSWORD = password;
    }
}
