package com.nbsaas.adminstore.analysis.list;

import com.nbsaas.adminstore.analysis.simple.BigDecimalName;
import com.haoxuer.discover.rest.base.ResponseList;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BigDecimalList extends ResponseList<BigDecimalName> {

    private BigDecimal total;

    private String name;
}
