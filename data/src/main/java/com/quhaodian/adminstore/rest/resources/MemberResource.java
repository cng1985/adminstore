package com.quhaodian.adminstore.rest.resources;

import com.haoxuer.discover.data.page.Filter;
import com.quhaodian.adminstore.data.dao.MemberDao;
import com.quhaodian.adminstore.data.entity.Member;
import com.quhaodian.adminstore.rest.api.MemberApi;
import com.quhaodian.adminstore.rest.conver.MemberSimpleConver;
import com.quhaodian.adminstore.rest.conver.PageableConver;
import com.quhaodian.adminstore.rest.domain.page.MemberPage;
import com.quhaodian.adminstore.rest.domain.request.MemberNameRequest;
import com.quhaodian.adminstore.rest.domain.request.MemberUpdateRequest;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.rest.base.RequestTokenPageObject;
import com.haoxuer.discover.rest.base.ResponseObject;
import com.haoxuer.discover.user.utils.ConverResourceUtils;
import com.haoxuer.discover.user.utils.UserUtils;
import jodd.util.StringUtil;
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
    ConverResourceUtils.coverPage(result, page, new MemberSimpleConver());
    return result;
  }

  @Override
  public ResponseObject update(MemberUpdateRequest request) {
    ResponseObject result = new ResponseObject();
    Long id = UserUtils.getApp(request.getUserToken());
    Member member = memberDao.findById(id);
    if (member == null) {
      result.setMsg("该用户不存在!");
      result.setCode(-101);
      return result;
    }
    if (StringUtil.isNotEmpty(request.getAvatar())) {
      member.setAvatar(request.getAvatar());
    }
    if (StringUtil.isNotEmpty(request.getSex())) {
      member.setSex(request.getSex());
    }
    if (StringUtil.isNotEmpty(request.getName())) {
      member.setName(request.getName());
    }
    if (StringUtil.isNotEmpty(request.getPhone())) {
      member.setPhone(request.getPhone());
    }
    if (StringUtil.isNotEmpty(request.getJob())) {
      member.setJob(request.getJob());
    }
    if (StringUtil.isNotEmpty(request.getCompanyName())) {
      member.setCompanyName(request.getCompanyName());
    }
    if (StringUtil.isNotEmpty(request.getIntroduce())) {
      member.setIntroduce(request.getIntroduce());
    }
    if (StringUtil.isNotEmpty(request.getEmail())) {
      member.setEmail(request.getEmail());
    }
    return result;
  }

  @Override
  public MemberPage name(MemberNameRequest request) {
    MemberPage result = new MemberPage();
    if (request.getName() == null) {
      request.setName("");
    }
    Pageable pageable = new PageableConver().conver(request);
    pageable.getFilters().add(Filter.like("name", request.getName()));
    Page<Member> page = memberDao.page(pageable);
    ConverResourceUtils.coverPage(result, page, new MemberSimpleConver());
    return result;
  }
}
