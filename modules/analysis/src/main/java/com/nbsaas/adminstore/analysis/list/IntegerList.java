package com.nbsaas.adminstore.analysis.list;

import com.nbsaas.adminstore.analysis.simple.IntegerName;
import com.haoxuer.discover.rest.base.ResponseList;
import lombok.Data;

@Data
public class IntegerList extends ResponseList<IntegerName> {

    private  Long total;

    private String name;

}
