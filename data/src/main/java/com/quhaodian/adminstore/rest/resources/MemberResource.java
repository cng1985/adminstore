package com.quhaodian.adminstore.rest.resources;

import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.quhaodian.discover.rest.base.RequestTokenPageObject;
import com.quhaodian.user.utils.ConverResourceUtils;
import com.quhaodian.adminstore.data.dao.MemberDao;
import com.quhaodian.adminstore.data.entity.Member;
import com.quhaodian.adminstore.rest.api.MemberApi;
import com.quhaodian.adminstore.rest.conver.MemberSimpleConver;
import com.quhaodian.adminstore.rest.conver.PageableConver;
import com.quhaodian.adminstore.rest.domain.page.MemberPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class MemberResource implements MemberApi {

    @Autowired
    private MemberDao memberDao;

    @Override
    public MemberPage page(RequestTokenPageObject request) {
        MemberPage result = new MemberPage();
        Pageable pageable = new PageableConver().conver(request);
        Page<Member> page = memberDao.page(pageable);
        ConverResourceUtils.coverPage(result,page,new MemberSimpleConver());
        return result;
    }
}
