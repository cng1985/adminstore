package com.haoxuer.adminstore.analysis.mapper;

import com.haoxuer.adminstore.analysis.request.OrderNumRequest;
import com.haoxuer.adminstore.analysis.simple.LongName;

import java.util.List;

public interface UserMapper {

    List<LongName> num(OrderNumRequest request);

    List<LongName> month(OrderNumRequest request);
}
