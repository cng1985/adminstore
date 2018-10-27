package com.tongna.adminstore.exams;

import com.haoxuer.discover.area.data.entity.Area;
import com.haoxuer.discover.area.data.enums.AreaType;
import com.haoxuer.discover.area.data.service.AreaService;
import com.haoxuer.discover.quartz.data.factory.ObjectFactory;
import com.haoxuer.lbs.qq.v1.builder.ServicesBuilder;
import com.haoxuer.lbs.qq.v1.domain.response.AreaItem;
import com.haoxuer.lbs.qq.v1.service.DistrictService;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.BeanFactory;

public class AreaApp {
  
  public static void main(String[] args) throws InterruptedException {
    china();
  }
  
  private static void d() throws InterruptedException {
    BeanFactory factory = ObjectFactory.get();
    AreaService areaService = factory.getBean(AreaService.class);
    DistrictService service = ServicesBuilder
            .newBuilder()
            .key("H4DBZ-WLVCU-YLEVF-4MIDF-MGB5H-TOFDR")
            .build()
            .getDistrictService();
    
    List<Filter> filers = new ArrayList<>();
    filers.add(Filter.eq("areaType", AreaType.country));
    List<Order> orders = new ArrayList<>();
    orders.add(Order.asc("code"));
    List<Area> areas= areaService.list(0, 90000, filers, orders);
    for (Area root : areas) {
//      if (root.getGovCode().length()!=6){
//        continue;
//      }
  
      List<AreaItem> areaItems = service.child(root.getGovCode()).getResult().get(0);
      Thread.sleep(1000);
      for (AreaItem areaItem : areaItems) {
        Area area = new Area();
        area.setParent(root);
        area.setName(areaItem.getName());
        area.setLat(areaItem.getLocation().getLat());
        area.setLng(areaItem.getLocation().getLng());
        area.setCode(areaItem.getId());
        area.setGovCode(areaItem.getId());
        area.setFullName(areaItem.getFullname());
        if (area.getName()==null){
          area.setName(area.getFullName());
        }
        area.setAreaType(AreaType.street);
       areaService.save(area);
      }
    }
  }
  
  private static void china() {
    BeanFactory factory = ObjectFactory.get();
    AreaService areaService = factory.getBean(AreaService.class);
    DistrictService service = ServicesBuilder
            .newBuilder()
            .key("H4DBZ-WLVCU-YLEVF-4MIDF-MGB5H-TOFDR")
            .build()
            .getDistrictService();
    List<AreaItem> areaItems = service.china();
    Area root = new Area();
    root.setId(1);
    for (AreaItem areaItem : areaItems) {
      Area area = new Area();
      area.setParent(root);
      area.setName(areaItem.getName());
      area.setLat(areaItem.getLocation().getLat());
      area.setLng(areaItem.getLocation().getLng());
      area.setCode(areaItem.getId());
      area.setGovCode(areaItem.getId());
      area.setFullName(areaItem.getFullname());
      area.setAreaType(AreaType.province);
      areaService.save(area);
    }
  }
}
