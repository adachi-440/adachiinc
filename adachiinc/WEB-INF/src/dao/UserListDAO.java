package dao;

import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class UserListDAO extends DAO{

  public List<User> userSearch()throws Exception{
    List<User> list=new ArrayList<>();

    Connection con=getConnection();

    PreparedStatement st=con.prepareStatement(
    "select * from user ");

    ResultSet rs=st.executeQuery();

    while(rs.next()){
      User u =new User();

      u.setId(rs.getInt("id"));
      u.setLogin(rs.getString("login"));
      u.setName(rs.getString("name"));

      list.add(u);
    }
    st.close();
    con.close();

    return list;
  }


  }
