package com.haoxuer.adminstore.member.rest.convert;

import com.haoxuer.adminstore.member.api.domain.response.MemberResponse;
import com.haoxuer.adminstore.member.data.entity.Member;
import com.haoxuer.discover.data.rest.core.Conver;
import com.haoxuer.discover.data.utils.BeanDataUtils;

public class MemberResponseConvert implements Conver<MemberResponse, Member> {
    @Override
    public MemberResponse conver(Member source) {
        MemberResponse result = new MemberResponse();
        BeanDataUtils.copyProperties(source,result);


         result.setStateName(source.getState()+"");

        return result;
    }
}
