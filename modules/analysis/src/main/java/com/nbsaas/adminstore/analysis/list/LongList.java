package com.nbsaas.adminstore.analysis.list;

import com.nbsaas.adminstore.analysis.simple.LongName;
import com.haoxuer.discover.rest.base.ResponseList;
import lombok.Data;

@Data
public class LongList extends ResponseList<LongName> {

    private Long total;

    private String name;

}
