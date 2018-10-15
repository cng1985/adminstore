package com.quhaodian.adminstore.rest.conver;

import com.quhaodian.adminstore.data.entity.Member;
import com.quhaodian.adminstore.rest.domain.simple.MemberSimple;
import com.haoxuer.discover.data.rest.core.Conver;

public class MemberSimpleConver implements Conver<MemberSimple, Member> {
  @Override
  public MemberSimple conver(Member source) {
    MemberSimple result = new MemberSimple();
    result.setId(source.getId());
    result.setName(source.getName());
    return result;
  }
}
