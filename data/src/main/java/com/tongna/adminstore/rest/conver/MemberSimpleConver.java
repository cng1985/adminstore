package com.tongna.adminstore.rest.conver;

import com.quhaodian.data.rest.core.Conver;
import com.tongna.adminstore.data.entity.Member;
import com.tongna.adminstore.rest.domain.simple.MemberSimple;

public class MemberSimpleConver implements Conver<MemberSimple, Member> {
    @Override
    public MemberSimple conver(Member source) {
        MemberSimple result = new MemberSimple();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
