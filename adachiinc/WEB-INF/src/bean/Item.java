package bean;

import bean.Product;

public class Item implements java.io.Serializable{

  //出品者
  private int id;
  private Product product;
  private String buyer;
  private String seller;
  private String name;
  private int price;
  private int quantity;

  public int getId(){
    return id;
  }
  public Product getProduct(){
    return product;
  }
  public String getBuyer(){
    return buyer;
  }
  public String getSeller(){
    return seller;
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

  public void setId(int id){
    this.id = id;
  }
  public void setProduct(Product product){
    this.product = product;
  }
  public void setBuyer(String buyer){
    this.buyer = buyer;
  }
  public void setSeller(String seller){
    this.seller = seller;
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


}
