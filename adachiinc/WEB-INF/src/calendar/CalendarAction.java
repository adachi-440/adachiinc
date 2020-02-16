package calendar;

import tool.Action;
import bean.CalendarBean;
import bean.Schedule;
import schedule.ScheduleReadAction;
import java.util.Calendar;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CalendarAction extends Action{
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  )throws Exception{
    PrintWriter out = response.getWriter();

    Calendar calendar = Calendar.getInstance();
    CalendarBean bean = new CalendarBean();

    int year = calendar.get(Calendar.YEAR);
    if(request.getParameter("year")!=null){
    year = Integer.parseInt(request.getParameter("year")) ;
    }

    int month = calendar.get(Calendar.MONTH);
    if(request.getParameter("month")!=null){
    month = Integer.parseInt(request.getParameter("month")) -1;
    }



    int day = calendar.get(Calendar.DATE);
    int viewdate[] = new int[42];

    //今月の最終日
    calendar.set(year,month+1,0);
    int lastday= calendar.get(Calendar.DATE);

    //先月の最終日
    calendar.set(year,month,0);
    int lastmonthday = calendar.get(Calendar.DATE);

    calendar.set(year,month,1);
    //今月の最初の曜日
    int startweek = calendar.get(Calendar.DAY_OF_WEEK);
    //先月のうち表示される日付の数
    int lastdaycount = startweek -1;
    //今月の表示される日付の数
    int curdaycount = lastday+lastdaycount+1;

    //先月の日付
    for(int i=0;i<startweek-1;i++){
      viewdate[i]=lastmonthday -startweek +2 + i ;
    }
    //今月の日付
    int n = 1;//4           33
    for(int i=startweek-1;i<lastday+startweek-1;i++){
      viewdate[i]=n;
      n++;
    }
    //来月の日付
      int m =1;
    for(int i=lastday+startweek-1;i<42;i++){
      viewdate[i]=m;
      m++;
    }

    bean.setYear(year);
    bean.setMonth(month + 1);
    bean.setDay(day);
    bean.setLastmonthday(lastmonthday);
    bean.setStartweek(startweek);
    bean.setLastdaycount(lastdaycount);
    bean.setViewday(viewdate);
    bean.setCurdaycount(curdaycount);


    ScheduleReadAction sra = new ScheduleReadAction();
    List<Schedule> list = sra.getSchedule(request,response);



    request.setAttribute("calendar",bean);
    request.setAttribute("list",list);
    return "calendar.jsp";

  }
  }
