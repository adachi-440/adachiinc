package bean;

public class Product implements java.io.Serializable{

  private int id;
  private String name;
  private int price;
  private int quantity;
  private String seller;

  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public int getPrice(){
    return price;
  }
  public int getQuantity(){
    return quantity;
  }
  public String getSeller(){
    return seller;
  }

  public void setId(int id){
    this.id = id;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setPrice(int price){
    this.price = price;
  }
  public void setQuantity(int quantity){
    this.quantity = quantity;
  }
  public void setSeller(String seller){
    this.seller = seller;
  }

}
