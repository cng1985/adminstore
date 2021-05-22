package com.nbsaas.adminstore.oa.rest.convert;

import com.nbsaas.adminstore.oa.api.domain.simple.WorkLoggerSimple;
import com.nbsaas.adminstore.oa.data.entity.WorkLogger;
import com.haoxuer.discover.data.rest.core.Conver;

public class WorkLoggerSimpleConvert implements Conver<WorkLoggerSimple, WorkLogger> {


    @Override
    public WorkLoggerSimple conver(WorkLogger source) {
        WorkLoggerSimple result = new WorkLoggerSimple();

            result.setId(source.getId());
             result.setNote(source.getNote());
             result.setTitle(source.getTitle());
            if(source.getCreator()!=null){
               result.setCreator(source.getCreator().getId());
            }
             result.setRecordDate(source.getRecordDate());
             result.setLastDate(source.getLastDate());
             if(source.getCreator()!=null){
                result.setCreatorName(source.getCreator().getName());
             }
             result.setAddDate(source.getAddDate());

        return result;
    }
}
