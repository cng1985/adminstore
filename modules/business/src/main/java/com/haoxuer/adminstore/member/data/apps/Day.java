package com.haoxuer.adminstore.member.data.apps;

public class Day {
  
  private String day;
  
  private String simpleDay;
  
  public String getDay() {
    return day;
  }
  
  public void setDay(String day) {
    this.day = day;
  }
  
  public String getSimpleDay() {
    return simpleDay;
  }
  
  public void setSimpleDay(String simpleDay) {
    this.simpleDay = simpleDay;
  }
  
  @Override
  public String toString() {
    return "Day{" +
        "day='" + day + '\'' +
        ", simpleDay='" + simpleDay + '\'' +
        '}';
  }
}
