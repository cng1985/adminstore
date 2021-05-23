package com.nbsaas.adminstore.customer.rest.convert;

import com.nbsaas.adminstore.customer.api.domain.response.CustomerResponse;
import com.nbsaas.adminstore.customer.data.entity.Customer;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class CustomerResponseConvert implements Conver<CustomerResponse, Customer> {
    @Override
    public CustomerResponse conver(Customer source) {
        CustomerResponse result = new CustomerResponse();
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
