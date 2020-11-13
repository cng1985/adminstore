package com.haoxuer.adminstore.analysis.list;

import com.haoxuer.adminstore.analysis.simple.FloatName;
import com.haoxuer.discover.rest.base.ResponseList;
import lombok.Data;

@Data
public class FloatList extends ResponseList<FloatName> {

    private Float total;

    private String name;

}
