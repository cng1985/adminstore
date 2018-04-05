package com.quhaodian.adminstore.data.service.impl;

import com.quhaodian.adminstore.data.dao.MemberDao;
import com.quhaodian.adminstore.data.entity.Member;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.quhaodian.data.utils.FilterUtils;
import com.quhaodian.user.data.dao.UserAccountDao;
import com.quhaodian.user.data.entity.UserAccount;
import com.quhaodian.user.data.vo.UserAccountVo;
import com.quhaodian.adminstore.data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private MemberDao dao;

    @Autowired
    private UserAccountDao accountDao;


    @Override
    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return dao.findById(id);
    }


    @Override
    @Transactional
    public Member save(Member bean) {
        dao.save(bean);
        return bean;
    }

    @Override
    public UserAccountVo reg(UserAccount account, Member member) {
        Member temp = null;
        UserAccountVo vo = accountDao.reg(account);
        if (vo.getCode() == 0) {
            temp = dao.findById(vo.getUser());
            if (temp!=null){
                temp.setName(member.getName());
            }
        }
        return vo;
    }

    @Override
    @Transactional
    public Member update(Member bean) {
        Updater<Member> updater = new Updater<Member>(bean);
        updater.exclude("attributes");
        updater.exclude("roles");
        return dao.updateByUpdater(updater);
    }

    @Override
    @Transactional
    public Member deleteById(Long id) {
        Member bean = dao.findById(id);
        dao.deleteById(id);
        return bean;
    }

    @Override
    @Transactional
    public Member[] deleteByIds(Long[] ids) {
        Member[] beans = new Member[ids.length];
        for (int i = 0, len = ids.length; i < len; i++) {
            beans[i] = deleteById(ids[i]);
        }
        return beans;
    }


    @Autowired
    public void setDao(MemberDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Member> findPage(Pageable pageable) {
        return dao.findPage(pageable);
    }

    @Override
    public Page<Member> page(Pageable pageable) {
        return dao.page(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Filter... filters) {
        return dao.count(filters);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Member> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
        return dao.findList(first, count, filters, orders);
    }

    @Override
    public Page<Member> page(Pageable pageable, Object search) {
        List<Filter> filters = FilterUtils.getFilters(search);
        if (filters != null) {
            pageable.getFilters().addAll(filters);
        }
        return dao.page(pageable);
    }
}