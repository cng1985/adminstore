package com.haoxuer.adminstore.analysis.list;

import com.haoxuer.adminstore.analysis.simple.DoubleName;
import com.haoxuer.discover.rest.base.ResponseList;
import lombok.Data;

@Data
public class DoubleList extends ResponseList<DoubleName> {

    private Double total;

    private String name;

}
