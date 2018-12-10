package com.quhaodian.adminstore.rest.resources;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.trade.data.dao.TradeAccountDao;
import com.haoxuer.discover.trade.data.entity.TradeAccount;
import com.haoxuer.discover.trade.data.others.ChangeType;
import com.haoxuer.discover.trade.data.request.TradeRequest;
import com.quhaodian.adminstore.data.dao.ConfigDao;
import com.quhaodian.adminstore.data.dao.MemberDao;
import com.quhaodian.adminstore.data.entity.Config;
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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;

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

  @Autowired
  TradeAccountDao accountDao;

  @Autowired
  ConfigDao configDao;


  @Transactional(isolation = Isolation.SERIALIZABLE )
  @Override
  public  ResponseObject demo() {
    ResponseObject result = new ResponseObject();
    Member member = memberDao.findById(1+(long) new Random().nextInt(6));
    TradeAccount account = member.getAccount();
    if (account == null) {
      account = accountDao.initNormal();
      member.setAccount(account);
    }
    Config config = configDao.config();
    TradeAccount from = config.getAccount();
    if (from == null) {
      from = accountDao.initSpecial();
      config.setAccount(from);
    }
    TradeRequest request = new TradeRequest();
    request.setAmount(new BigDecimal(new Random().nextInt(100000)));
    request.setChangeType(ChangeType.from(1, "demo"));
    request.setTo(account.getId());
    request.setFrom(from.getId());
    request.setNote("测试");
    accountDao.trade(request);
    return result;
  }
}
