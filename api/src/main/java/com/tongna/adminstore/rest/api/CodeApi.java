package com.tongna.adminstore.rest.api;

import com.tongna.adminstore.rest.domain.base.AbstractVo;
import com.tongna.adminstore.rest.domain.dto.CodeSendDto;

/**
 * Created by ada on 2016/12/19.
 */
public interface CodeApi {

    AbstractVo send(CodeSendDto dto);
}
