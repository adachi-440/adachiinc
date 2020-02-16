package schedule;

import tool.Action;
import bean.User;
import bean.Schedule;
import dao.ScheduleDAO;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;

public class ScheduleWriteAction extends Action{
    public String execute(
      HttpServletRequest request,HttpServletResponse response
    )throws Exception{
      PrintWriter out = response.getWriter();
        String message="";
        int line=0;

          HttpSession session = request.getSession();
          User user = (User)session.getAttribute("user");
          String login = user.getLogin();
          String name = user.getName();
          int year =  Integer.parseInt(request.getParameter("YEAR"));
          int month =  Integer.parseInt(request.getParameter("MONTH"));
          int day =  Integer.parseInt(request.getParameter("DAY"));

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


          sc.setLogin(login);
          sc.setYear(year);
          sc.setMonth(month);
          sc.setDay(day);
          sc.setStarttime(starttime);
          sc.setEndtime(endtime);
          sc.setPlan(plan);
          sc.setMemo(memo);
          sc.setName(name);

          ScheduleDAO dao = new ScheduleDAO();
          line =dao.insert(sc);
          if(line ==1){
            message="スケジュールを登録しました。";
            request.setAttribute("message",message);
            return "schedulein-out.jsp";
          }
          message=sc.getLogin()+line;
          request.setAttribute("message",message);
          return "schedulein-error.jsp";

      }
}
