package com.haoxuer.adminstore.ad.rest.conver;

import com.haoxuer.adminstore.ad.api.domain.simple.AdPositionSimple;
import com.haoxuer.adminstore.ad.data.entity.AdPosition;
import com.haoxuer.discover.data.rest.core.Conver;


public class AdPositionSimpleConver implements Conver<AdPositionSimple, AdPosition> {
    @Override
    public AdPositionSimple conver(AdPosition source) {
        AdPositionSimple result = new AdPositionSimple();
        result.setId(source.getId());
         result.setNote(source.getNote());
         result.setTemplate(source.getTemplate());
         result.setSortNum(source.getSortNum());
         result.setName(source.getName());
         result.setWidth(source.getWidth());
         result.setAddDate(source.getAddDate());
         result.setHeight(source.getHeight());


        return result;
    }
}