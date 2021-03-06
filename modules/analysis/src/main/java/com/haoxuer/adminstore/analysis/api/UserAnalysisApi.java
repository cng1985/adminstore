package com.haoxuer.adminstore.analysis.api;

import com.haoxuer.adminstore.analysis.list.LongList;
import com.haoxuer.adminstore.analysis.request.OrderNumRequest;

public interface UserAnalysisApi {

    LongList num(OrderNumRequest request);

    LongList month(OrderNumRequest request);

}
