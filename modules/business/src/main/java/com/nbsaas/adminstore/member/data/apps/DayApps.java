package com.nbsaas.adminstore.member.data.apps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DayApps {
  
  public static void main(String[] args) {
    Calendar calendar=Calendar.getInstance();
    calendar.set(Calendar.MONTH,0);
    calendar.set(Calendar.DAY_OF_MONTH,1);
  
    System.out.println(calendar.getTime().toLocaleString());
    for (int i = 0; i < 12*2; i++) {
      
      List<Day> days = dayss(calendar.getTime());
      printWeeks(days);
      calendar.add(Calendar.MONTH,1);
    }
   
  }
  
  private static List<String> days(Date date) {
    SimpleDateFormat format=new SimpleDateFormat("MM-dd");
    List<String> days=new ArrayList<>();
    Calendar calendar = getFirstCalendar(date);
    Calendar endcalendar = getEndtCalendar(date);
    System.out.println("start:"+calendar.getTime().toLocaleString());
    System.out.println("end:"+endcalendar.getTime().toLocaleString());
    while (calendar.before(endcalendar)){
      days.add(format.format(calendar.getTime()));
      calendar.add(Calendar.DAY_OF_MONTH,1);
    }
    return days;
  }
  private static List<Day> dayss(Date date) {
    SimpleDateFormat format=new SimpleDateFormat("yyy-MM-dd");
    SimpleDateFormat simpleformat=new SimpleDateFormat("MM-dd");
  
    List<Day> days=new ArrayList<>();
    Calendar calendar = getFirstCalendar(date);
    Calendar endcalendar = getEndtCalendar(date);
    System.out.println("start:"+calendar.getTime().toLocaleString());
    System.out.println("end:"+endcalendar.getTime().toLocaleString());
    while (calendar.before(endcalendar)){
      Day day=new Day();
      day.setDay(format.format(calendar.getTime()));
      day.setSimpleDay(simpleformat.format(calendar.getTime()));
      days.add(day);
      calendar.add(Calendar.DAY_OF_MONTH,1);
    }
    return days;
  }
  private static void printWeek(List<String> days) {
    System.out.println("星期一  星期二  星期三  星期四   星期五    星期六   星期天 ");
    int i=0;
    System.out.print(" ");
    for (String s : days) {
      System.out.print(s+"   ");
      i++;
      if (i%7==0){
        System.out.println();
        System.out.print(" ");
      }
    }
  }
  private static void printWeeks(List<Day> days) {
    System.out.println("星期一  星期二  星期三  星期四   星期五    星期六   星期天 ");
    int i=0;
    System.out.print(" ");
    for (Day s : days) {
      System.out.print(s.getSimpleDay()+"   ");
      i++;
      if (i%7==0){
        System.out.println();
        System.out.print(" ");
      }
    }
  }
  private static Calendar getFirstCalendar(Date date) {
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY,0);
    calendar.set(Calendar.MINUTE,0);
    calendar.set(Calendar.SECOND,1);
    calendar.set(Calendar.DAY_OF_MONTH,1);
    int day=calendar.get(Calendar.DAY_OF_WEEK);
    while (day!=Calendar.MONDAY){
      calendar.add(Calendar.DAY_OF_MONTH,-1);
      day=calendar.get(Calendar.DAY_OF_WEEK);
    }
    return calendar;
  }
  private static Calendar getEndtCalendar(Date date) {
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.DAY_OF_MONTH,1);
    calendar.set(Calendar.HOUR_OF_DAY,23);
    calendar.set(Calendar.MINUTE,59);
    calendar.set(Calendar.SECOND,59);
    calendar.add(Calendar.MONTH,1);
    calendar.add(Calendar.DAY_OF_MONTH,-1);
    int day=calendar.get(Calendar.DAY_OF_WEEK);
    while (day!=Calendar.SUNDAY){
      calendar.add(Calendar.DAY_OF_MONTH,1);
      day=calendar.get(Calendar.DAY_OF_WEEK);
    }
    return calendar;
  }
}
