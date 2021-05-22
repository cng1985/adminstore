package com.nbsaas.adminstore.ad.rest.convert;

import com.nbsaas.adminstore.ad.api.domain.response.AdResponse;
import com.nbsaas.adminstore.ad.data.entity.Ad;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class AdResponseConvert implements Conver<AdResponse, Ad> {
    @Override
    public AdResponse conver(Ad source) {
        AdResponse result = new AdResponse();
        BeanDataUtils.copyProperties(source,result);

        if(source.getAdPosition()!=null){
           result.setAdPosition(source.getAdPosition().getId());
        }
         if(source.getAdPosition()!=null){
            result.setAdPositionName(source.getAdPosition().getName());
         }

         result.setTypeName(source.getType()+"");

        return result;
    }
}
