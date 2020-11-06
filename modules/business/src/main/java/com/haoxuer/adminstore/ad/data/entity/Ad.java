package com.haoxuer.adminstore.ad.data.entity;

import com.haoxuer.adminstore.ad.data.enums.AdType;
import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.entity.SortEntity;
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
  @FormFieldAnnotation(title = "标题", sortNum = "2", grid = true, col = ColType.col_2)
  private String title;

  /**
   * 类型
   */
  @FormFieldAnnotation(title = "广告类型", sortNum = "2", grid = true, col = ColType.col_2)
  private AdType type;

  /**
   * 路径
   */
  private String path;

  /**
   * 起始日期
   */
  @FormFieldAnnotation(title = "广告开始时间", sortNum = "2", grid = true, col = ColType.col_2)
  private Date beginDate;

  /**
   * 结束日期
   */
  @FormFieldAnnotation(title = "广告结束时间", sortNum = "2", grid = true, col = ColType.col_2)
  private Date endDate;

  /**
   * 链接地址
   */
  private String url;


  /**
   * 分类
   */
  private Integer catalog;

  /**
   * 广告位
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private AdPosition adPosition;

  @FormFieldAnnotation(title = "内容", sortNum = "2", grid = true, col = ColType.col_2)
  private String note;

  private Long bussId;

}