package dao;

import bean.Schedule;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScheduleDAO extends DAO{
  public int insert(Schedule sc)throws Exception{

    Connection con  = getConnection();
    con.setAutoCommit(false);
    PreparedStatement st = con.prepareStatement(
    "insert into schedule values(null,?,?,?,?,?,?,?,?,?)");
    st.setString(1,sc.getLogin());
    st.setInt(2,sc.getYear());
    st.setInt(3,sc.getMonth());
    st.setInt(4,sc.getDay());
    st.setString(5,sc.getStarttime());
    st.setString(6,sc.getEndtime());
    st.setString(7,sc.getPlan());
    st.setString(8,sc.getMemo());
    st.setString(9,sc.getName());
    int line = st.executeUpdate();

    st = con.prepareStatement(
    "select * from user where login=?");
    st.setString(1,sc.getLogin());
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

  public List<Schedule> search(String login)throws Exception{
    Connection con  = getConnection();
    List<Schedule> list = new ArrayList<>();
    PreparedStatement st = con.prepareStatement(
    "select * from schedule ");
    ResultSet rs = st.executeQuery();

    while(rs.next()){
      Schedule sc = new Schedule();
      sc.setId(rs.getInt("id"));
      sc.setLogin(rs.getString("login"));
      sc.setYear(rs.getInt("year"));
      sc.setMonth(rs.getInt("month"));
      sc.setDay(rs.getInt("day"));
      sc.setStarttime(rs.getString("starttime"));
      sc.setEndtime(rs.getString("endtime"));
      sc.setPlan(rs.getString("plan"));
      sc.setMemo(rs.getString("memo"));
      sc.setName(rs.getString("name"));
      list.add(sc);
    }

    st.close();
    con.close();

    return list;
  }

  public int drop(int id) throws Exception{
    Connection con = getConnection();
    PreparedStatement st = con.prepareStatement("delete from schedule where id=?");
    st.setInt(1, id);
    int log = st.executeUpdate();

    st.close();
    con.close();
    return log;
  }
  public int update(Schedule sc) throws Exception{
    Connection con = getConnection();
    PreparedStatement st = con.prepareStatement("update schedule set starttime=?, endtime=?, plan=?, memo=? where id=?");


    st.setString(1,sc.getStarttime());
    st.setString(2,sc.getEndtime());
    st.setString(3,sc.getPlan());
    st.setString(4,sc.getMemo());
    st.setInt(5,sc.getId());
    int num = st.executeUpdate();

    st.close();
    con.close();
    return num;

  }
}
