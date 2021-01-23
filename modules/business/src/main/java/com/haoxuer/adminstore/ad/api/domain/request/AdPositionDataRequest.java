package com.haoxuer.adminstore.ad.api.domain.request;


import com.haoxuer.discover.user.api.domain.request.BaseRequest;
import lombok.Data;

import java.util.Date;

/**
 * Created by imake on 2020年11月06日23:22:43.
 */

@Data
public class AdPositionDataRequest extends BaseRequest {

    private Long id;

    private String note;

    private String template;

    private Integer sortNum;

    private String name;

    private Integer width;

    private Integer height;

    private String key;


}