package com.nbsaas.adminstore.analysis.mapper;

import com.nbsaas.adminstore.analysis.simple.LongName;
import com.nbsaas.adminstore.analysis.request.OrderNumRequest;

import java.util.List;

public interface OrderMapper {

    List<LongName> num(OrderNumRequest request);

    List<LongName> month(OrderNumRequest request);

}
