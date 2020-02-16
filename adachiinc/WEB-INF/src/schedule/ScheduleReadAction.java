package schedule;

import tool.Action;
import dao.ScheduleDAO;
import bean.Schedule;
import bean.User;
import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.ServletException;



public class ScheduleReadAction {
  public List<Schedule> getSchedule(
    HttpServletRequest request,HttpServletResponse response
    )throws Exception{
          List<Schedule> list=null;
      try{
          HttpSession session = request.getSession();
          User user = (User)session.getAttribute("user");
          String login =user.getLogin();
          ScheduleDAO dao = new ScheduleDAO();
          list = dao.search(login);
          session.setAttribute("list", list);
      }catch(Exception e){
        request.getRequestDispatcher("../login/login-error.jsp")
          .forward(request,response);
      }

          return list;
  }
}
