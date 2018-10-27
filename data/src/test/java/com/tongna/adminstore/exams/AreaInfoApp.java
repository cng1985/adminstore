package com.tongna.adminstore.exams;

import com.haoxuer.discover.area.data.entity.Area;
import com.haoxuer.discover.area.data.enums.AreaType;
import com.haoxuer.discover.area.data.service.AreaService;
import com.haoxuer.discover.quartz.data.factory.ObjectFactory;
import com.haoxuer.lbs.amap.domain.AreaInfo;
import com.haoxuer.lbs.amap.v3.service.DistrictService;
import com.haoxuer.lbs.amap.v3.service.impl.DistrictServiceImpl;
import com.haoxuer.lbs.baidu.v3.service.Config;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.BeanFactory;

public class AreaInfoApp {
  public static void main(String[] args) {
    citys();
//    code("110100");
//    code("120100");
//    code("310100");
//    code("500100");
//    code("500200");
  
  }
  public static void code(String code){
    BeanFactory factory = ObjectFactory.get();
    AreaService areaService = factory.getBean(AreaService.class);
   Area area= areaService.findByCode(code);
    Config config = new Config();
    config.setAk("c3ed521babcc6c3b1af2467064d216d7");
    DistrictService service = new DistrictServiceImpl(config);
    List<AreaInfo> infos = service.area(area.getGovCode());
    for (AreaInfo info : infos) {
      Area temp = new Area();
      temp.setParent(area);
      temp.setName(info.getName().replace("市",""));
      temp.setLat(Float.valueOf(info.getCenter().split(",")[1]));
      temp.setLng(Float.valueOf(info.getCenter().split(",")[0]));
      temp.setCode(info.getCode());
      temp.setGovCode(info.getCode());
      temp.setFullName(info.getName());
      temp.setAreaType(AreaType.country);
      System.out.println(temp);
      areaService.save(temp);
    }
  }
  
  private static void citys() {
    BeanFactory factory = ObjectFactory.get();
    AreaService areaService = factory.getBean(AreaService.class);
    List<Filter> filers = new ArrayList<>();
    filers.add(Filter.eq("parent.id", 1));
    List<Order> orders = new ArrayList<>();
    orders.add(Order.asc("code"));
    List<Area> areas= areaService.list(0, 2000, filers, orders);
    for (Area area : areas) {
      Config config = new Config();
      config.setAk("c3ed521babcc6c3b1af2467064d216d7");
      DistrictService service = new DistrictServiceImpl(config);
      List<AreaInfo> infos = service.area(area.getFullName());
      for (AreaInfo info : infos) {
        Area temp = new Area();
        temp.setParent(area);
        temp.setName(info.getName().replace("市",""));
        temp.setLat(Float.valueOf(info.getCenter().split(",")[1]));
        temp.setLng(Float.valueOf(info.getCenter().split(",")[0]));
        temp.setCode(info.getCode());
        temp.setGovCode(info.getCode());
        temp.setFullName(info.getName());
        temp.setAreaType(AreaType.city);
        areaService.save(temp);
      }
    }
  }
}
