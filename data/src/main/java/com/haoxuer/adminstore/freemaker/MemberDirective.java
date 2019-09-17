package com.haoxuer.adminstore.freemaker;

import com.haoxuer.adminstore.data.entity.Member;
import com.haoxuer.adminstore.data.service.MemberService;
import com.haoxuer.discover.common.freemarker.ListDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("memberDirective")
public class MemberDirective extends ListDirective<Member> {

    @Autowired
    private MemberService memberService;

    @Override
    public List<Member> list() {
        return memberService.findList(0,10,null,null);
    }
}
