package com.tongna.adminstore.rest.resources;

import com.tongna.adminstore.rest.api.AdApi;
import com.tongna.adminstore.rest.domain.list.AdList;
import com.tongna.adminstore.rest.domain.request.AdListRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
