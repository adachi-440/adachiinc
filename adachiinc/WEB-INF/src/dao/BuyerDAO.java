package dao;
import bean.User;
import bean.Item;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuyerDAO extends DAO{
  public List<Item> buyerSearch(String buyer)throws Exception{

  //  String buyer = user.getName();
    String name[] ={"竹内周登","足立智樹","加藤豪輝","奥隼"};
    List<Item> list2= new ArrayList<>();
    Connection con = getConnection();

      for(String seller : name){
        PreparedStatement st = con.prepareStatement(
        "select * from cart where username like ? and buyer like ?");
        st.setString(1,seller);
        st.setString(2,buyer);
        ResultSet rs = st.executeQuery();

        while(rs.next()){
          Item item = new Item();
            item.setName(rs.getString("product_name"));
            item.setPrice(rs.getInt("product_price"));
            item.setSeller(rs.getString("username"));
            item.setQuantity(rs.getInt("product_quantity"));
            list2.add(item);

        }
        st.close();
      }

      con.close();
      return list2;

    }
}
