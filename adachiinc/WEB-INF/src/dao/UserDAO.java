package dao;

import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO extends DAO{
  public User search(String login, String password)throws Exception{
    Connection con = getConnection();
    User user = null;

    PreparedStatement st = con.prepareStatement(
    "select * from user where login=? and password=?");
    st.setString(1,login);
    st.setString(2,password);
    ResultSet rs = st.executeQuery();

    while(rs.next()){
      user = new User();
      user.setId(rs.getInt("id"));
      user.setLogin(rs.getString("login"));
      user.setPassword(rs.getString("password"));
      user.setName(rs.getString("name"));
    }

    st.close();
    con.close();

  return user;
  }

  public int insert(User user) throws Exception{
    Connection con = getConnection();
    con.setAutoCommit(false);
    PreparedStatement st = con.prepareStatement(
    "insert into user values(null,?,?,?)");

    st.setString(1,user.getLogin());
    st.setString(2,user.getPassword());
    st.setString(3,user.getName());
    st.executeUpdate();

    st = con.prepareStatement(
    "select * from user where login=?");
    st.setString(1,user.getLogin());
    ResultSet rs = st.executeQuery();
    int checker=0;
    while(rs.next()){
      checker++;
    }
    if(checker == 1){
      con.commit();
    }else{
      con.rollback();
    }
    con.setAutoCommit(true);
    st.close();
    con.close();

    return checker;
  }
}
