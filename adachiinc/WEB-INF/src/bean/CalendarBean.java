package bean;

import java.util.Calendar;

public class CalendarBean implements java.io.Serializable{

  private int year;
  private int month;
  private int week;
  private int day;
  private int startweek;
  private int lastmonthday;
  private int viewday[];
  private int lastdaycount;
  private int curdaycount;

  public int getYear(){
    return year;
  }

  public int getMonth(){
    return month;
  }

  public int getWeek(){
    return week;
  }

  public int getDay(){
    return day;
  }

  public int getStartweek(){
    return startweek;
  }


  public int getLastmonthday(){
    return lastmonthday;
  }

  public int getLastdaycount(){
    return lastdaycount;
  }

  public int[] getViewday(){
    return viewday;
  }

  public int getCurdaycount(){
    return curdaycount;
  }

  public void setYear(int year){
    this.year = year;
  }

  public void setMonth(int month){
    this.month = month;
  }

  public void setWeek(int week){
    this.week = week;
  }

  public void setDay(int day){
    this.day = day;
  }

  public void setStartweek(int startweek){
    this.startweek = startweek;
  }

  public void setLastmonthday(int lastmonthday){
    this.lastmonthday = lastmonthday;
  }

  public void setLastdaycount(int lastdaycount){
    this.lastdaycount = lastdaycount;
  }

  public void setViewday(int[] viewday){
    this.viewday = viewday;
  }
  public void setCurdaycount(int curdaycount){
    this.curdaycount = curdaycount;
  }
}
