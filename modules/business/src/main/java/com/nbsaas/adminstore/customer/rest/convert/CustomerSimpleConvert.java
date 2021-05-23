package com.nbsaas.adminstore.customer.rest.convert;

import com.nbsaas.adminstore.customer.api.domain.simple.CustomerSimple;
import com.nbsaas.adminstore.customer.data.entity.Customer;
import com.haoxuer.discover.data.rest.core.Conver;
public class CustomerSimpleConvert implements Conver<CustomerSimple, Customer> {


    @Override
    public CustomerSimple conver(Customer source) {
        CustomerSimple result = new CustomerSimple();

            result.setId(source.getId());
             result.setBeginDate(source.getBeginDate());
             result.setScore(source.getScore());
             result.setNote(source.getNote());
             result.setIntroducer(source.getIntroducer());
            if(source.getCreator()!=null){
               result.setCreator(source.getCreator().getId());
            }
             result.setPhone(source.getPhone());
             result.setLastDate(source.getLastDate());
             result.setName(source.getName());
             if(source.getCreator()!=null){
                result.setCreatorName(source.getCreator().getName());
             }
             result.setAddDate(source.getAddDate());

        return result;
    }
}
