package com.haoxuer.adminstore.ad.api.domain.simple;


import java.io.Serializable;

import lombok.Data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by BigWorld on 2020年11月06日23:22:43.
 */

@Data
public class AdPositionSimple implements Serializable {

    private Long id;

    private String note;
    private String template;
    private Integer sortNum;
    private String name;
    private Integer width;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;
    private Integer height;
    private String key;


}