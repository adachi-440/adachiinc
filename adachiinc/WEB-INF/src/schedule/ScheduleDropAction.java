package schedule;

import tool.Action;
import bean.User;
import bean.Schedule;
import java.util.List;
import dao.ScheduleDAO;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;

public class ScheduleDropAction extends Action{
    @SuppressWarnings("unchecked")
    public String execute(
      HttpServletRequest request,HttpServletResponse response
    )throws Exception{

    int log = 0;
    int id = Integer.parseInt(request.getParameter("ID"));


    HttpSession session = request.getSession();
    List<Schedule> list=(List<Schedule>)session.getAttribute("list");
    for(Schedule sc : list){
      if(sc.getId()==id){
      ScheduleDAO dao = new ScheduleDAO();
      log = dao.drop(id);
    }
    }


    return "../calendar/Calendar.action";
  }
}
