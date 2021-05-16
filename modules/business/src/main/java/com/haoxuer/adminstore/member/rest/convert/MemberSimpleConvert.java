package com.haoxuer.adminstore.member.rest.convert;

import com.haoxuer.adminstore.member.api.domain.simple.MemberSimple;
import com.haoxuer.adminstore.member.data.entity.Member;
import com.haoxuer.discover.data.rest.core.Conver;
public class MemberSimpleConvert implements Conver<MemberSimple, Member> {


    @Override
    public MemberSimple conver(Member source) {
        MemberSimple result = new MemberSimple();

            result.setId(source.getId());
             result.setNo(source.getNo());
             result.setNote(source.getNote());
             result.setSex(source.getSex());
             result.setCatalog(source.getCatalog());
             result.setIntroduce(source.getIntroduce());
             result.setAvatar(source.getAvatar());
             result.setLoginSize(source.getLoginSize());
             result.setAddDate(source.getAddDate());
             result.setPhone(source.getPhone());
             result.setLastDate(source.getLastDate());
             result.setName(source.getName());
             result.setState(source.getState());
             result.setJob(source.getJob());

             result.setStateName(source.getState()+"");
        return result;
    }
}
