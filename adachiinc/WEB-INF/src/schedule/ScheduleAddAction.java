package schedule;

import tool.Action;
import bean.User;
import bean.Schedule;
import dao.ScheduleDAO;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;

public class ScheduleAddAction extends Action{
  @SuppressWarnings("unchecked")
    public String execute(
      HttpServletRequest request,HttpServletResponse response
    )throws Exception{
      PrintWriter out = response.getWriter();
      int line=0;
      int num=0;
      String message ="";

      String smin = request.getParameter("smin");
      int smin_num = Integer.parseInt(smin);
      String shour = request.getParameter("shour");
      String starttime = null;

      Schedule sc = new Schedule();
      if(smin_num<10){
        starttime = shour + ":" + "0" + smin;

      }
      else{
        starttime = shour + ":" + smin;
        sc.setStarttime(starttime);
      }


      String emin = request.getParameter("emin");
      int emin_num = Integer.parseInt(emin);
      String ehour = request.getParameter("ehour");
      String endtime = null;
      if(emin_num<10){
        endtime = ehour + ":" + "0" + smin;

      }
      else{
        endtime = ehour + ":" + emin;

      }


      String plan = request.getParameter("plan");
      if(plan==null || plan.length()==0){
        message="予定を適切に入力してください";
        request.setAttribute("message",message);
        return "schedulein-error.jsp";
      }
      String memo = request.getParameter("memo");

      int id = Integer.parseInt(request.getParameter("ID"));

      
      sc.setStarttime(starttime);
      sc.setEndtime(endtime);
      sc.setPlan(plan);
      sc.setMemo(memo);
      sc.setId(id);

      ScheduleDAO dao = new ScheduleDAO();
      num = dao.update(sc);

      return "../calendar/Calendar.action";
    }
  }
