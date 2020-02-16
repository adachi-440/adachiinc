package dao;
import bean.User;
import bean.Item;
import javax.servlet.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SellerDAO extends DAO{

public List<Item> sellerSearch(String seller)throws Exception{
  /*HttpSession session = request.getSession();
  User user = (User)session.getAttribute("user");
  String seller=user.getName();*/
  String name[] ={"竹内周登","足立智樹","加藤豪輝","奥隼"};
  Connection con = getConnection();
  List<Item> list1 =new ArrayList<>();
//自分が売って、誰かが買ったかを個別に取得する
  for(String buyer : name){
    PreparedStatement st =con.prepareStatement(
    "select * from cart where username like ? and buyer like ?");
    st.setString(1,seller);
    st.setString(2,buyer);
    ResultSet rs = st.executeQuery();
    while(rs.next()){
      Item item = new Item();
      item.setName(rs.getString("product_name"));
      item.setPrice(rs.getInt("product_price"));
      item.setBuyer(rs.getString("buyer"));
      item.setQuantity(rs.getInt("product_quantity"));
      list1.add(item);
    }
st.close();
  }

  con.close();

return list1;

}
}
