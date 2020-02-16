package bean;

public class User implements java.io.Serializable {

  private int id;
  private String login;
  private String password;
  private String name;

  public int getId(){
    return id;
  }

  public String getLogin(){
    return login;
  }

  public String getPassword(){
    return password;
  }

  public String getName(){
    return name;
  }

  public void setLogin(String login){
    this.login=login;
  }

  public void setId(int id){
    this.id=id;
  }

  public void setPassword(String password){
    this.password=password;
  }

  public void setName(String name){
    this.name = name;
  }
}
