package bean;

public class Schedule implements java.io.Serializable{
  private int id;
  private String login;
  private int year;
  private int month;
  private int day;
  private String starttime;
  private String endtime;
  private String plan;
  private String memo;
  private String name;

  public int getId(){
    return id;
  }
  public String getLogin(){
    return login;
  }
  public int getYear(){
    return year;
  }
  public int getMonth(){
    return month;
  }
  public int getDay(){
    return day;
  }
  public String getStarttime(){
    return starttime;
  }
  public String getEndtime(){
    return endtime;
  }
  public String getPlan(){
    return plan;
  }
  public String getMemo(){
    return memo;
  }
  public String getName(){
    return name;
  }

  public void setId(int id){
    this.id = id;
  }
  public void setLogin(String login){
    this.login = login;
  }
  public void setYear(int year){
    this.year = year;
  }
  public void setMonth(int month){
    this.month = month;
  }
  public void setDay(int day){
    this.day = day;
  }
  public void setStarttime(String starttime){
    this.starttime = starttime;
  }
  public void setEndtime(String endtime){
    this.endtime = endtime;
  }
  public void setPlan(String plan){
    this.plan = plan;
  }
  public void setMemo(String memo){
    this.memo = memo;
  }
  public void setName(String name){
    this.name = name;
  }
}
