package com.nbsaas.adminstore.analysis.mapper;

import com.nbsaas.adminstore.analysis.request.OrderNumRequest;
import com.nbsaas.adminstore.analysis.simple.LongName;

import java.util.List;

public interface UserMapper {

    List<LongName> num(OrderNumRequest request);

    List<LongName> month(OrderNumRequest request);
}
