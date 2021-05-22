package com.nbsaas.adminstore.analysis.api;

import com.nbsaas.adminstore.analysis.list.LongList;
import com.nbsaas.adminstore.analysis.request.OrderNumRequest;

public interface UserAnalysisApi {

    LongList num(OrderNumRequest request);

    LongList month(OrderNumRequest request);

}
