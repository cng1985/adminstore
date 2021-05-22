package com.nbsaas.adminstore.oa.rest.convert;

import com.nbsaas.adminstore.oa.api.domain.response.WorkLoggerResponse;
import com.nbsaas.adminstore.oa.data.entity.WorkLogger;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class WorkLoggerResponseConvert implements Conver<WorkLoggerResponse, WorkLogger> {
    @Override
    public WorkLoggerResponse conver(WorkLogger source) {
        WorkLoggerResponse result = new WorkLoggerResponse();
        BeanDataUtils.copyProperties(source,result);

        if(source.getCreator()!=null){
           result.setCreator(source.getCreator().getId());
        }
         if(source.getCreator()!=null){
            result.setCreatorName(source.getCreator().getName());
         }


        return result;
    }
}
