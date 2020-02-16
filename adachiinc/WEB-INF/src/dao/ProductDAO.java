package dao;


import bean.Product;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO extends DAO{
  public int insert(Product p) throws Exception{

    Connection con = getConnection();
    PreparedStatement st = con.prepareStatement("insert into product values(null, ?, ?, ?, ?) ");
    st.setString(1, p.getName());
    st.setInt(2, p.getPrice());
    st.setInt(3, p.getQuantity());
    st.setString(4, p.getSeller());

    int line = st.executeUpdate();
    st.close();
    con.close();

    return line;
  }

  public List<Product> search(String keyword) throws Exception{
    List<Product> lineup=new ArrayList<>();

    Connection con = getConnection();
    PreparedStatement st = con.prepareStatement("select * from product where name like ?");
    st.setString(1, "%"+keyword+"%");

    ResultSet rs = st.executeQuery();

    while(rs.next()){
      Product p = new Product();
      p.setId(rs.getInt("id"));
      p.setName(rs.getString("name"));
      p.setPrice(rs.getInt("price"));
      p.setQuantity(rs.getInt("quantity"));
      p.setSeller(rs.getString("seller"));
      lineup.add(p);

    }
    st.close();
    con.close();

    return lineup;
  }
}
