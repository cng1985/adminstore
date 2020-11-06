package com.haoxuer.adminstore.analysis.resource;

import com.haoxuer.adminstore.analysis.api.UserAnalysisApi;
import com.haoxuer.adminstore.analysis.list.LongList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.haoxuer.adminstore.analysis.mapper.UserMapper;
import com.haoxuer.adminstore.analysis.request.OrderNumRequest;

@Transactional
@Component
public class UserAnalysisResource implements UserAnalysisApi {

    @Autowired
    private UserMapper orderMapper;

    @Override
    public LongList num(OrderNumRequest request) {
        LongList result = new LongList();
        result.setList(orderMapper.num(request));
        if (result.getList() != null) {
            Long total = result.getList().stream().mapToLong(item -> item.getNum()).sum();
            result.setTotal(total);
        } else {
            result.setTotal(0L);
        }
        result.setName("人员数量");
        return result;
    }

    @Override
    public LongList month(OrderNumRequest request) {
        LongList result = new LongList();
        result.setList(orderMapper.month(request));
        if (result.getList() != null) {
            Long total = result.getList().stream().mapToLong(item -> item.getNum()).sum();
            result.setTotal(total);
        } else {
            result.setTotal(0L);
        }
        result.setName("人员数量");
        return result;
    }
}
