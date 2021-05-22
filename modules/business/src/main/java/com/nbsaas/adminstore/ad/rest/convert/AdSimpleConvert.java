package com.nbsaas.adminstore.ad.rest.convert;

import com.nbsaas.adminstore.ad.api.domain.simple.AdSimple;
import com.nbsaas.adminstore.ad.data.entity.Ad;
import com.haoxuer.discover.data.rest.core.Conver;
public class AdSimpleConvert implements Conver<AdSimple, Ad> {


    @Override
    public AdSimple conver(Ad source) {
        AdSimple result = new AdSimple();

            result.setId(source.getId());
             result.setNote(source.getNote());
             result.setTitle(source.getTitle());
             result.setEndDate(source.getEndDate());
             result.setCatalog(source.getCatalog());
             result.setBussId(source.getBussId());
             result.setAddDate(source.getAddDate());
             result.setType(source.getType());
             result.setUrl(source.getUrl());
             result.setPath(source.getPath());
             result.setBeginDate(source.getBeginDate());
             result.setSortNum(source.getSortNum());
            if(source.getAdPosition()!=null){
               result.setAdPosition(source.getAdPosition().getId());
            }
             result.setLastDate(source.getLastDate());
             if(source.getAdPosition()!=null){
                result.setAdPositionName(source.getAdPosition().getName());
             }

             result.setTypeName(source.getType()+"");
        return result;
    }
}
