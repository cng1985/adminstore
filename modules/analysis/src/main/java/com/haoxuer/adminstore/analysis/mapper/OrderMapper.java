package com.haoxuer.adminstore.analysis.mapper;

import com.haoxuer.adminstore.analysis.simple.LongName;
import com.haoxuer.adminstore.analysis.request.OrderNumRequest;
import java.util.List;

public interface OrderMapper {

    List<LongName> num(OrderNumRequest request);

    List<LongName> month(OrderNumRequest request);

}
