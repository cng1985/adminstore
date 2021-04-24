package com.haoxuer.adminstore.common.rest.convert;

import com.haoxuer.adminstore.common.api.domain.response.StoreConfigResponse;
import com.haoxuer.adminstore.common.data.entity.StoreConfig;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class StoreConfigResponseConvert implements Conver<StoreConfigResponse, StoreConfig> {
    @Override
    public StoreConfigResponse conver(StoreConfig source) {
        StoreConfigResponse result = new StoreConfigResponse();
        BeanDataUtils.copyProperties(source,result);



        return result;
    }
}
