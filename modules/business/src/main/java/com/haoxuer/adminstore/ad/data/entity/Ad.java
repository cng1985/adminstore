package com.haoxuer.adminstore.ad.data.entity;

import com.haoxuer.adminstore.ad.data.enums.AdType;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.annotations.InputType;
import com.haoxuer.discover.data.entity.SortEntity;
import com.haoxuer.imake.annotation.FiledConvert;
import com.haoxuer.imake.annotation.FiledName;
import com.haoxuer.imake.annotation.SearchItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity - 广告
 */
@Data
@Entity
@Table(name = "bs_basic_ad")
public class Ad extends SortEntity {

  /**
   * 标题
   */
  @SearchItem(label = "广告位",name = "title")
  @FormFieldAnnotation(title = "标题", sortNum = "10", grid = true, col = ColType.col_2,required = true)
  private String title;

  /**
   * 类型
   */
  private AdType type;

  /**
   * 路径
   */
  private String path;

  /**
   * 起始日期
   */
  @FormFieldAnnotation(title = "广告开始时间", sortNum = "20", grid = true, col = ColType.col_2,type = InputType.el_date_time_picker)
  private Date beginDate;

  /**
   * 结束日期
   */
  @FormFieldAnnotation(title = "广告结束时间", sortNum = "30", grid = true, col = ColType.col_2,type = InputType.el_date_time_picker)
  private Date endDate;

  /**
   * 链接地址
   */
  @FormFieldAnnotation(title = "链接地址", sortNum = "40", grid = true, col = ColType.col_2)
  private String url;


  /**
   * 分类
   */
  private Integer catalog;

  /**
   * 广告位
   */
  @SearchItem(label = "广告位",name = "adPosition",key = "adPosition",type = InputType.select,classType = "Long",operator = "eq")
  @FormFieldAnnotation(title = "广告位", sortNum = "50", grid = true, col = ColType.col_2,type = InputType.select,option = "adPosition")
  @FiledName
  @FiledConvert
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn()
  private AdPosition adPosition;

  @FormFieldAnnotation(title = "内容", sortNum = "60", grid = true, col = ColType.col_2)
  private String note;

  private Long bussId;

}