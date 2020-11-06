package com.haoxuer.adminstore.ad.rest.conver;

import com.haoxuer.adminstore.ad.api.domain.response.AdPositionResponse;
import com.haoxuer.adminstore.ad.data.entity.AdPosition;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class AdPositionResponseConver implements Conver<AdPositionResponse, AdPosition> {
    @Override
    public AdPositionResponse conver(AdPosition source) {
        AdPositionResponse result = new AdPositionResponse();
        BeanDataUtils.copyProperties(source,result);



        return result;
    }
}
