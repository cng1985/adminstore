package com.quhaodian.adminstore.rest.resources;

import com.quhaodian.adminstore.rest.api.AdApi;
import com.quhaodian.adminstore.rest.domain.list.AdList;
import com.quhaodian.adminstore.rest.domain.request.AdListRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component
public class AdResource implements AdApi {



    @Override
    public AdList list(AdListRequest request) {
        return null;
    }
}
