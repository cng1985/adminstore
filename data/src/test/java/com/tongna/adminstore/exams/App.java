package com.tongna.adminstore.exams;

import com.haoxuer.discover.area.data.service.AreaService;
import com.haoxuer.discover.quartz.data.factory.ObjectFactory;
import org.springframework.beans.factory.BeanFactory;

public class App {
  public static void main(String[] args) {
    BeanFactory factory = ObjectFactory.get();
    AreaService areaService = factory.getBean(AreaService.class);
    System.out.println(areaService);
  }
}
