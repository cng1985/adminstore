package com.haoxuer.adminstore.common.rest.convert;

import com.haoxuer.adminstore.common.api.domain.simple.StoreConfigSimple;
import com.haoxuer.adminstore.common.data.entity.StoreConfig;
import com.haoxuer.discover.data.rest.core.Conver;
public class StoreConfigSimpleConvert implements Conver<StoreConfigSimple, StoreConfig> {


    @Override
    public StoreConfigSimple conver(StoreConfig source) {
        StoreConfigSimple result = new StoreConfigSimple();

            result.setId(source.getId());
             result.setPhone(source.getPhone());
             result.setLastDate(source.getLastDate());
             result.setName(source.getName());
             result.setAddDate(source.getAddDate());

        return result;
    }
}
